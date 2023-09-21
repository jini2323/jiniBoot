package kr.co.laura.security.repositoryQMem;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.QMem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QMemRepositoryImpl implements QMemRepositoryCustom {
	
	
	private final JPAQueryFactory jpaQueryFactory;
	
	
	/*
	@Override
	public List<Mem> getMemList(Mem mem) {
		
		QMem qmem = QMem.mem;
		return jpaQueryFactory
				.selectFrom(qmem)
				.fetch();
	}
	*/
	
	@Override
	public List<Long> getLastWeekNewMem(Date startDate, Date endDate) {
		
		QMem qmem = QMem.mem;
		
		return jpaQueryFactory
				.select(qmem.mdate.count())
                .from(qmem)
                .where(qmem.mdate.between(startDate, endDate))
                .groupBy(qmem.mdate)
                .fetch();
	}
	
	
	
	
	

}
