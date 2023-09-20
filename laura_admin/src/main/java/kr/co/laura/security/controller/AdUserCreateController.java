package kr.co.laura.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.laura.security.dto.AdUserJoinDto;
import kr.co.laura.security.service.AdUserCreateService;
import lombok.RequiredArgsConstructor;

//@RequestMapping(value = "/admin", method = {RequestMethod.POST})
@Controller
@RequiredArgsConstructor
public class AdUserCreateController {

	@Autowired
	private final AdUserCreateService registerAduserService;
	
	// 암호화 전 //관리자 게정 생성 메서드
	@PostMapping("/adJoinProccess")
	public String adminJoin(AdUserJoinDto dto, Model model) {
		try {
			registerAduserService.createAdmin(dto);
			System.out.println("관리자 계정:"+dto.getAdEmail());//ok
			System.out.println("관리자 계정:"+dto.getAdTel());//ok
			System.out.println("관리자 계정 :암호화된 비번: "+dto.getAdPwd());//ok
			model.addAttribute("msg", "관리자계정 생성 성공!");
			return "admin/joingood";
		} catch (Exception e) {
			model.addAttribute("msge", "계정 생성 실패 ");
			return "admin/joingood";
		}
	}
	
	
	
	

}
