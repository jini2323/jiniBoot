package kr.co.laura.security.domain;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SequenceGenerator(name = "MCNUM_SEQ_GENERATOR", sequenceName = "MCNUM_SEQ", allocationSize = 1)
@NoArgsConstructor
@Table(name = "MEMCOUNT")
@Entity
@Getter
public class MemCount {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MCNUM_SEQ_GENERATOR")
	@Column(name = "MCNUM", nullable = false)
	private Long mcnum;
	
	
	@Column(name = "JDATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date jdate;

	
	//오늘 새 회원수
	@Column(name = "TODAY_COUNT_MEM", nullable = false)
	private Long todayCountMem;
	
	//총 회원수 (누적)
	//@ColumnDefault()
	@Column(name = "TOTAL_MEM", nullable = false)
	private Long totalMem;
	
	
	@Builder // 빌더패턴 : 불변의 객체를 생성 
	public MemCount(Long mcnum, Date jdate, Long todayCountMem,Long totalMem){
		this.mcnum = mcnum;
		this.jdate = jdate;
		this.todayCountMem = todayCountMem +1;
		this.totalMem = totalMem + 1;
		System.out.println("builder로 MemCount 객체 생성!");
	}
	
	
	
	
	

}
