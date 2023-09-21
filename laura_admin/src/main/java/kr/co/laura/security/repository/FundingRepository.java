package kr.co.laura.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.FundingBoard;
@Repository
public interface FundingRepository extends JpaRepository<FundingBoard, Long>{
	
	//펀딩 게시글 리스트
	List<FundingBoard> findByFunnum(Long funnum);
	
	
	// 총 펀딩 게시글 수
	Long countBy();
	
	// 오늘 새 펀딩 수 
	@Query(value = "SELECT COUNT(*) FROM FBOARD WHERE TRUNC(sdate) = TRUNC(SYSDATE)", nativeQuery = true)
	Long countTodayOpenFundings();
	

}
