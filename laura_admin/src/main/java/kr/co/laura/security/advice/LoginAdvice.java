package kr.co.laura.security.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Component
@Aspect
public class LoginAdvice {
	
	/*
	@Around(value = "")
	public ModelAndView memLoginLogger(ProceedingJoinPoint jp) {
		
		ModelAndView rpath = null; // 전처리 끝
		// step1) 메서드의 이름을 가져와서 로그인과 로그아웃을 구별한다.
		String methodName = jp.getSignature().getName(); // 조인포인트가 가진 모든 거
		// System.out.println("methodName:" + methodName);
		// null이 진행되버리기 때문에 페이지가 안보이는 오류

		// step2) JoinPoint로부터 타겟 객체의 메서드의 인자 값을 받아오기
		Object[] fd = jp.getArgs(); // 조인 포인트를 배열로 받기 조인포인트 전부
		// 파라미터가 뭘로 들어올지 미지수니 object로 받는다. 인자가 없을수도, 있을수도 있다.

		// for(Object e: fd) {
		// System.out.println(e.getClass().getName());
		// }

		// login, logout 구별하기
		if (methodName.equals("loginfProcess")) {

			try {
				// 로그인 메서드를 호출하고 반환되는 ModelAndView 를 저장하는
				rpath = (ModelAndView) jp.proceed();

			} catch (Throwable e) {
				e.printStackTrace();
			}
			System.out.println("후처리 로깅작업");

			HttpSession session = (HttpSession) fd[0]; // Args에서 해당 세션을 가져온다.
			// 배열의 인덱스 1번째, 즉 타겟의 메서드 인자 값 두번째가 HttpServletRequest 로 부터 아이피를 저장
			String uid = (String) session.getAttribute("sessionID");
			// String reip1 = (String) session.getAttribute("sessionReip");
			String reip2 = ((HttpServletRequest) fd[1]).getRemoteAddr();
			userAgent = (String) fd[3];

			System.out.println("uid=>" + uid);
			System.out.println("reip1 아이피 출력=>" + reip2);
			System.out.println("userAgent=>" + userAgent);
			System.out.println("===============");

			if (uid != null) {
				System.out.println("후처리 실행");
				// 후처리를 사용한 로깅
				// 로그인 정보를 데이터베이스에 저장하기
				// 후처리를 사용한 로깅
				// 로그인 정보를 데이터베이스에 저장하기 //lvo.setIdn(dto.getId()); dto 받는게 불가 그래서 대신
				MyLoginLoggerVO lvo = new MyLoginLoggerVO();
				lvo.setIdn(uid);
				lvo.setStatus("login");
				lvo.setReip(reip2); // 연습문제 => DB에 저장된거 ㄴㄴ 진짜 접속할때의 ip를 가져온다 (httprequest request)
				lvo.setUagent(userAgent); // reip1=> 내가 한거, reip2=>썜 코드
				
				//테이블 틀린거 수정 후 작성   //로그인 추척이 된다.
				memberList.addLoginLogging(lvo);
			} else {
				System.out.println("후처리 실행 안해 !");
			}

		} else if (methodName.equals("loginfoutProcess")) { // 로그아웃
			// 전처리를 사용한 로깅
			System.out.println("전처리 로깅작업");
			HttpSession session = (HttpSession) fd[0]; // 배열의 인덱스 1번째, 즉 타겟의 메서드 인자 값 두번째가 HttpServletRequest 로 부터 아이피를
			String uid = (String) session.getAttribute("sessionID");											// 저장
			String reip2 = ((HttpServletRequest) fd[1]).getRemoteAddr();
			// String reip1 = (String) session.getAttribute("sessionReip");

			System.out.println("uid =>" + uid);
			System.out.println("아이피를 출력 =>" + reip2);
			System.out.println("userAgent 출력 =>" + userAgent);
			System.out.println("===============");

			MyLoginLoggerVO lvo = new MyLoginLoggerVO();
			lvo.setIdn(uid);
			lvo.setReip(reip2);
			lvo.setStatus("logout");
			lvo.setUagent(userAgent);
			System.out.println("userAgentL222:"+userAgent);
			//테이블 틀린거 수정 후 작성   //로그인 추척이 된다.
			memberList.addLoginLogging(lvo);  //=> 로그인 후에 MYLOGINLOG 테이블에 데이터 추가 됐는지 테스트 
			

			try {
				// 로그아웃 메서드를 호출하고 반환되는 Modeland view
				rpath = (ModelAndView) jp.proceed(); 

			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		return rpath;

		
		
	}
	*/
	

}
