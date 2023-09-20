package kr.co.laura.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Aduser;
import kr.co.laura.security.dto.AdUserJoinDto;
import kr.co.laura.security.repository.AduserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdUserCreateService {
	
	@Autowired
	private final AduserRepository repository;
	
	
	//암호화 전
	public Aduser createAdmin(AdUserJoinDto dto) {
		Aduser aduser = Aduser.builder()
				.deptNo(dto.getDeptNo())
				.adTel(dto.getAdTel())
				.adEmail(dto.getAdEmail())
				.adPwd(dto.getAdPwd())
				.build();
		validateDuplicateMember(aduser); //ok
		System.out.println("res service.create admin(): "+repository.save(aduser));//ok
		repository.save(aduser);
		System.out.println("res service,create admin(): save 후 "+aduser.getAdEmail());//ok
		System.out.println("res service,create admin(): save 후 "+aduser.getAdNum());//3 ok 
		return aduser;
	}
	
	
	
	
	/* 예전 회원가입 (시큐리티전)
	public Long joinAdmin(String adEmail, String adPwd,String adTel,int deptNo) {
		Aduser aduser = Aduser.createUser(adEmail,deptNo, adPwd, adTel);
		 validateDuplicateMember(aduser);
		 repository.save(aduser);
		
		 return aduser.getAdNum();
	}
	*/
	
	private void validateDuplicateMember(Aduser aduser) {
	    if (repository.findByAdEmail(aduser.getAdEmail()).isPresent()) {
	        throw new IllegalStateException("이미 존재하는 관리자 계정입니다.");
	    } else {
	        System.out.println("res service: valismem: 중복이 없으므로 계정 생성이 가능!");//ok
	    }
	}
	
	
	
	
}
