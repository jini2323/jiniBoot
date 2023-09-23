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
		//model.addAttribute("todayCount", todayCount);
		model.addAttribute("todayCount", todayCount);
		
		
		//대쉬보드 2. 저번주 방문자 수 (비회원 포함 세션 ㄴㄴ) 
		List<Long> lastWeekCounts = visitService.weekCount();
		model.addAttribute("lastWeekCounts",lastWeekCounts);
		
		  for (Long count : lastWeekCounts) {
		        System.out.println("메인커트롤러/ 지난주 방문자 수: " + count);
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
		
		for (Object e : lastWeekNewMem) {
			System.out.println("일주일 전 새 회원수 lastWeekNewMem문 크기 "+lastWeekNewMem.size());
		    System.out.println("일주일 전 새 회원수 for each 문 e : "+e);
		}
		
		
		//대쉬보드 6. 총 펀딩 게시글 수
		Long totalFunding = funService.countTotalFunding();
		model.addAttribute("totalFunding",totalFunding);
		
		//대쉬보드 7. 오늘 오픈(글작성 x 펀딩시작)한 펀딩 수
		Long todayOpenfundings = funService.countTodayOpenFundings();
		model.addAttribute("todayOpenfundings",todayOpenfundings);
		
		
		//대쉬보드 8. 지난 주 새로 오픈(작성x)한 펀딩 수
		List<Long> lasgWeekNewFundings = funService.lastWeekNewFundings();
		model.addAttribute("lasgWeekNewFundings",lasgWeekNewFundings);
		
		//대쉬보드 9 . 오늘 펀딩 참여 총 금액
		Long totalTodayMoney = funService.todayTotalFunPati();
		model.addAttribute("totalTodayMoney",totalTodayMoney);
		
		//대쉬보드 10. 총 펀딩 참여 금액 
		Long totalFunPatiMoney = funService.totalFunPati();
		model.addAttribute("totalFunPatiMoney",totalFunPatiMoney);
		
		
		//대쉬보드 11. 펀딩 달성률 계산
		///펀딩 금액 달성률 테스트  펀딩번호: 2 , 펀딩 참여번호 3
		//Long achievementRate = funService.achievementRate(2L);
		//model.addAttribute("achievementRate",achievementRate);
		//List<FundingBoard> top6FundingList = funService.top6FundingListandAchieveRate();
		//QFundingBoard qFun = QFundingBoard.fundingBoard;
		//List<Tuple> top6FundingTuples = funService.top6FundingListandAchieveRate();
		
		//모인 금액이 가장 많은 상위 6개 펀딩 게시글 
		List<FundingDTO> top6FundingList = funService.top6FundingList();
		model.addAttribute("top6FundingList",top6FundingList);
		System.out.println(top6FundingList);
		
		//목표금액 달성률 
		List<Long> achievementRates = funService.top6dAchieveRates();
		model.addAttribute("achievementRates",achievementRates);
		System.out.println("컨트롤러/ 달성률:"+achievementRates);
		
		
		
		return "admin2/dashboard";
	}
	
	
	
	
	
	
	
	
	
	
	

}
