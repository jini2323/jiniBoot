package kr.co.laura.security.dto;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class MemDTO {
	
	private Long num; // --기본키
	private String email; // --아이디(이메일) 유니크 걸기
	private String name; // 실명
	private String nickname;
	private String tel;
	private String memgender;
	private Date birthday;
	private String profilepic;
	private Date mdate; //가입날짜 
	
	// columnDefinition = "default '브론즈' " 
	private String grade; 
	//여기서 부터 인증 관련 정보  , columnDefinition = "default '미인증' "
	private String arstatus;
	private String addr;
	private String bankaccount;
	private String arprofilepic; // 인증서? 
	private String arprofile; // 인증서? 
	private Date ardate;
	private Long point;
	
	
	public MemDTO(Long num, 
			String email, String name, 
			String nickname, String tel, String memgender, 
			Date birthday, String profilepic,
			Date mdate, String grade, String arstatus, 
			String addr, String bankaccount, String arprofilepic, 
			String arprofile, Date ardate, Long point) {
	    this.num = num;
	    this.email = email;
	    this.name = name;
	    this.nickname = nickname;
	    this.tel = tel;
	    this.memgender = memgender;
	    this.birthday = birthday;
	    this.profilepic = profilepic;
	    this.mdate = mdate;
	    this.grade = grade;
	    this.arstatus = arstatus;
	    this.addr = addr;
	    this.bankaccount = bankaccount;
	    this.arprofilepic = arprofilepic;
	    this.arprofile = arprofile;
	    this.ardate = ardate;
	    this.point = point;
	}
	
	
	

}
