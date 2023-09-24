package kr.co.laura.security.dto;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class VisitDTO {
	
	private Date visitDate;
    private Long visitorCount;
    
    public VisitDTO(Date visitDate,Long visitorCount) {
    	this.visitDate = visitDate;
    	this.visitorCount = visitorCount;
    	
    }

}
