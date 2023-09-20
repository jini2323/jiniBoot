package kr.co.laura.security.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SequenceGenerator(name = "MEMCOUNT_SEQ_GENERATOR", sequenceName = "MEMCOUNT_SEQ", allocationSize = 1)
@NoArgsConstructor
@Table(name = "MEMCOUNT")
@Entity
@Getter
public class MemCount {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMCOUNT_SEQ_GENERATOR")
	@Column(name = "JDATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date jdate;

	//오늘 새 회원수
	@Column(name = "TODAY_COUNT_MEM", nullable = false)
	private Long todayCountMem;
	
	//총 회원수 (누적)
	@Column(name = "TOTAL_MEM", nullable = false)
	private Long totalMem;
	
	
	

}
