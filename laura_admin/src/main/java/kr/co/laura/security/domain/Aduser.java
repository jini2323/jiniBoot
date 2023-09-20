
package kr.co.laura.security.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ADMINS")
@Entity
@Getter
@NoArgsConstructor //(access = AccessLevel.PROTECTED)
@SequenceGenerator(name = "ADMINS_SEQ_GENERATOR", sequenceName = "ADMINS_SEQ", allocationSize = 1)
public class Aduser{ // UserDetails를 상속받아 인증 객체로 사용
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="ADMINS_SEQ_GENERATOR") // 1씩 증가 ADMINS_SEQ실제 시퀀스이름 , generator = "admin_seq_generator"
	@Column(name = "ADNUM")
	private Long adNum; // --기본키

	@Column(name = "DEPTNO", nullable = false)
	private int deptNo; // --부서번호

	@Column(name = "ADTEL", nullable = false)
	private String adTel; // --담당자 번호

	@Column(name = "ADEMAIL", nullable = false, unique = true)
	private String adEmail; // --담당자 아이디(이메일) 유니크 걸기

	@Column(name = "ADPWD", nullable = false)
	private String adPwd; // --비번
	
	
	//@ColumnDefault("ADMIN") 노쓸모
	//@Column(name = "ROLE_TYPE", nullable = false)
	//private String roleType;
	
	//public enum RoleType {
	//	KING, ADMIN, VERIFIED,UNVERIFIED
		//순서대로 딱 하나 있는 킹 관리자 계정, 관리자, 인증된 회원, 미인증 회원(일반, 디폴트)
	//}
	
	@Enumerated(EnumType.STRING) //columnDefinition = "DEFAULT 'ADMIN'"
	@Column(name = "ROLE_TYPE", nullable = false)
	private RoleType roleType;
	
	
	public RoleType getRoleType() {
	    return roleType;
	}
	
	

	@Builder // 빌더패턴 : 불변의 객체를 생성 , String roleAdmin
	public Aduser(Long adNum, int deptNo, String adTel,String adEmail,
			String adPwd){
		this.adNum = adNum;
		this.deptNo = deptNo;
		this.adTel = adTel;
		this.adEmail = adEmail;
		this.adPwd = adPwd;
		this.roleType = RoleType.ADMIN;
		System.out.println("builder로 aduser 생성!");
		System.out.println(adNum); //여기서 null이 뜬다. 
		//System.out.println(deptNo);
		System.out.println("생성된 관리자 권한: "+roleType); //ok
	}

	////이상 
	/*
	public static Aduser createUser(String adEmail, String adPwd, String adTel, int deptNo,
			PasswordEncoder passwordEncoder) {

		return new Aduser(deptNo, adTel, adEmail, passwordEncoder.encode(adPwd));
	}
	*/
	
	/*빌더 패턴으로 객체 생성시 필요가 없다
	 * 
	public static Aduser createUser(
			String adEmail, int deptNo, String adPwd, String adTel
			) {

		return new Aduser(null, deptNo, adTel, adEmail,adPwd, "ADMIN");
	}
	*/


}
