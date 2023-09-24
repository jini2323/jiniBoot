package kr.co.laura.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.laura.security.domain.FundingBoard;
import kr.co.laura.security.dto.FunCountDTO;
import kr.co.laura.security.dto.FundingDTO;
import kr.co.laura.security.repository.FunPartiRepository;
import kr.co.laura.security.repository.FundingRepository;
import kr.co.laura.security.repositoryQFun.QFunRepositoryImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FundingService {
	
	@Autowired
	private final FundingRepository funRepository;

	@Autowired
	private final FunPartiRepository funPatiRepository;
	
	@Autowired
	private final QFunRepositoryImpl qFunRepositoryImpl;
	
	
	// 펀딩 게시글 목록 
	//public List<FundingBoard> showFundingTable(){
	//	return funRepository.findAll();
	//}
	public List<FundingBoard> showFundingTable(){
		return funRepository.findAll();
	}
	
	/*
	public Page<FundingBoard> showFundingTablePage(
			@RequestParam(required = false)
			String searchKeyword, Pageable pageable){
		
		return funRepository.findByTitleContaining(
				searchKeyword , pageable);
	}
	*/
	
	
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
	
	
	//지난주  오픈한(작성이 아닌) 시작하는 펀딩 수 
    public List<FunCountDTO> lastWeekNewFundings() {
        List<FunCountDTO> countLastweekOpenfundings = qFunRepositoryImpl.getLastWeekNewFunding();
        return countLastweekOpenfundings;
    }
	
    //오늘 총 펀딩 참여 금액 
	public Long todayTotalFunPati() {
			return funPatiRepository.countTodayOpenFunPatiMoney();
	}
	
	// 총 펀딩 참여 금액 
	public Long totalFunPati() {
		return funPatiRepository.countTotalFunPatiMoney();
	}
	
	 
	 //펀딩리스트 최고금액 top6게시글을 불러오되, 
	//각 게시글의 총 목표금액 달성률을 같이 가져온다.
	
	public List<FundingDTO> top6FundingList(){
		List<FundingDTO> top6FundingList = qFunRepositoryImpl.showTop6FundingsByFunMoney();
		return top6FundingList;
	}
	
	
	 public List<Long> top6dAchieveRates() { //Long funnum
		 //1 펀딩 모금액이 가장 높은순 6개 가져오기
		 List<FundingDTO> top6FundingList = qFunRepositoryImpl.showTop6FundingsByFunMoney();
		 
		 //그 6개의 펀딩의 달성률을 계산 
		 List<Long> achievementRates = qFunRepositoryImpl.calFundingAchieveRates(top6FundingList);
		 
		  System.out.println("펀딩 달성률 계산: "+achievementRates.get(0));
		    return achievementRates;
	 }
	
	
	
	

}
