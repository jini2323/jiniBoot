package kr.co.laura.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.FundingBoard;
@Repository
public interface FundingRepository extends JpaRepository<FundingBoard, Long>{
	
	List<FundingBoard> findByFunnum(Long funnum);
	

}
