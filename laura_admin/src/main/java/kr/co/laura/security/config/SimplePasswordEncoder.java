
package kr.co.laura.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class SimplePasswordEncoder implements PasswordEncoder {

	// 회원가입시 DB에 넣기 전에 이걸 호출하여 암호화한다.

	@Override // 해당 암호화 방식으로 암호화한 문자열을 리턴
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	// rawPassword = 로그인 시 사용가자 입력한 비번 encodedPassword DB에서 조회한 이미 암호화된 비번
	// AdUserService/loadUserByUsername() 에서 .password(aduser.getAdPwd()) 이 부분이 여기로
	// 들어온다
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(encode(rawPassword));
	}

}
