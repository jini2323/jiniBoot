package kr.co.laura.security.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.MemCount;

public interface MemCountRepository extends JpaRepository<MemCount, Date> {
	

	//List<Mem> findByMdate(Date mdate);
	//오늘 새 회원 수 
	Optional<MemCount> findByJdate(Date jdate);
	
	//총 회원수
	Optional<MemCount> findByTotalMem(Long totalMem);
	
	
	//달 별 새 회원수 
	//List<E>
	
	
	

}
