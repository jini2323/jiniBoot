package kr.co.laura.security.repositoryQVisit;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.laura.security.domain.Visit;

public interface QVisitRepository extends JpaRepository<Visit, Date>, QVisitRepositoryCustom {
	
	

}
