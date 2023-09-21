package kr.co.laura.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.FundingBoard;
import kr.co.laura.security.repository.FundingRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FundingService {
	
	@Autowired
	private final FundingRepository funRepository;
	
	// 펀딩 게시글 목록 
	public List<FundingBoard> showFundingTable(){
		return funRepository.findAll();
	}
	
	
	//총 펀딩 게시글 수 구하기 
	public Long countTotalFunding() {
		Long totalFunding = funRepository.countBy();
		return totalFunding;
	}
	
	//오늘 오픈한(작성이 아닌) 시작하는 펀딩 수 
	public Long countTodayOpenFundings() {
		Long countTodayOpenFundings = funRepository.countTodayOpenFundings();
		return countTodayOpenFundings;
	}
	
	
	
	

}
