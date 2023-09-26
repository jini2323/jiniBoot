
package kr.co.laura.security.domain;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Table(name = "MEM")
@Entity
@Getter
@SequenceGenerator(name = "MEM_SEQ_GENERATOR", sequenceName = "MEM_SEQ", allocationSize = 1)
public class Mem {
	
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEM_SEQ_GENERATOR")
	@Column(name = "num")
	private Long num; // --기본키

	@Column(name = "email", nullable = false, unique = true)
	private String email; // --아이디(이메일) 유니크 걸기

	@Column(name = "pwd", nullable = false)
	private String pwd; // --비번

	@Column(name = "name", nullable = false)
	private String name; // 실명

	@Column(name = "nickname", nullable = false, unique = true)
	private String nickname;

	@Column(name = "tel", nullable = false, unique = true)
	private String tel;

	@Column(name = "memgender", nullable = false)
	private String memgender;

	@Column(name = "birthday", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;
	
	@Column(name = "profilepic")
	private String profilepic;
	
	@CreationTimestamp // insert시 현재시간을 저장
	@Column(name = "mdate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date mdate; //가입날짜 
	

	// columnDefinition = "default '브론즈' " 
	@ColumnDefault("브론즈")
	@Column(name = "grade", nullable = false)
	private String grade; 
	
	//여기서 부터 인증 관련 정보  , columnDefinition = "default '미인증' "
	@ColumnDefault("미인증")
	@Column(name = "arstatus", nullable = false)
	private String arstatus;
	
	@Column(name = "addr")
	private String addr;

	@Column(name = "bankaccount")
	private String bankaccount;

	
	@Column(name = "arprofilepic")
	private String arprofilepic; // 인증서? 
	
//	@Lob
	@Column(name = "arprofile")
	private String arprofile; // 인증서? 
	
	
	@CreationTimestamp // insert시 현재시간을 저장
	@Column(name = "ardate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ardate;
	
	
	@Column(name = "mempoint" , nullable = false)
	private Long point;

	
	//, columnDefinition = "default 'UNVERIFIED' "
	
	@Transient
	@ColumnDefault("UNVERIFIED")
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE_TYPE", nullable = false)
	private RoleType roleType;
	
	
	
	
	@Builder // 빌더패턴 : 불변의 객체를 생성 
	public Mem(Long num, String email, String pwd,
	String name, String nickname,
	String tel, String memgender,
	Date birthday, String profilepic,
	Date mdate, String grade,
	String arstatus, String addr,
	String bankaccount, String arprofilepic, String arprofile,
	Date ardate, Long point,RoleType roleType ) //RoleType roleType
	{
  
  this.num = num; 
  this.email = email; 
  this.pwd = pwd; 
  this.name = name;
  this.nickname = nickname; 
  this.tel = tel; 
  this.memgender = memgender;
  this.birthday = birthday; 
  this.profilepic = profilepic; 
  this.mdate = mdate;
  this.grade = "브론즈";
  this.arstatus = "미인증";
  this.addr = addr;
  this.bankaccount = bankaccount; 
  this.arprofilepic = arprofilepic;
  this.arprofile = arprofile; 
  this.ardate =ardate; 
  this.point = (long) 300;
  this.roleType = RoleType.UNVERIFIED;
  
  System.out.println("builder로 일반회원 생성!"); System.out.println(num); //여기서null이 뜬다. 
 // System.out.println("생성된 회원의 권한:"+roleType); 
  
 }
	
	
}
