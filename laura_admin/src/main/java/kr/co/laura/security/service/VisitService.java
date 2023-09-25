package kr.co.laura.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.dto.VisitDTO;
import kr.co.laura.security.repository.VisitRepository;
import kr.co.laura.security.repositoryQVisit.QVisitRepositoryImpl;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class VisitService {
	
	@Autowired
	private final VisitRepository visitRepository;
	
	@Autowired
	private final QVisitRepositoryImpl qvisitRepository;
	
	//대쉬보드 1. 오늘의 방문자 수  
	public VisitDTO todayCount(){
		return qvisitRepository.countByVisitDate();
	} 
	
	//대쉬보드 1-2 누적 방문자 수
	public Long totalVisitCount() {
		return visitRepository.countByVisitDate();
	}
	
	
	
	//대쉬보드 2.분홍차트 7일전-어제까지의 날까 +방문자 수 2개 같이 구하기 (세션 아니고)
	public List<VisitDTO> showLastWeekCountVisitWithDate() {
        return qvisitRepository.showLastWeekCountVisitWithDate();
    }
	
	
	
	
	

	

}
