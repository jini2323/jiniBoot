package kr.co.laura.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.MemLoginLog;
import java.util.Date;


@Repository
public interface MemLoggingRepository extends JpaRepository<MemLoginLog, Long> {
	
	
	//로그인 기록 테이블 
	List<MemLoginLog> findAll();
	

}
