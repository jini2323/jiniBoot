/*
package kr.co.laura.security.domain;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


//@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "VISITOR")
@SequenceGenerator(name = "AVISITOR_SEQ_GENERATOR", sequenceName = "VISITOR_SEQ", allocationSize = 1)
public class Visitor {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="VISITOR_SEQ_GENERATOR") 
	    private Long vnum; // 기본키

	    private String userIp;

	    @Temporal(TemporalType.TIMESTAMP)
	    private Date vdate;
	    
	    private String refer; //--접속자가 어느사이트를 타고 들어왔는지
	    
	    private String userAgent;

	    @Builder
	    public Visitor(Long vnum, String userIp, Date vdate,
	    		String refer, String userAgent) {
	    	
	    	this.vnum = vnum;
	    	this.userIp = userIp;
	    	this.vdate = vdate;
	    	this.refer = refer;
	    	this.userAgent = userAgent;
	    	System.out.println("builder로 방문자 레코드 생성!");		
	    	
	    }
	    
	
	    

}
*/