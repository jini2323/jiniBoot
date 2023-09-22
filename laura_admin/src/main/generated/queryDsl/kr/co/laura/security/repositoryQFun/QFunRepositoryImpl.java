package kr.co.laura.security.repositoryQFun;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.laura.security.domain.QFundingBoard;
import kr.co.laura.security.domain.QFundingParti;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QFunRepositoryImpl implements QFunRepositoryCustom {
	
	private final JPAQueryFactory jpaQueryFactory;

	//지난주 새로 오픈한 펀딩 수 
	@Override
	public List<Long> getLastWeekNewFunding(Date startDate, Date endDate) {
		QFundingBoard qfun = QFundingBoard.fundingBoard;
		return jpaQueryFactory
				.select(qfun.sdate.count())
				.from(qfun)
				.where(qfun.sdate.between(startDate, endDate))
				.groupBy(qfun.sdate)
				.fetch();
				
	}
	
	
	public Long calFundingAchieveRate(Long funnum) {

        // FUNDING_PARTI 테이블에서 해당 펀딩 글 (funnum) 에 대한 총 펀딩 금액을 계산
		QFundingBoard qfun = QFundingBoard.fundingBoard;
		
		QFundingParti qfpati = QFundingParti.fundingParti;
		
		
		
        Long totalFundingAmount = jpaQueryFactory
        						.select(qfpati.funmoney.sum())
        						.from(qfpati)
        						.where(qfpati.funnum_num.eq(funnum))
        						.fetchOne();
        
        if (totalFundingAmount == null) {
            totalFundingAmount = 0L;
        }		
        		
        		
        // FBOARD 테이블에서 해당 펀딩 글 (funnum) 의 목표 금액 (targetprice)을 가져온다
        Long targetPrice = jpaQueryFactory
        		.select(qfun.targetprice)
        		.from(qfun)
        		.where(qfun.funnum.eq(funnum))
        		.fetchOne();

        if (targetPrice == null || targetPrice <= 0L) {
            return 0L;
        }

        // 펀딩 금액 달성률을 계산
        Long achievementRate = (totalFundingAmount * 100L) / targetPrice;
        
        
        return achievementRate;
        
        
    }
	
	
	
	
	
	
	
	
	
	//1. 펀딩 목표달성률 계산
	
	
	
	
	//2. 최신 6개 펀딩이 뜨도록 
	
	
	
	
	

}
