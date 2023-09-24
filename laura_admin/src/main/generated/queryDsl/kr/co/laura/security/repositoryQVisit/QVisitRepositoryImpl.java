package kr.co.laura.security.repositoryQVisit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.laura.security.domain.QVisit;
import kr.co.laura.security.dto.VisitDTO;
import lombok.RequiredArgsConstructor;
import oracle.net.aso.q;

@RequiredArgsConstructor
@Repository
public class QVisitRepositoryImpl implements QVisitRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	

	//대쉬보드 1. 오늘의 방문자 수 
	@Override
	public VisitDTO countByVisitDate() {
		QVisit qvisit = QVisit.visit;
		VisitDTO result = new VisitDTO();
		
		// 오늘날짜 가져오기
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Date today = calendar.getTime();
		Long visitorCount = 0L; // 방문자수 초기값 0으로 설정
		
		visitorCount = jpaQueryFactory.select(qvisit.countNum.sum()).from(qvisit).where(qvisit.visitDate.eq(today))
				.fetchOne();
		
		if (visitorCount == null) {
			visitorCount = 0L;
		}
		
		result.setVisitDate(today);
		result.setVisitorCount(visitorCount);
		
		return result;

	}

	// 대쉬보드 2.분홍차트 7일전-어제까지의 날까 +방문자 수 2개 같이 구하기 (세션 아니고)
	@Override
	public List<VisitDTO> showLastWeekCountVisitWithDate() {
		QVisit qvisit = QVisit.visit;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -7); // 오늘로부터 7일 전
		Date startDate = calendar.getTime();

		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1); // 어제
		List<VisitDTO> result = new ArrayList<>();

		// 7일치 데이터를 생성
		calendar.setTime(startDate);
		for (int i = 0; i < 7; i++) {
			Date currentDate = calendar.getTime();
			Long visitorCount = 0L; // 초기값 0으로 설정

			List<Long> visitCounts = jpaQueryFactory.
					select(qvisit.countNum.sum()).from(qvisit)
					.where(qvisit.visitDate.eq(currentDate)).fetch();

			if (!visitCounts.isEmpty()) {
				visitorCount = visitCounts.get(0);
			}
			// DTO가 핵심
			VisitDTO dto = new VisitDTO(currentDate, visitorCount);
			result.add(dto);
			calendar.add(Calendar.DATE, 1); // 다음 날로 이동
		} // for문 끝

		return result;
	}

}
