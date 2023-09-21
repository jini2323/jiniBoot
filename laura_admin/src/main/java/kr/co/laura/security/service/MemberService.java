package kr.co.laura.security.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	@Autowired
	private final MemberRepository memRepository;
	
	//@Autowired
	//private final MemCountRepository memCountRepository;

	// 멤버리스트
	public List<Mem> showMemList() {
		return memRepository.findAll();
	}

	//오늘 가입한 회원 수 
	public Long todayNewMem() {
		Long todayNewMem  = memRepository.countTodayNewMembers();
		return todayNewMem;
	}
	
	//지난 주  새 회원 수 차트
	/*
	public List<Long> lastWeekNewMem(){
		List<Long> lasgWeekNewMem = new ArrayList<>();
		Date today = new Date();
		
		// 월요일부터 일요일까지의 날짜를 생성하고 각 날짜별로 새 회원 수를 조회
		 for (int i = 0; i < 7; i++) {
	            Date currentDateMinusDays = DateUtils.addDays(today, -i); // 날짜를 하루씩 감소
	            
	            Long count = memRepository.countNewMembersByDate(currentDateMinusDays);
	            lasgWeekNewMem.add(count);
	        }
	
		return lasgWeekNewMem;
	}*/
	public List<Long> lastWeekNewMem(){
		
		List<Long> lastWeekNewMem = new ArrayList<>();
		LocalDate today = LocalDate.now();
		// 현재 날짜의 요일을 가져옴 (1: 월요일, 2: 화요일, ...)
		int currentDayOfWeek = today.getDayOfWeek().getValue();
		
		// 현재 날짜를 기준으로 이전 주의 월요일과 일요일을 계산
		LocalDate previousWeekStart = today.minusDays(currentDayOfWeek).minusWeeks(1).plusDays(1);
		LocalDate previousWeekEnd = today.minusDays(currentDayOfWeek);
				
		// LocalDate를 Date로 변환
		Date startDate = java.sql.Date.valueOf(previousWeekStart);
		Date endDate = java.sql.Date.valueOf(previousWeekEnd);
		
		 System.out.println("멤버서비스 startDate : "+startDate);
	     System.out.println("멤버서비스 endDate : "+endDate);
	     System.out.println("멤버서비스 today : "+today);
	     System.out.println("멤버서비스 previousWeekStart : "+previousWeekStart);
	     System.out.println("멤버서비스 previousWeekEnd: "+previousWeekEnd);
		
	     lastWeekNewMem = memRepository.countNewMembersByDate(startDate, endDate);
		
		return lastWeekNewMem;
	}
	
	
	
	
	
	
	
	
	
	
	
	//총 회원수 구하기 
	public Long totalMem() {
		Long totalMem = memRepository.countBy();
		return totalMem;
	}
	
	
	

	

}
