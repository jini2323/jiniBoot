package kr.co.laura.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.laura.security.domain.Mem;
import java.util.List;
import java.time.LocalDate;
import java.util.Date;



@Repository
public interface MemberRepository extends JpaRepository<Mem, Long>{
	
	//@PersistenceContext
	//private EntityManager em;
	
	//Optional<Mem> findByEmail(String email);
	
	//멤버 목록 
	List<Mem> findByEmail(String email);
	
	//오늘 새 회원 수 
	List<Mem> findByMdate(Date mdate);
	
	
	//Page<Mem> findByMdate(Date mdate, Pageable pageable);
	

}
