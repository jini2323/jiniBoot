package kr.co.laura.security.repositoryQMem;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.QMem;
import kr.co.laura.security.dto.MemDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QMemRepositoryImpl implements QMemRepositoryCustom {
	
	private final JPAQueryFactory jpaQueryFactory;
	
	
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

	//새로 인증한 회원 목록
	@Override
	public List<MemDTO> getNewConfirmed() {
		QMem qmem = QMem.mem;
		
		List<MemDTO> confirmedMems = jpaQueryFactory
		.select(Projections.constructor(MemDTO.class,
				qmem.num,
				qmem.email,
				qmem.name,
			    qmem.nickname,
			    qmem.tel,
			    qmem.memgender,
			    qmem.birthday,
			    qmem.profilepic,
			    qmem.mdate,
			    qmem.grade,
			    qmem.arstatus,
			    qmem.addr,
			    qmem.bankaccount,
			    qmem.arprofilepic,
			    qmem.arprofile,
			    qmem.ardate,
			    qmem.point))
		.from(qmem)
		.where(qmem.arstatus.eq("인증"))
		.orderBy(qmem.ardate.desc())
		.limit(6)
		.fetch();
		
		
		return confirmedMems;
	}
	
	
	
	
	
	
	
	

}
