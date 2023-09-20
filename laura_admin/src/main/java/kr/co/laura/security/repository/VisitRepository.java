package kr.co.laura.security.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Date>{
	
	//오늘 방문자 수 
	Optional<Visit> findByVisitDate(Date visitDate);

	
	//저번주 방문자 수(주간 
	List<Visit> findByVisitDateBetween(Date startDate,Date endDate);

	
}
