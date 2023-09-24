package kr.co.laura.security.repositoryQFun;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.laura.security.domain.FundingBoard;
import kr.co.laura.security.domain.QFundingBoard;
import kr.co.laura.security.domain.QFundingParti;
import kr.co.laura.security.domain.QMem;
import kr.co.laura.security.dto.FunCountDTO;
import kr.co.laura.security.dto.FundingDTO;
import kr.co.laura.security.dto.MemCountDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QFunRepositoryImpl implements QFunRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;

	@PersistenceContext
	private EntityManager em;

	// 지난주 새로 오픈한 펀딩 수 옛날꺼
	public List<Long> getLastWeekNewFunding2(Date startDate, Date endDate) {
		QFundingBoard qfun = QFundingBoard.fundingBoard;
		return jpaQueryFactory.select(qfun.sdate.count()).from(qfun).where(qfun.sdate.between(startDate, endDate))
				.groupBy(qfun.sdate).fetch();

	}

	// 지난주 새 오픈 펀딩 수 : 데이터 뽑기에 필요
	private String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	// 지난수 새로 오픈한 펀딩 수 다시
	public List<FunCountDTO> getLastWeekNewFunding() {
		
		QFundingBoard qFun = QFundingBoard.fundingBoard;

		// 오늘날짜 가져오기
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -7); // 오늘로부터 7일 전
		Date startDate = calendar.getTime();

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(new Date());
		calendar2.add(Calendar.DATE, -1); // 어제
		List<FunCountDTO> result = new ArrayList<>();

		// 7일치 데이터를 생성
		calendar.setTime(startDate);
		for (int i = 0; i < 7; i++) {
			Date currentDate = calendar.getTime(); // 요기 날짜 변환
			String formattedCurrentDate = formatDate(currentDate);

			Long countNewOpenFundingLastWeek = jpaQueryFactory
					.select(qFun.funnum.count().as("countNewFundings")).from(qFun)
					.where(Expressions
							.stringTemplate("TO_CHAR({0}, 'YYYY-MM-DD')", qFun.sdate)
							.eq(formattedCurrentDate))
					.fetchOne();

			FunCountDTO dto = new FunCountDTO(countNewOpenFundingLastWeek, formattedCurrentDate);
			result.add(dto);
			calendar.add(Calendar.DATE, 1); // 다음 날로 이동
		} // for문 끝

		return result;

	}

	// 대쉬보드 11 모인 금액이 가장 많은 상위 6개 펀딩 게시글
	// 1 참여 액수가 가장 많은 상위 6개 펀딩 게시글

	public List<FundingDTO> showTop6FundingsByFunMoney() {
		QFundingBoard qFun = QFundingBoard.fundingBoard;
		QFundingParti qFp = QFundingParti.fundingParti;

		// fmoney의 합이 가장 높은 6개의 펀딩 게시글을 가져옵니다.
		List<FundingDTO> top6FundingList = jpaQueryFactory
				.select(Projections.constructor(FundingDTO.class, qFun.funnum, qFun.funtitle, qFun.funwriter,
						qFun.targetprice, qFp.funmoney.sum().as("totalFunMoney")))
				.from(qFun).leftJoin(qFp).on(qFun.funnum.eq(qFp.funnum_num)).where(qFun.funnum.eq(qFp.funnum_num)) // 특정
																													// funnum에
																													// 대한
																													// 필터링
																													// 추
				.groupBy(qFun.funnum, qFun.funtitle, qFun.funwriter, qFun.targetprice)
				.orderBy(qFp.funmoney.sum().desc()).limit(6).fetch();

		return top6FundingList;

	}

	// 3 펀딩 목표 달성률 계산 마무리
	public List<Long> calFundingAchieveRates(List<FundingDTO> top6FundingList) {
		List<Long> achievementRates = new ArrayList<>();
		for (FundingDTO dto : top6FundingList) {
			Long funnum = dto.getFunnum(); // 또는 dto에서 funnum을 가져오는 방법에 따라 다를 수 있음
			Long achievementRate = calFundingAchieve(funnum);
			achievementRates.add(achievementRate);
		}
		return achievementRates;
	}

	// 2 펀딩 목표달성률 계산
	public Long calFundingAchieve(Long funnum) {

		// FUNDING_PARTI 테이블에서 해당 펀딩 글 (funnum) 에 대한 총 펀딩 금액을 계산
		QFundingBoard qfun = QFundingBoard.fundingBoard;
		QFundingParti qfpati = QFundingParti.fundingParti;

		// Long funnum
		// FBOARD 테이블에서 해당 펀딩 글 (funnum) 의 목표 금액 (targetprice)을 가져온다
		Long targetPrice = jpaQueryFactory.select(qfun.targetprice).from(qfun).where(qfun.funnum.eq(funnum))
				.orderBy(qfun.sdate.desc()).limit(6).fetchOne();

		if (targetPrice == null || targetPrice <= 0L) {
			return 0L;
		}

		Long totalFundingAmount = jpaQueryFactory.select(qfpati.funmoney.sum()).from(qfpati)
				.where(qfpati.funnum_num.eq(funnum)).fetchOne();

		if (totalFundingAmount == null) {
			totalFundingAmount = 0L;
		}

		// 펀딩 금액 달성률을 계산
		Long achievementRate = (totalFundingAmount * 100L) / targetPrice;
		return achievementRate;

	}


	/*
	 * //2. 최신 6개 펀딩이 뜨도록 public List<FundingBoard> findTop6OrderBySdateDesc(){
	 * 
	 * QFundingBoard qfun = QFundingBoard.fundingBoard;
	 * 
	 * return jpaQueryFactory .selectFrom(qfun) .orderBy(qfun.sdate.desc())
	 * .limit(6) .fetch();
	 * 
	 * }
	 */

}
