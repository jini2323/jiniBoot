package kr.co.laura.security.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Sort;

import kr.co.laura.security.domain.FundingBoard;
import kr.co.laura.security.service.FundingService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FundingController {

	@Autowired
	private final FundingService funService;
	

	
	/* 페이징처리중 
	@GetMapping("/funTable")
	public String funTable(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", 
			direction = Sort.Direction.DESC) Pageable pageable,
            String searchKeyword)
			 {
		List<FundingBoard> fundingList = funService.showFundingTable();
		model.addAttribute("fundingList", fundingList);
		
		//페이징
		Page<FundingBoard> list = null;

	        if(searchKeyword == null) {
	            list = funService.showFundingTablePage(searchKeyword, pageable);
	        }else {
	            list = funService.showFundingTablePage(searchKeyword, pageable);
	        }

	        int nowPage = list.getPageable().getPageNumber() + 1;
	        int startPage = Math.max(nowPage - 4, 1);
	        int endPage = Math.min(nowPage + 5, list.getTotalPages());

	        model.addAttribute("list", list);
	        model.addAttribute("nowPage", nowPage);
	        model.addAttribute("startPage", startPage);
	        model.addAttribute("endPage",  endPage);
		
		
		
		return "admin2/fundingTable";
	}
	*/
	
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
