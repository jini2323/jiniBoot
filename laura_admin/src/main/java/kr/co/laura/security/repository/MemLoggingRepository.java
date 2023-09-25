package kr.co.laura.security.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.MemLoginLog;


@Repository
public interface MemLoggingRepository extends JpaRepository<MemLoginLog, Long> {
	
	
	

}
