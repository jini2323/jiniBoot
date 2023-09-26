package kr.co.laura.security.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.Mem;

import java.util.List;
import java.util.Optional;


@Repository
public interface MemberRepository extends PagingAndSortingRepository <Mem, Long>{
//public interface MemberRepository extends JpaRepository<Mem, Long> {

	
	
	// 멤버 목록
	List<Mem> findAllByOrderByMdateDesc();
	// 멤버 목록페이징처리
	//List<Mem> findAllByOrderByMdateDesc(Pageable pageable);
    
	
	
	// 오늘 새 회원 수 조회
	@Query(value = "SELECT COUNT(*) FROM Mem WHERE TRUNC(MDATE) = TRUNC(SYSDATE)", nativeQuery = true)
	Long countTodayNewMembers();
	
    
	// 총 회원수
	Long countBy();
	//주간 새 회원 수는 쿼리 dsl로 
	
	
}
