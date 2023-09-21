package kr.co.laura.security.repositoryQFun;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.laura.security.domain.QFundingBoard;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QFunRepositoryImpl implements QFunRepositoryCustom {
	
	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<Long> getLastWeekNewFunding(Date startDate, Date endDate) {
		QFundingBoard qfun = QFundingBoard.fundingBoard;
		return jpaQueryFactory
				.select(qfun.sdate.count())
				.from(qfun)
				.where(qfun.sdate.between(startDate, endDate))
				.groupBy(qfun.sdate)
				.fetch();
				
	}
	
	
	

}
