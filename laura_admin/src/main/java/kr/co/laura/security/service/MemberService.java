package kr.co.laura.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.MemLoginLog;
import kr.co.laura.security.dto.MemCountDTO;
import kr.co.laura.security.dto.MemDTO;
import kr.co.laura.security.repository.MemLoggingRepository;
import kr.co.laura.security.repository.MemberRepository;
import kr.co.laura.security.repositoryQMem.QMemRepositoryImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	@Autowired
	private final MemberRepository memRepository;
	
	@Autowired
	private final QMemRepositoryImpl qmemRepositoryImpl;
	
	@Autowired
	private final MemLoggingRepository memLoggingRepository;
	

	// 멤버리스트
	public List<Mem> showMemList() {
		return memRepository.findAllByOrderByMdateDesc();
	}
	
	//public Page<Mem> findMembers(int page, int size) {
	//    return memRepository.findAll(PageRequest.of(page, size, Sort.by("mdate").descending()));
	//}
	
	
	

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
	
	
	//인증된 최신순 새 회원수 6명 리스트
	public List<MemDTO> getNewConfirmedMems(){
		List<MemDTO> newConfirmedMems = qmemRepositoryImpl.getNewConfirmed();
		return newConfirmedMems;
	}
	
	
	//최신순으로 로그인 기록 불러오기 
	public List<MemLoginLog> showMemLoginLog(){
		List<MemLoginLog> memLoginLogs = memLoggingRepository.findAll();
		return memLoginLogs;
	}
	
	
	

}
