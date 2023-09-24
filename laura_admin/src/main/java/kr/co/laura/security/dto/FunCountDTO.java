package kr.co.laura.security.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class FunCountDTO {
	
	private Long countNewOpenFunding; //오픈된 펀딩 수 
	private String sdate; //작성일 아닌 펀딩 오픈하는 날 
	
	
	public FunCountDTO(Long countNewOpenFunding, String sdate) {
		this.countNewOpenFunding = countNewOpenFunding;
		this.sdate = sdate;
	//	System.out.println
	//	("FunCountDOT 생성자: sdate : "+sdate
	//			+" 오픈 펀딩 수:"+countNewOpenFunding);
	}

	
	
	
}
