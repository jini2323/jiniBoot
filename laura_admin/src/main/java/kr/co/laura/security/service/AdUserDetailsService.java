
package kr.co.laura.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Aduser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Service
public class AdUserDetailsService implements UserDetailsService {

	@Autowired
	private final AdUserService adUserservice;
	
	
	
	//비번이 동일한지 체크는 스프링부트에서 알아서 진행 : 아이디(메일)만 가지고 DB에서 유저 정보를 가져온다.(기본정보만 필요)
	@Override
	public UserDetails loadUserByUsername(String adEmail) throws UsernameNotFoundException {

		Optional<Aduser> findOne = adUserservice.findOne(adEmail);
		Aduser aduser = findOne.orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 관리자 계정입니다"));
		
		//추가
		//passwordEncoder = new SimplePasswordEncoder();
		
		return User.builder()
				.username(aduser.getAdEmail())
				//.password(aduser.getAdPwd())
				.password("{noop}"+aduser.getAdPwd()) //추가
				//.roles(aduser.getRoleType())
				.roles(aduser.getRoleType().toString())
				.build();
	}

}
