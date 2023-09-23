package kr.co.laura.security.repositoryQVisit;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.laura.security.domain.QVisit;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Repository
public class QVisitRepositoryImpl implements QVisitRepositoryCustom {
	
	private final JPAQueryFactory jpaQueryFactory;

	
	//지난주 방문자 수 차트 
	@Override
	public List<Long> showLastWeekCountVisit(Date startDate, Date endDate) {
		QVisit qvisit = QVisit.visit;
		
		return jpaQueryFactory
				 .select(qvisit.countNum.sum()) // 방문자 수를 그룹화해서 합산
		         .from(qvisit)
		         .where(qvisit.visitDate.between(startDate, endDate))
		         .groupBy(qvisit.visitDate)
		         .fetch();
		
	}
	
	
	
	
	
	
	

}
