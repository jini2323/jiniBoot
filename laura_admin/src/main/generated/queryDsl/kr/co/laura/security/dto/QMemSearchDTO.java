/*
 * package kr.co.laura.security.dto;
 * 
 * import java.util.Date;
 * 
 * import lombok.Getter; import lombok.RequiredArgsConstructor; import
 * lombok.Setter;
 * 
 * @RequiredArgsConstructor
 * 
 * @Getter
 * 
 * @Setter public class QMemSearchDTO {
 * 
 * //검색 조건 : 회원 번호, 이메일, 닉네임,번호,성별 //가입날짜, 인증여부 ,인증일 , 등급 , 포인트
 * 
 * private String email; // --아이디(이메일) 유니크 걸기 private String nickname; private
 * String memgender; private Date mdate; //가입날짜
 * 
 * private String grade; //여기서 부터 인증 관련 정보 , columnDefinition = "default '미인증' "
 * private String arstatus; private Long point;
 * 
 * 
 * public QMemSearchDTO( String email, String nickname, String memgender, Date
 * mdate, String grade, String arstatus, Date ardate, Long point) { this.email =
 * email; this.nickname = nickname; this.memgender = memgender; this.mdate =
 * mdate; this.grade = grade; this.arstatus = arstatus; this.point = point; }
 * 
 * 
 * 
 * }
 */