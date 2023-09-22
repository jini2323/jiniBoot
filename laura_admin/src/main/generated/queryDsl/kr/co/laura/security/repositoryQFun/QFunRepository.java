package kr.co.laura.security.repositoryQFun;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.laura.security.domain.FundingBoard;

public interface QFunRepository extends JpaRepository<FundingBoard, Long>, QFunRepositoryCustom {

	
	
	
	
}
