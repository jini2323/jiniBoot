package kr.co.laura.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.laura.security.domain.Mem;

public interface QMemRepository extends JpaRepository<Mem, Long>, QMemRepositoryCustom {
	
	//JpaRepository 와 Custom interface 를 상속한 파일
	//사용자는 해당 파일을 DI 받아서 사용한다

}
