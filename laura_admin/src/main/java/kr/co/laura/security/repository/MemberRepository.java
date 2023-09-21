package kr.co.laura.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.Mem;

import java.util.Date;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Mem, Long> {

	// 멤버 목록
	List<Mem> findByEmail(String email);

	// 오늘 새 회원 수 조회
	@Query(value = "SELECT COUNT(*) FROM Mem WHERE TRUNC(MDATE) = TRUNC(SYSDATE)", nativeQuery = true)
	Long countTodayNewMembers();

	// 총 회원수
	Long countBy();

	 // 주간 회원 수 새 회원 수
	 @Query(value = "SELECT COUNT(*) FROM Mem m WHERE TRUNC(m.MDATE) BETWEEN TRUNC(:startDate) AND TRUNC(:endDate)", nativeQuery = true)
	 List<Long> countNewMembersByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	 
	
	
	//@Query(value = "SELECT COUNT(*) FROM Mem WHERE TRUNC(MDATE) BETWEEN TRUNC(:startDate) AND TRUNC(:endDate)", nativeQuery = true)
	//List<Long> countNewMembersByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
