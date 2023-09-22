package kr.co.laura.security.repositoryQFun;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.annotation.PostConstruct;
import kr.co.laura.security.domain.FundingBoard;
import kr.co.laura.security.domain.QFundingBoard;
import kr.co.laura.security.domain.QFundingParti;
import kr.co.laura.security.dto.FundingDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QFunRepositoryImpl implements QFunRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;

	// private static List<FundingBoard> funNew6Nums = new ArrayList<>();

	// 지난주 새로 오픈한 펀딩 수
	@Override
	public List<Long> getLastWeekNewFunding(Date startDate, Date endDate) {
		QFundingBoard qfun = QFundingBoard.fundingBoard;
		return jpaQueryFactory.select(qfun.sdate.count()).from(qfun).where(qfun.sdate.between(startDate, endDate))
				.groupBy(qfun.sdate).fetch();
	}

	
	
	
	public List<FundingDTO> showTop6FundingsByFunMoney() {
	    QFundingBoard qFun = QFundingBoard.fundingBoard;
	    QFundingParti qFp = QFundingParti.fundingParti;

	    // fmoney의 합이 가장 높은 6개의 펀딩 게시글을 가져옵니다.
		/*
		 * List<Tuple> top6FundingTuples = jpaQueryFactory .select(qFun.funtitle,
		 * qFun.funwriter, qFun.targetprice, qFp.funmoney.sum().as("totalFunMoney"))
		 * .from(qFun) .leftJoin(qFp).on(qFun.funnum.eq(qFp.funnum_num))
		 * .groupBy(qFun.funtitle, qFun.funwriter, qFun.targetprice)
		 * .orderBy(qFp.funmoney.sum().desc()) .limit(6) .fetch();
		 */
	    
	    List<FundingDTO> top6FundingList = jpaQueryFactory
	            .select(Projections.constructor(
	                FundingDTO.class,
	                qFun.funtitle,
	                qFun.funwriter,
	                qFun.targetprice,
	                qFp.funmoney.sum().as("totalFunMoney")))
	            .from(qFun)
	            .leftJoin(qFp).on(qFun.funnum.eq(qFp.funnum_num))
	            .groupBy(qFun.funtitle, qFun.funwriter, qFun.targetprice)
	            .orderBy(qFp.funmoney.sum().desc())
	            .limit(6)
	            .fetch();
	    

	    return top6FundingList;
	    
	}
	
	

	// 2 펀딩 목표달성률 계산
	public Long calFundingAchieveRate(Long funnum) {

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
