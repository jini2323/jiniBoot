package kr.co.laura.security.repository;

import java.util.Date;
import java.util.List;

import kr.co.laura.security.domain.Mem;



public interface QMemRepositoryCustom  {
	
	//QueryDSL 로 커스텀해서 사용할 메소드 선언하는 파일
	//Content findByUserSeq(Long userSeq);
	
	 /**
	   * QueryDSL을 사용하여 To-Do 목록 조회
	   */
	List<Mem> getMemList(Mem mem);
	
	List<Long> getLastWeekNewMem(Date startDate,Date endDate);
	
	
	
}
