package kr.co.laura.security.repositoryQMem;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
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
	
	
	// 시간 정보를 00:00:00으로 설정하는 메서드
	private Date setTimeToMidnight(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
	
	
	//지난주 새 가입 회원 수 
	@Override
	public List<Long> getLastWeekNewMem(Date startDate, Date endDate) {
		
	    QMem qmem = QMem.mem;

	    // startDate와 endDate를 java.sql.Timestamp로 변환
	    java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(startDate.getTime());
	    java.sql.Timestamp sqlEndDate = new java.sql.Timestamp(endDate.getTime());
	    
	    return jpaQueryFactory
	            .select(qmem.mdate.count())
	            .from(qmem)
	            .where(qmem.mdate.between(sqlStartDate, sqlEndDate))
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
