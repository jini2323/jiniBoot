package kr.co.laura.security.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Visit;
import kr.co.laura.security.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class VisitService {
	
	@Autowired
	private final VisitRepository visitRepository;
	
	//오늘 하루 방문자 수 구하기 
	
	public Long todayCount(){
		Date today = new Date();
		//Optional<Visit> findOne = visitRepository.findOne(null);
		//return visitRepository.findByVisitDate(today);
		//return visitRepository.findByVisitDate(today);
		return visitRepository.countByVisitDate(today);
	} 
	
	/*
	 * public Optional<Visit> todayCount(){ Date today = new Date(); Optional<Visit>
	 * visit = visitRepository.findByVisitDate(today);
	 * 
	 * if (visit.isPresent()) { return visit; } else { // 데이터가 없을 때 원하는 처리를 할 수 있음
	 * return Optional.empty(); // 또는 다른 기본값 설정 } }
	 */
	
	//저번주  방문자 수 구하기
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
	      System.out.println("서비스previousWeekStart : "+previousWeekStart);
	      System.out.println("서비스 previousWeekEnd: "+previousWeekEnd);
	      
	      return visitRepository.countByVisitDateBetween(startDate, endDate);
		
	}
	

	

}
