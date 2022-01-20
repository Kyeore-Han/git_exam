package member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//쿠키
		/*
		Cookie[] ar = request.getCookies(); //특정 쿠키를 얻을 수 없으므로 모든 쿠키를 가져온다
		if(ar != null){
			for(int i=0; i<ar.length; i++){
				if(ar[i].getName().equals("memName")) {
					ar[i].setPath("/mvcmember");
					ar[i].setMaxAge(0); //쿠키 삭제
					response.addCookie(ar[i]); //클라이언트에게 보내기
				}
				
				if(ar[i].getName().equals("memId")) {
					ar[i].setPath("/mvcmember");
					ar[i].setMaxAge(0); //쿠키 삭제
					response.addCookie(ar[i]); //클라이언트에게 보내기
				}
			}//for
		}//if
		*/
		
		//세션
		HttpSession session = request.getSession();
		session.removeAttribute("memName");
		session.removeAttribute("memId");
		
		session.invalidate(); //무효화, 모든 세션 삭제
		
		return "/member/logout.jsp";
	}

}






















