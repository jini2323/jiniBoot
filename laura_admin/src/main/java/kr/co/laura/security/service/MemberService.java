package kr.co.laura.security.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.dto.MemDTO;
import kr.co.laura.security.repository.MemberRepository;
import kr.co.laura.security.repositoryQMem.QMemRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	@Autowired
	private final MemberRepository memRepository;
	
	@Autowired
	private final QMemRepository qmemRepository;
	

	// 멤버리스트
	public List<Mem> showMemList() {
		return memRepository.findAll();
	}

	//오늘 가입한 회원 수 
	public Long todayNewMem() {
		Long todayNewMem  = memRepository.countTodayNewMembers();
		return todayNewMem;
	}
	
	
	// 최신 7일~ 어제까지의 날짜
    public Date calculateStartDateForLast7Days() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7); // 7일 전의 날짜를 계산
        return calendar.getTime();
    }

    public Date calculateEndDateForYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1); // 어제의 날짜를 계산
        return calendar.getTime();
    }
	    
	    
	//지난 주  새 회원 수 차트
    public List<Long> lastWeekNewMem() {
      // LocalDate today = LocalDate.now();
      //  int currentDayOfWeek = today.getDayOfWeek().getValue();
       // LocalDate previousWeekStart = today.minusDays(currentDayOfWeek).minusWeeks(1).plusDays(1);
      //  LocalDate previousWeekEnd = today.minusDays(currentDayOfWeek);
    	//Date startDate = java.sql.Date.valueOf(previousWeekStart);
      //  Date endDate = java.sql.Date.valueOf(previousWeekEnd);
        Date startDate = calculateStartDateForLast7Days();
        Date endDate = calculateEndDateForYesterday();
        
        return qmemRepository.getLastWeekNewMem(startDate, endDate);
    }
	
    
	//총 회원수 구하기 
	public Long totalMem() {
		Long totalMem = memRepository.countBy();
		return totalMem;
	}
	
	//인증된 새 회원수 6명 리스트
	public List<MemDTO> getNewConfirmedMems(){
		List<MemDTO> newConfirmedMems = qmemRepository.getNewConfirmed();
		return newConfirmedMems;
	}
	
	
	

	

}
