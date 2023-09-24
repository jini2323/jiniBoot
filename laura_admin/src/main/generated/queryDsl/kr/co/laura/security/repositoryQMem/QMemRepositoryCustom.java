package kr.co.laura.security.repositoryQMem;

import java.util.Date;
import java.util.List;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.QMem;
import kr.co.laura.security.dto.MemCountDTO;
import kr.co.laura.security.dto.MemDTO;



public interface QMemRepositoryCustom  {
	
	//QueryDSL 로 커스텀해서 사용할 메소드 선언하는 파일
	
	//새로 인증한 회원 목록
	List<MemDTO> getNewConfirmed();
	
	//지난주 새 회원수 7일전 -  어제 까지 
	public List<MemCountDTO> getLastWeekNewMem();
	
	
}
