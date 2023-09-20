package kr.co.laura.security.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.MemCount;
import kr.co.laura.security.repository.MemCountRepository;
import kr.co.laura.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	@Autowired
	private final MemberRepository memRepository;
	
	@Autowired
	private final MemCountRepository memCountRepository;

	// 멤버리스트
	public List<Mem> showMemList() {
		return memRepository.findAll();
	}

	//오늘 가입한 회원 수 
	public Optional<MemCount> showTodayNewMems(){
		
		//현재 날짜를 가져옵니다.
        LocalDate todayLocal = LocalDate.now();

        // LocalDate를 Date로 변환합니다.
        Date today = java.sql.Date.valueOf(todayLocal);

        // 오늘 가입한 회원 수를 조회합니다.
        return memCountRepository.findByJdate(today);
        
	}
	
	
	
	/*
	public int getNewMemberCountToday() {
		// 현재 날짜를 가져옵
		LocalDate todaylocal = LocalDate.now();
		
		 // java.time.LocalDate를 java.util.Date로 변환합니다.
        Date today = java.sql.Date.valueOf(todaylocal);
		
        
		// 오늘 날짜를 기준으로 회원 가입 정보를 조회
		List<Mem> newMems = memRepository.findByMdate(today);
		System.out.println("멤버서비스-가입날짜로 새 회원 "+ newMems.size());
		
		
		
		// 조회된 데이터의 개수를 반환
		return newMems.size();
	}
	*/

	

}
