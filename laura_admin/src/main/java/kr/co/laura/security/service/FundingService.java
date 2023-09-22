package kr.co.laura.security.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.FundingBoard;
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
	
	 
	 //펀딩 금액 달성률 테스트  펀딩번호: 2 , 펀딩 참여번호 3
	 public Long achievementRate(Long funnum) {
		 // 펀딩 금액 달성률 계산
		    Long achievementRate = qFunRepositoryImpl.calFundingAchieveRate(funnum);
		    System.out.println("펀딩 달성률 계산: "+achievementRate);
		    
		    //최신펀딩 6개 
		    //List<FundingBoard> top6Fundings = qFunRepositoryImpl.findTop6OrderBySdateDesc();
		   // System.out.println("최신펀딩 6개 : "+top6Fundings.get(0));
		    
	        
		    
		    
		    
		    return achievementRate;
		    
	 }
	
	
	
	

}
