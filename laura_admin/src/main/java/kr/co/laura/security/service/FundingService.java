package kr.co.laura.security.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.Tuple;

import kr.co.laura.security.domain.FundingBoard;
import kr.co.laura.security.dto.FundingDTO;
import kr.co.laura.security.repository.FunPartiRepository;
import kr.co.laura.security.repository.FundingRepository;
import kr.co.laura.security.repositoryQFun.QFunRepository;
import kr.co.laura.security.repositoryQFun.QFunRepositoryImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FundingService {
	
	@Autowired
	private final FundingRepository funRepository;

	@Autowired
	private final QFunRepository qfunRepository;
	
	@Autowired
	private final FunPartiRepository funPatiRepository;
	
	@Autowired
	private final QFunRepositoryImpl qFunRepositoryImpl;
	
	
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
	
	
	//지난주  오픈한(작성이 아닌) 시작하는 펀딩 수 
    public List<Long> lastWeekNewFundings() {
        LocalDate today = LocalDate.now();
        int currentDayOfWeek = today.getDayOfWeek().getValue();
        LocalDate previousWeekStart = today.minusDays(currentDayOfWeek).minusWeeks(1).plusDays(1);
        LocalDate previousWeekEnd = today.minusDays(currentDayOfWeek);
        Date startDate = java.sql.Date.valueOf(previousWeekStart);
        Date endDate = java.sql.Date.valueOf(previousWeekEnd);
        
        return qfunRepository.getLastWeekNewFunding(startDate, endDate);
        
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
		 // 펀딩 금액 달성률 계산
		 	//Long funnum = 0L;
		  //Long achievementRate = qFunRepositoryImpl.calFundingAchieveRates();
		 List<FundingDTO> top6FundingList = qFunRepositoryImpl.showTop6FundingsByFunMoney();
		 List<Long> achievementRates = qFunRepositoryImpl.calFundingAchieveRates(top6FundingList);
		 
		  System.out.println("펀딩 달성률 계산: "+achievementRates.get(0));
		
		// fmoney의 합이 가장 높은 6개의 펀딩 게시글 가져오기
		// List<FundingBoard> top6FundingList = qFunRepositoryImpl.showTop6FundingsByFunMoney();    
		 
		    //최신펀딩 6개 
		    //List<FundingBoard> top6Fundings = qFunRepositoryImpl.findTop6OrderBySdateDesc();
		   // System.out.println("최신펀딩 6개 : "+top6Fundings.get(0));
		// List<Tuple> top6FundingTuples = qFunRepositoryImpl.showTop6FundingsByFunMoney();
	        
		    
		    return achievementRates;
		    
		    
		    
	 }
	
	
	
	

}
