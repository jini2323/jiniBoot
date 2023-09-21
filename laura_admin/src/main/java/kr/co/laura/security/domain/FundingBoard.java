package kr.co.laura.security.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "FBOARD")
@Entity
@Getter
@SequenceGenerator(name = "FBOARD_SEQ_GENERATOR", sequenceName = "FBOARD_SEQ", allocationSize = 1)
public class FundingBoard {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FBOARD_SEQ_GENERATOR")
	@Column(name = "funnum")
	private Long funnum; // --기본키

	
	@Column(name = "fupmemnum", nullable = false)
	private Long fupmemnum; // 펀딩 업로드 회원 번호
	
	@Column(name = "funcategory", nullable = false)
	private String funcategory; //영화 카테고리
	
	
	@Column(name = "funtitle", nullable = false)
	private String funtitle; //펀딩제목

	@Column(name = "funwriter", nullable = false)
	private String funwriter; // 업로드 작성자

	@Lob
	@Column(name = "content", nullable = false)
	private String content; // 펀딩 본문 내용

	
	@Column(name = "funpreview", nullable = false)
	private String funpreview; //- 펀딩 미리보기

	
	@Column(name = "targetprice", nullable = false)
	private Long targetprice; // 목표금액
	
	@Column(name = "cost", nullable = false)
	private Long cost; // 펀딩 금액(목록박스)
	
	
	@Column(name = "postimgn", nullable = false)
	private String postimgn; // 펀딩 포스터이미지
	
	@Column(name = "sdate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date sdate;  //펀딩 시작일
	
	@Column(name = "fdate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fdate;  //펀딩 종료일
	
	@Column(name = "contentimg")
	private String contentimg; //펀딩 내용 이미지
	
	@Column(name = "funvideo")
	private String funvideo; // 펀딩 비디오파일
	
	@Column(name = "actpic")
	private String actpic; // 배우 이미지
	
	
	@Lob
	@Column(name = "funpurpose")
	private String funpurpose; // 펀딩 목적

	@Lob
	@Column(name = "funbudget")
	private String funbudget; // 펀딩 예산안
	
	
	@CreationTimestamp // insert시 현재시간을 저장
	@Column(name = "fupdate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fupdate;  //펀딩글 작성일
	

	
	@Builder // 빌더패턴 : 불변의 객체를 생성 
	public FundingBoard (
			Long fupmemnum,String funcategory,
			String funtitle, String funwriter,
			String content, String funpreview, Long targetprice,
			Long cost, String postimgn, Date sdate, Date fdate,
			String contentimg,
			String funvideo,  String actpic, String funpurpose,
			String funbudget, Date fupdate
			)
	{
		this.fupmemnum = fupmemnum;
		this.funtitle = funtitle;
		this.funcategory = funcategory;
		this.funwriter = funwriter;
		this.content = content;
		this.funpreview = funpreview;
		this.targetprice = targetprice;
		this.cost = cost;
		this.postimgn = postimgn;
		this.sdate = sdate;
		this.fdate = fdate;
		this.funvideo = funvideo;
		this.contentimg = contentimg;
		this.actpic = actpic;
		this.funpurpose = funpurpose;
		this.funbudget = funbudget;
		this.fupdate = fupdate;
		
  System.out.println("builder로 펀딩게시판 글 생성!"); 
  System.out.println(funtitle); 
  
 }
	
	
	
	
	
	

}
