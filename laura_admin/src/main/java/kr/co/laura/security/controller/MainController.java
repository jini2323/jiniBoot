package kr.co.laura.security.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.querydsl.core.Tuple;

import kr.co.laura.security.domain.FundingBoard;
import kr.co.laura.security.domain.QFundingBoard;
import kr.co.laura.security.domain.Visit;
import kr.co.laura.security.dto.FundingDTO;
import kr.co.laura.security.dto.MemDTO;
import kr.co.laura.security.service.FundingService;
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
	
	@Autowired
	private final FundingService funService;
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		//대쉬보드 1. 오늘의 방문자 수 (비회원 포함 세션 ㄴㄴ) 
		Long todayCount =  visitService.todayCount();
		model.addAttribute("todayCount", todayCount);
		
		
		//대쉬보드 2. 저번주 방문자 수 (비회원 포함 세션 ㄴㄴ) 
		List<Long> lastWeekCounts = visitService.weekCount();
		model.addAttribute("lastWeekCounts",lastWeekCounts);
		
		  for (Long count : lastWeekCounts) {
		        System.out.println("메인컨트롤러/ 지난주 방문자 수 : " + count);
		    }
		System.out.println("메인컨트롤러 지난주 방문수 크기:"+lastWeekCounts.size());
		  
		
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
		System.out.println("일주일 전 새 회원수 lastWeekNewMem문 크기 "+lastWeekNewMem.size());
		for (Object e : lastWeekNewMem) {
		    System.out.println("일주일 전 새 회원수 : "+e);
		}
		
		
		//대쉬보드 6. 총 펀딩 게시글 수
		Long totalFunding = funService.countTotalFunding();
		model.addAttribute("totalFunding",totalFunding);
		
		//대쉬보드 7. 오늘 오픈(글작성 x 펀딩시작)한 펀딩 수
		Long todayOpenfundings = funService.countTodayOpenFundings();
		model.addAttribute("todayOpenfundings",todayOpenfundings);
		
		
		
		//대쉬보드 8. 지난 주 새로 오픈(작성x)한 펀딩 수 검정색차트
		List<Long> lasgWeekOpenFundings = funService.lastWeekNewFundings();
		
		// NULL 값을 0으로 대체
		for (int i = 0; i < lasgWeekOpenFundings.size(); i++) {
		    if (lasgWeekOpenFundings.get(i) == null) {
		        lasgWeekOpenFundings.set(i, 0L); // NULL을 0으로 대체
		    }
		}
		
		model.addAttribute("lasgWeekOpenFundings",lasgWeekOpenFundings);
		
		for (Long count : lasgWeekOpenFundings) {
		    System.out.println("지난 주 새로 오픈한 펀딩 수: " + count);
		}
		
		
		
		
		
		
		//대쉬보드 9 . 오늘 펀딩 참여 총 금액  파란거 끝에 
		Long totalTodayMoney = funService.todayTotalFunPati();
		model.addAttribute("totalTodayMoney",totalTodayMoney);
		
		//대쉬보드 10. 총 펀딩 참여 금액 
		Long totalFunPatiMoney = funService.totalFunPati();
		model.addAttribute("totalFunPatiMoney",totalFunPatiMoney);
		
		
		//대쉬보드 11 모인 금액이 가장 많은 상위 6개 펀딩 게시글 
		List<FundingDTO> top6FundingList = funService.top6FundingList();
		model.addAttribute("top6FundingList",top6FundingList);
		System.out.println(top6FundingList);
		
		//대쉬보드 12.목표금액 달성률  /펀딩 달성률 계산
		List<Long> achievementRates = funService.top6dAchieveRates();
		model.addAttribute("achievementRates",achievementRates);
		System.out.println("컨트롤러/ 달성률:"+achievementRates);
		
		
		//대쉬보드 13. 인증된 새회원 최신순 6명 업데이트
		List<MemDTO> newConfirmedMems = memService.getNewConfirmedMems();
		model.addAttribute("newConfirmedMems",newConfirmedMems);
		
		
		for (MemDTO memDTO : newConfirmedMems) {
		    System.out.println("Nickname: " + memDTO.getNickname());
		    System.out.println("Name: " + memDTO.getName());
		    System.out.println("Ardate: " + memDTO.getArdate());
		    System.out.println("Arprofile: " + memDTO.getArprofile());
		    System.out.println("Arstatus: " + memDTO.getArstatus());
		    System.out.println("-------------------------------");
		}
		
		return "admin2/dashboard";
	}
	
	
	
	
	
	
	
	
	
	
	

}
