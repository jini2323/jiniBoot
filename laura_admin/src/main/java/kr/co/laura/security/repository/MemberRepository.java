package kr.co.laura.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.dto.MemCountDTO;
import kr.co.laura.security.dto.VisitDTO;

import java.util.Date;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Mem, Long> {

	// 멤버 목록
	List<Mem> findByEmail(String email);

	// 오늘 새 회원 수 조회
	@Query(value = "SELECT COUNT(*) FROM Mem WHERE TRUNC(MDATE) = TRUNC(SYSDATE)", nativeQuery = true)
	Long countTodayNewMembers();
	
	
	// 주간 새 회원 수 조회
    @Query(value ="SELECT *\r\n"
    		+ "FROM (\r\n"
    		+ "    SELECT COUNT(mdate) AS count_mdate, TO_CHAR(mdate, 'YYYY/MM/DD') AS mdate\r\n"
    		+ "    FROM MEM\r\n"
    		+ "    WHERE TO_CHAR(mdate, 'YYYY/MM/DD') BETWEEN TO_CHAR(TRUNC(SYSDATE) - 7) AND TO_CHAR(TRUNC(SYSDATE) - 1)\r\n"
    		+ "    GROUP BY TO_CHAR(mdate, 'YYYY/MM/DD')\r\n"
    		+ "    ORDER BY mdate DESC\r\n"
    		+ ")\r\n"
    		+ "WHERE ROWNUM <= 7", nativeQuery = true)
    List<MemCountDTO> countWeeklyNewMembers();
	
    
    
    @Query(value = "SELECT TO_CHAR(mdate, 'YYYY/MM/DD') AS mdate, COUNT(*) AS count_mdate " +
            "FROM Mem " +
            "WHERE mdate BETWEEN :startDate AND :endDate " +
            "GROUP BY TO_CHAR(mdate, 'YYYY/MM/DD') " +
            "ORDER BY TO_CHAR(mdate, 'YYYY/MM/DD') DESC")
    List<Object[]> countWeeklyNewMembers2(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
    
    
	// 총 회원수
	Long countBy();
	
	//주간 새 회원 수는 쿼리 dsl로 
}
