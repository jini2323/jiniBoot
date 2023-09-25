package kr.co.laura.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.DispatcherType;
import kr.co.laura.security.handler.CustomLoginSuccessHandler;
import lombok.RequiredArgsConstructor;



@EnableMethodSecurity 
@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig {
	//@Secured("ROLE_ADMIN") 해당 권한 가진사람만 메서드에 접근 가능 
	//메서드 호출 후에 검사 @PostAuthorize("returnObject.owner == authentication.name")
	//(prePostEnabled = true)/메소드 전에 검사 @EnableWebSecurity => 메서드에 접근권한 설정하여 보안 업 
	//new AntPathRequestMatcher("/h2-console/**"), //h2 디비 사용시 
	
	
	//암호화 초기과정
	@Bean
	PasswordEncoder passwordEncoder() {
		return new SimplePasswordEncoder();
	}
	
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.csrf(AbstractHttpConfigurer::disable) // 배포 전에 끄기 (보안 공격 관련)
        .authorizeHttpRequests((authz) -> authz
        	.dispatcherTypeMatchers(DispatcherType.FORWARD)
        	.permitAll()
        	.requestMatchers(new AntPathRequestMatcher("/static/**"), 
        			new AntPathRequestMatcher("/adLoginForm/**"),new AntPathRequestMatcher("/images/**"),
        			new AntPathRequestMatcher("/status/**"),new AntPathRequestMatcher("/adminError/**"),
        			new AntPathRequestMatcher("/static/**"),new AntPathRequestMatcher("/adJoinForm/**"),
        			new AntPathRequestMatcher("/joingood/**")
        			).permitAll()
        		// .requestMatchers(new AntPathRequestMatcher("/**")).hasAnyRole("ADMIN")
                .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
        )
        .formLogin(login -> login	// form 방식 로그인 사용
        		.loginPage("/adLoginForm")
        		.loginProcessingUrl("/adLoginProcess")
        		.successHandler(new CustomLoginSuccessHandler())     //로그인 성공시, 기록 남기기 안에 서비스
        		.usernameParameter("adEmail")
        		.passwordParameter("adPwd")
                .defaultSuccessUrl("/dashboard", true)	// 로그인성공 -> 운영진 메인으로
                .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
        )
        .logout(logout -> logout
        		.logoutUrl("/adLogout")
        		.logoutSuccessUrl("/adLogin")
        		.invalidateHttpSession(true)
        		)	// 로그아웃은 기본설정으로 (/logout으로 인증해제)
        .exceptionHandling(handling -> handling.accessDeniedPage("/adminError"));
		//.headers(headers -> headers.frameOptions().disable()); // h2-console관련
		
			return http.build();
	}
	
	
	
	

}
