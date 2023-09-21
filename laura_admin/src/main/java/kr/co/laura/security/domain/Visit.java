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


@SequenceGenerator(name = "VISIT_SEQ_GENERATOR", sequenceName = "VISIT_SEQ", allocationSize = 1)
@NoArgsConstructor
@Table(name = "VISIT")
@Entity
@Getter
public class Visit {
	
	// 비회원 포함 방문자 수 카운트?
	@Column(name = "Countnum", nullable = false)
	private Long countNum; 
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VISIT_SEQ_GENERATOR")
	@Column(name = "VISIT_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date visitDate;
	
	
	
	
	
	
	
	
}
