package kr.co.laura.security.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import groovy.transform.builder.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "adminloginlog")
@Entity
@Getter
@SequenceGenerator(name = "adminloginlog_seq_GENERATOR", sequenceName = "adminloginlog_seq", allocationSize = 1)
public class AdminLoginLog {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminloginlog_seq_GENERATOR")
	@Column(name = "adlognum")
	private Long adlognum; // --기본키

	@Column(name = "adid", nullable = false)
	private String adid; // --아이디(이메일) 유니크 걸기

	@Column(name = "adreip", nullable = false)
	private String adreip;

	@Column(name = "aduagent", nullable = false)
	private String aduagent;

	@Column(name = "adstatus", nullable = false)
	private String adstatus;

	@CreationTimestamp // insert시 현재시간,날짜를 저장
	@Column(name = "adlogtime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date adlogtime;

	// 날짜 부분을 오늘 날짜로 설정
	@Transient // 데이터베이스 컬럼으로 매핑하지 않음
	private Date today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

	@Builder
	public AdminLoginLog (String adid, String adreip, String aduagent, 
			String adstatus, Date today) {
		
		this.adid = adid;
		this.adreip = adreip;
		this.aduagent = aduagent;
		this.adstatus = adstatus;
		this.adlogtime = today;
		
		System.out.println("builder로 AdminLoginLog 생성!");
		System.out.println("adreip:"+adreip);

	}
	
	
	

}
