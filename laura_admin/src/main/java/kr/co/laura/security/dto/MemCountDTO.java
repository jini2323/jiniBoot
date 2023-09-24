package kr.co.laura.security.dto;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@RequiredArgsConstructor
@Getter
@Setter
public class MemCountDTO {
	
	private Long countNewMems; 
	//private Date mdate;
	private String mdate;
	
	
	
	
	public MemCountDTO(Long countNewMems,String mdate) {
		this.countNewMems = countNewMems;
		this.mdate = mdate;
		//this.mdate = mdate;
		System.out.println
		("Memcount dto 생성자:"+"가입수:"+countNewMems+  
				"mdate : "+mdate);
		
	}
	
	

}
