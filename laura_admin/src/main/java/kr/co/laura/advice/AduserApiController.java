/*
 * package kr.co.laura.mvc.controller;
 * 
 * import org.springframework.security.core.context.SecurityContextHolder;
 * import org.springframework.security.web.authentication.logout.
 * SecurityContextLogoutHandler; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping;
 * 
 * import jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse; import
 * kr.co.laura.mvc.dto.AdadduserRequest; import
 * kr.co.laura.mvc.service.AdUserService; import lombok.RequiredArgsConstructor;
 * 
 * @RequiredArgsConstructor
 * 
 * @Controller public class AduserApiController {
 * 
 * private final AdUserService aduserService;
 * 
 * //관리자 계정추가
 * 
 * @PostMapping("/adJoin") public String adminCreate(AdadduserRequest request) {
 * aduserService.save(request); //회원 가입 메서드를 호출 return "redirect:/adLogin"; //계정
 * 생성하면 로그인 페이지로 이동
 * 
 * }
 * 
 * //계정 로그아웃
 * 
 * @GetMapping("/adLogout") public String adminLogout(HttpServletRequest
 * request, HttpServletResponse response) { new
 * SecurityContextLogoutHandler().logout(request, response,
 * SecurityContextHolder.getContext().getAuthentication());
 * 
 * return "redirect:/adMain"; //로그아웃하면 관리자 메인페이지로 이동 }
 * 
 * //adLoginSuccess adLogoutDone
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */

