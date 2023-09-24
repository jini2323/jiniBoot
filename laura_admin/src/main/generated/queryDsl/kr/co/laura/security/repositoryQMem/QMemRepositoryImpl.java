package kr.co.laura.security.repositoryQMem;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.QMem;
import kr.co.laura.security.dto.MemCountDTO;
import kr.co.laura.security.dto.MemDTO;
import kr.co.laura.security.dto.VisitDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QMemRepositoryImpl implements QMemRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	
	 	@PersistenceContext
	    private EntityManager em;

	    private final QMem qmem = QMem.mem;

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


	
	private String formatDate(Date date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    return dateFormat.format(date);
	}
	
	
	
	public List<MemCountDTO> getLastWeekNewMem1() {
	    QMem qmem = QMem.mem;
	    
	 // 오늘날짜 가져오기
	    Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -7); // 오늘로부터 7일 전
		Date startDate = calendar.getTime();
		
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(new Date());
		calendar2.add(Calendar.DATE, -1); // 어제
		List<MemCountDTO> result = new ArrayList<>();

		// 7일치 데이터를 생성
		calendar.setTime(startDate);
		for (int i = 0; i < 7; i++) {
			Date currentDate = calendar.getTime();  //요기 날짜 변환 
			String formattedCurrentDate = formatDate(currentDate);
			
			//Long countVisitorLastWeek = 0L; // 초기값 0으로 설정
			
					
		//Expression<String> formattedDate = Expressions.stringTemplate("TO_CHAR({0}, 'YYYY-MM-DD')", qmem.mdate);
			//System.out.println("qm 리지스토리 formattedDate:"+formattedDate);
		
			
			Long countNewmemLastWeek = jpaQueryFactory //결과물이 [56,56,56,56,56...]
							.select(qmem.num.count().as("countVisitor"))
							.from(qmem)
							//.where(qmem.mdate.eq(currentDate))
							.where(Expressions.stringTemplate("TO_CHAR({0}, 'YYYY-MM-DD')", qmem.mdate)
									.eq(formattedCurrentDate))
							.fetchOne();
			
		//	if (!countVisitorLastWeeks.isEmpty()) {
		//		countVisitorLastWeeks = countVisitorLastWeeks.get(0);
		//	}
			
			//아래 날짜는 시간 포함되어 나오고, count는 전체 회원수가 출력 된다. 
			//for (Long count : countVisitorLastWeeks) {
			//    System.out.println("countVisitorLastWeeks 출력: " + "currentDate :"+currentDate + ": " + "count :"+count);
			//}	
			MemCountDTO dto = new MemCountDTO(countNewmemLastWeek,formattedCurrentDate);
			result.add(dto);
			calendar.add(Calendar.DATE, 1); // 다음 날로 이동
		} // for문 끝

		return result;
					
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//지난주 새 회원수 
	
	public List<Long> getLastWeekNewMem4() {
	    QMem qmem = QMem.mem;

	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());

	    // 오늘로부터 7일 전을 endDate로 설정
	    Date endDate = calendar.getTime();
	    calendar.add(Calendar.DATE, -7);
	    Date startDate = calendar.getTime();

	    // startDate부터 endDate까지의 날짜 목록 생성
	    List<Date> dateRange = new ArrayList<>();
	    calendar.setTime(startDate);
	    while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
	        dateRange.add(calendar.getTime());
	        calendar.add(Calendar.DATE, 1);
	    }

	    // 각 날짜별로 새 회원 수 가져오기
	    List<Long> newMemsLastWeek = new ArrayList<>();
	    for (Date currentDate : dateRange) {
	        Long newMemsCount = new JPAQueryFactory(em)
	            .select(qmem.count())
	            .from(qmem)
	            .where(qmem.mdate.between(currentDate, currentDate))
	            .fetchOne();
	        if (newMemsCount == null) {
	            newMemsCount = 0L;
	        }
	        newMemsLastWeek.add(newMemsCount);
	    }

	    return newMemsLastWeek;
	}
	
	
	
	
	//어제꺼 정 안되면 이걸로 
	public List<Long> getLastWeekNewMem6(Date startDate, Date endDate) {
		
		QMem qmem = QMem.mem;
		
		return jpaQueryFactory
				.select(qmem.mdate.count())
                .from(qmem)
                .where(qmem.mdate.between(startDate, endDate))
                .groupBy(qmem.mdate)
                .fetch();
	}
	
	
	
	
	
	
	@Override
	public List<Long> getLastWeekNewMem(Date startDate, Date endDate) {

		QMem qmem = QMem.mem;

		// startDate와 endDate를 java.sql.Timestamp로 변환
		java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(startDate.getTime());
		java.sql.Timestamp sqlEndDate = new java.sql.Timestamp(endDate.getTime());

		return jpaQueryFactory.select(qmem.mdate.count()).from(qmem).where(qmem.mdate.between(sqlStartDate, sqlEndDate))
				.groupBy(qmem.mdate).fetch();

	}

	// 새로 인증한 회원 목록
	@Override
	public List<MemDTO> getNewConfirmed() {
		QMem qmem = QMem.mem;

		List<MemDTO> confirmedMems = jpaQueryFactory
				.select(Projections.constructor(MemDTO.class, qmem.num, qmem.email, qmem.name, qmem.nickname, qmem.tel,
						qmem.memgender, qmem.birthday, qmem.profilepic, qmem.mdate, qmem.grade, qmem.arstatus,
						qmem.addr, qmem.bankaccount, qmem.arprofilepic, qmem.arprofile, qmem.ardate, qmem.point))
				.from(qmem).where(qmem.arstatus.eq("인증")).orderBy(qmem.ardate.desc()).limit(6).fetch();

		return confirmedMems;
	}

}
