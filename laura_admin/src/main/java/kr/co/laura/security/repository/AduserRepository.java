package kr.co.laura.security.repository;

import kr.co.laura.security.domain.Aduser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AduserRepository extends JpaRepository<Aduser, Long> {

    Optional<Aduser> findByAdEmail(String adEmail);
    
    
}