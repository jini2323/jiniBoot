package kr.co.laura.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.service.MemberService;
import lombok.RequiredArgsConstructor;

//@RequestMapping("/mem")
@Controller
@RequiredArgsConstructor
public class MemController {
	
	
	@Autowired
	private final MemberService memService;
	
	
	//회원 리스트 
	@GetMapping("/memList")
	public String memberTalbe(Model model,Pageable pageable) {
		List<Mem> memList = memService.showMemList();
		model.addAttribute("memList",memList);
		
		return "member/memList";
	}
	
	
	
	
	
	
	
	
	

}
