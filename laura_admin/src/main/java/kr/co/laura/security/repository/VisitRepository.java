package kr.co.laura.security.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Date>{
	
	// 오늘 방문자 수
	//Long countByVisitDate(Date today);
	
	//저번주 방문자 수(주간) => query dsl
	
	
	//누적 방문자 수
	@Query(value = "SELECT SUM(v.countnum) FROM Visit v", nativeQuery = true)
	Long countByVisitDate();
}
