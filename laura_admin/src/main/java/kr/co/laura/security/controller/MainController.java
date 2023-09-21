package kr.co.laura.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.laura.security.domain.Visit;
import kr.co.laura.security.service.MemberService;
import kr.co.laura.security.service.VisitService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	@Autowired
	private final VisitService visitService;
	
	@Autowired
	private final MemberService memService;
	
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		//대쉬보드 1. 오늘의 방문자 수 (비회원 포함 세션 ㄴㄴ) 
		Optional<Visit> todayCount =  visitService.todayCount();
		model.addAttribute("todayCount", todayCount);
		
		
		//대쉬보드 2. 저번주 방문자 수 (비회원 포함 세션 ㄴㄴ) 
		List<Visit> lastWeekCount = visitService.weekCount();
		model.addAttribute("lastWeekCount",lastWeekCount);
		
		for (Visit visit : lastWeekCount) {
		    System.out.println("날짜: " + visit.getVisitDate() + ", 방문자 수: " + visit.getCountNum());
		}
		
		
		//대쉬보드 3. 오늘 새 회원 수
		Long todayNewMem = memService.todayNewMem();
		model.addAttribute("todayNewMem",todayNewMem);
		System.out.println("메인컨트롤러 오늘 새 회원수 :"+todayNewMem);
		
		
		//대쉬보드 4. 총 회원수
		Long totalMem = memService.totalMem();
		model.addAttribute("totalMem",totalMem);
		
		//대쉬보드 5 지난수 새 회원 수 
		List<Long> lastWeekNewMem = memService.lastWeekNewMem();
		model.addAttribute("lastWeekNewMem",lastWeekNewMem);
		
		for (Long e : lastWeekNewMem) {
		    System.out.println("일주일 전 새 회원수 for each 문 e : "+e);
		    System.out.println("일주일 전 새 회원수 for each 문 크기 "+lastWeekNewMem.size());
		    
		}
		
		
		
		
		return "admin2/dashboard";
	}
	
	
	
	
	
	

}
