package kr.co.laura.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.AdminLoginLog;

@Repository
public interface AdminLoggingRepository extends JpaRepository<AdminLoginLog, Long> {

	
	public List<AdminLoginLog> findAll();
	
	//public List<AdminLoginLog> findLoginLogsByAdidOrderByAdlogtimeDesc(String adid);

	
	
}
