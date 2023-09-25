package kr.co.laura.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Aduser;
import kr.co.laura.security.repository.AduserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdUserService {
    
	@Autowired
	private final AduserRepository adUserRepository;
	
	
	//adEmail으로 유저 찾는 메서드 
    public Optional<Aduser> findOne(String adEmail) {
    	return adUserRepository.findByAdEmail(adEmail);
    }
    
    //로그인 성공시 기록 남기는 메서드
    
    
    
    
    
    /*로그인 관련 메서드 */
    public boolean isValidMember(String adEmail, String adPwd) {
    	//System.out.println("유저서비스 validmem:"+adEmail);
        Optional<Aduser> aduser = findOne(adEmail);
        if (aduser.isPresent()) {
            return aduser.get().getAdPwd().equals(adPwd);
        }
        return false;
    }
    
    
    
    
}
















