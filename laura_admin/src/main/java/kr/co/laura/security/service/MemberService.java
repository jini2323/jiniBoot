package kr.co.laura.security.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	@Autowired
	private final MemberRepository memRepository;
	
	//@Autowired
	//private final MemCountRepository memCountRepository;

	// 멤버리스트
	public List<Mem> showMemList() {
		return memRepository.findAll();
	}

	//오늘 가입한 회원 수 
	public Long todayNewMem() {
		Long todayNewMem  = memRepository.countTodayNewMembers();
		return todayNewMem;
	}
	
	
	//총 회원수 구하기 
	public Long totalMem() {
		Long totalMem = memRepository.countBy();
		return totalMem;
	}
	
	
	

	

}
