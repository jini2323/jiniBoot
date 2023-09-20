package kr.co.laura.security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//@RequestMapping("/login")
@RequiredArgsConstructor
@Controller
public class AduserLoginController {
	
//	 @Autowired
	// private final AdUserService adUserService;

	 
	 	/*시큐리티 적용시 필요없음 => 스프링에서 인증을 관리한다.
	    @PostMapping("/adLoginProcess")
	    public String adminLogin(AdUserLoginDto dto) {
	        boolean isValidMember = adUserService.isValidMember(dto.getAdEmail(), dto.getAdPwd());
	        if (isValidMember)
	            return "admin/adinfo";
	        return "admin/aderror";
	    }
	    */
	 
	    @PostMapping("/adLogout")
	    public String adminLogout(HttpServletRequest request, HttpServletResponse response) {  
	    	new SecurityContextLogoutHandler().logout(request, response,
	    			SecurityContextHolder.getContext().getAuthentication()
	    			);
	        return "redirect:/adLogin";
	    }
	    
	    
	    //관리자 계정 관리 페이지
	    @GetMapping("/adManage")
		public String adminManage(Model model) {
			return "admin2/adminManagement";
		}
		
	    
	    
	    
	    
	    /*
	     * 지피티 코드 	
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	if(auth != null) {
	    		new SecurityContextLogoutHandler().logout(request, response, auth);
	    	}
	     */
	    
	    
	    
	    

}
