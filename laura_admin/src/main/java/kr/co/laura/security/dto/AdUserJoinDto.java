
package kr.co.laura.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AdUserJoinDto {

	private int deptNo; // --부서번호
	private String adPwd; // --비번

	private String adTel; // --담당자 번호
	private String adEmail; // --담당자 아이디(이메일) 유니크 걸기
	
	

}
