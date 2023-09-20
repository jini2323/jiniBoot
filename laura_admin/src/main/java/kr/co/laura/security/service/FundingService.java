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
	
	
	

}
