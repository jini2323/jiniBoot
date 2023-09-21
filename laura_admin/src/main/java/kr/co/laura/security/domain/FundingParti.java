package kr.co.laura.security.domain;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "FUNDING_PARTI")
@Entity
@Getter
@IdClass(FunPatiPK.class)
public class FundingParti {
	
	//복합 기본키 (fmem_num, funnum_num)); 회원 번호와 참여한 펀딩 게시글 번호
	
	@Id
	@Column(name = "fmem_num", nullable = false)
	private Long fmem_num; // 펀딩참여하는 회원 번호 외래키
	
	@Id
	@Column(name = "funnum_num", nullable = false)
	private Long funnum_num; // 참여하는 펀딩 글번호  외래키
	
	@Column(name = "funmoney", nullable = false)
	private Long funmoney; // 펀딩하는 금액
	
	
	@ColumnDefault("N")
	@Column(name = "funstatus", nullable = false)
	private String funstatus; //펀딩참여여부(참여 후에는 'P')
	
	
	@Column(name = "joindate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date joindate;  //펀딩 참여일
	
	
	@Builder // 빌더패턴 : 불변의 객체를 생성 
	public FundingParti (Long fmem_num, Long funnum_num,
			Long funmoney, String funstatus,Date joindate){
		this.fmem_num = fmem_num;
		this.funnum_num = funnum_num;
		this.funmoney = funmoney;
		this.funstatus = funstatus;
		this.joindate = joindate;
		
		System.out.println("builder로 펀딩참여 생성!"); 
		System.out.println("참여 회원 넘버 :"+fmem_num); 
		System.out.println("참여한 펀딩 게시판 넘버 :"+funnum_num); 
			
	}

	
	
	

}
