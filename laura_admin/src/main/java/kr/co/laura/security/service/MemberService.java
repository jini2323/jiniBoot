package kr.co.laura.security.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.dto.MemCountDTO;
import kr.co.laura.security.dto.MemDTO;
import kr.co.laura.security.repository.MemberRepository;
import kr.co.laura.security.repositoryQMem.QMemRepository;
import kr.co.laura.security.repositoryQMem.QMemRepositoryImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	@Autowired
	private final MemberRepository memRepository;
	
	@Autowired
	private final QMemRepositoryImpl qmemRepositoryImpl;
	

	// 멤버리스트
	public List<Mem> showMemList() {
		return memRepository.findAll();
	}

	//오늘 가입한 회원 수 
	public Long todayNewMem() {
		Long todayNewMem  = memRepository.countTodayNewMembers();
		return todayNewMem;
	}
	
	    
    //대쉬보드 5 지난수 새 회원 수 
    public List<MemCountDTO> lastWeekNewMem() {
        return qmemRepositoryImpl.getLastWeekNewMem();
    }
	
    
	//총 회원수 구하기 
	public Long totalMem() {
		Long totalMem = memRepository.countBy();
		return totalMem;
	}
	
	//인증된 새 회원수 6명 리스트
	public List<MemDTO> getNewConfirmedMems(){
		List<MemDTO> newConfirmedMems = qmemRepositoryImpl.getNewConfirmed();
		return newConfirmedMems;
	}
	
	
	

	

}
