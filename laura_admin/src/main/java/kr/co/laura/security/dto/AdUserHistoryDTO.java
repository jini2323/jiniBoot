package kr.co.laura.security.dto;

import java.time.LocalDate;

import kr.co.laura.security.domain.AdminLoginLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdUserHistoryDTO {
	
	private Long adlognum; // --기본키
	private String adid; // --아이디(이메일) 유니크 걸기
	private String adreip;
	private String aduagent;
	private String adstatus;
	private LocalDate adlogtime;
	
	
	  public AdUserHistoryDTO fromEntity(AdminLoginLog adminLoginLog) {
        return AdUserHistoryDTO.builder()
        		.adlognum(adminLoginLog.getAdlognum())
        		.adid(adminLoginLog.getAdid())
        		.adreip(adminLoginLog.getAdreip())
        		.aduagent(adminLoginLog.getAduagent())
        		.adlogtime(adminLoginLog.getAdlogtime())
        		.build();
    }

	
	

	
}
