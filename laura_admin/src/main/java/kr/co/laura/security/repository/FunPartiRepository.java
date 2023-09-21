package kr.co.laura.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kr.co.laura.security.domain.FunPatiPK;
import kr.co.laura.security.domain.FundingParti;

public interface FunPartiRepository extends JpaRepository<FundingParti, FunPatiPK>{
	
	//오늘의 총 펀딩참여 금액
	@Query(value = "SELECT SUM(funmoney) FROM FUNDING_PARTI WHERE TRUNC(joindate) = TRUNC(SYSDATE)", nativeQuery = true)
	Long countTodayOpenFunPatiMoney();
	
	//총 펀딩 참여 금액
	@Query(value = "SELECT SUM(funmoney) FROM FUNDING_PARTI", nativeQuery = true)
	Long countTotalFunPatiMoney();
	

}
