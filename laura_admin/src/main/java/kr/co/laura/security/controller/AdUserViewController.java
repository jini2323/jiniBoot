package kr.co.laura.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdUserViewController {
	
	
	//템플릿 적용 임시 
	@GetMapping("/adMain2")
	public String adminIndex2(Model model) {
		model.addAttribute("msg","여기는 관리자 페이지 Main 입니다.");
		return "admin2/index";
	}
	
	
	//임시
	//@GetMapping("/dashboard")
	public String dashboard(Model model) {
		return "admin2/dashboard";
	}
	
	
	@GetMapping("/notifications")
	public String notifications(Model model) {
		return "admin2/notifications";
	}
	
	//템플릿의 메인 
	@GetMapping("/index")
	public String index(Model model) {
		return "admin2/index";
	}
	
	
	/////임시영역

	
	@RequestMapping(value = { "/", "/adMain" }, method = RequestMethod.GET)
	public String adminIndex(Model model) {
		model.addAttribute("msg","여기는 관리자 임시 페이지 입니다.");
		return "admin/adindex";
	}
	
	
	//관리자 계정 생성 폼(king 권한만 접근가능하게 나중에 바꾸기)
	@GetMapping("/adJoinForm")
	public String adjoinForm() {
		return "admin2/adjoinForm";
	}
	
	//가입 실패 성공 같이 
	@GetMapping("/joingood")
	public String judgeJoin() {
		return "admin/joingood";
	}
	
	
	//--------------로그인 파트------------
	// 운영자 계정 로그인 폼
		@GetMapping("/adLoginForm")
		public String adloginFrom() {
			return "admin2/adloginForm";
		}
		
		
		// 로그인 에러 페이지 
		@GetMapping("/adminError")
		public String errorAdmin(Model model) {
			model.addAttribute("msg", "당신은 접근 권한이 없습니다.");
			return "admin/aderror";
		}
	
	
	
	//------------관리자 정보 페이지? 
	
	@GetMapping("/adminInfo")
	public String adminInfo() {
		
		return "admin/adinfo";
	}
	

}
