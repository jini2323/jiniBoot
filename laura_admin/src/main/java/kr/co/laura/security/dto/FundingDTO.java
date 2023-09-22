package kr.co.laura.security.dto;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class FundingDTO {
	
	private String funtitle;
    private String funwriter;
    private Long targetprice;
    private Long totalFunMoney;
    
    public FundingDTO(String funtitle, String funwriter, Long targetprice, Long totalFunMoney) {
        this.funtitle = funtitle;
        this.funwriter = funwriter;
        this.targetprice = targetprice;
        this.totalFunMoney = totalFunMoney;
    }

}
