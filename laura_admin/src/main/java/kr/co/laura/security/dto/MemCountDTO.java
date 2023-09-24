package kr.co.laura.security.dto;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@RequiredArgsConstructor
@Getter
@Setter
public class MemCountDTO {
	
	private Long count_mdate; 
	private Date mdate;
	
	
	public MemCountDTO(Long count_mdate,Date mdate) {
		this.count_mdate = count_mdate;
		this.mdate = mdate;
		
	}
	
	

}
