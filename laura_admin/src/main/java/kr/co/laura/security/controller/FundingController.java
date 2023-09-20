package kr.co.laura.security.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.laura.security.domain.FundingBoard;
import kr.co.laura.security.service.FundingService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FundingController {

	@Autowired
	private final FundingService funService;
	
	//임시 펀딩테이블
	@GetMapping("/funTable")
	public String funTable(Model model) {
		List<FundingBoard> fundingList = funService.showFundingTable();
		model.addAttribute("fundingList", fundingList);
		
		return "admin2/fundingTable";
	}
	
	
	//펀딩 분석 페이지 
	@GetMapping("/funAnal")
	public String funAnalysis(Model model) {
		return "admin2/fundingAnalysis";
	}
	

	
	
	/*
	 * @GetMapping("/memList") public String memberTalbe(Model model,Pageable
	 * pageable) { List<Mem> memList = memService.showMemList();
	 * model.addAttribute("memList",memList);
	 * 
	 * return "member/memList"; }
	 */

}
