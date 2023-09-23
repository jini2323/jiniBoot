package kr.co.laura.security.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.repository.VisitRepository;
import kr.co.laura.security.repositoryQVisit.QVisitRepositoryImpl;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class VisitService {
	
	@Autowired
	private final VisitRepository visitRepository;
	
	@Autowired
	private final QVisitRepositoryImpl qvisitRepository;
	
	//오늘 하루 방문자 수 구하기 
	public Long todayCount(){
		Date today = new Date();
		return visitRepository.countByVisitDate(today);
	} 
	
	
	public List<Long> weekCount(){
	    LocalDate today = LocalDate.now();
	    // 현재 날짜의 요일을 가져옴 (1: 월요일, 2: 화요일, ...)
	    int currentDayOfWeek = today.getDayOfWeek().getValue();

	    // 현재 날짜를 기준으로 이전 주의 월요일과 일요일을 계산
	    LocalDate previousWeekStart = today.minusDays(currentDayOfWeek).minusWeeks(1).plusDays(1);
	    LocalDate previousWeekEnd = today.minusDays(currentDayOfWeek);

	    // LocalDate를 Date로 변환
	    Date startDate = java.sql.Date.valueOf(previousWeekStart);
	    Date endDate = java.sql.Date.valueOf(previousWeekEnd);

	    System.out.println("서비스 startDate : "+startDate);
	    System.out.println("서비스 endDate : "+endDate);
	    System.out.println("서비스 today : "+today);
	    System.out.println("서비스 previousWeekStart : "+previousWeekStart);
	    System.out.println("서비스 previousWeekEnd: "+previousWeekEnd);

	    // 7일간의 방문 레코드 조회
	    List<Long> visitLastWeeks = qvisitRepository.showLastWeekCountVisit(startDate, endDate);


	    return visitLastWeeks;
	}
	
	
	

	

}
