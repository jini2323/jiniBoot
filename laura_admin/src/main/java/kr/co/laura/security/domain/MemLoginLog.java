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
@Table(name = "memloginlog")
@Entity
@Getter
@SequenceGenerator(name = "memloginlog_seq_GENERATOR", sequenceName = "memloginlog_seq", allocationSize = 1)
public class MemLoginLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memloginlog_seq_GENERATOR")
	@Column(name = "lognum")
	private Long lognum; // --기본키

	@Column(name = "idn", nullable = false)
	private String idn; // --아이디(이메일) 유니크 걸기

	@Column(name = "reip", nullable = false)
	private String reip;

	@Column(name = "uagent", nullable = false)
	private String uagent;

	@Column(name = "status", nullable = false)
	private String status;

	@CreationTimestamp // insert시 현재시간,날짜를 저장
	@Column(name = "logtime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date logtime;

	// 날짜 부분을 오늘 날짜로 설정
	@Transient // 데이터베이스 컬럼으로 매핑하지 않음
	private Date today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

	@Builder
	public MemLoginLog(String idn, String reip, String uagent, String status, Date today) {
		this.idn = idn;
		this.reip = reip;
		this.uagent = uagent;
		this.status = status;
		this.logtime = today;

		System.out.println("builder로 Memlogging 생성!");
		System.out.println(uagent);

	}

}
