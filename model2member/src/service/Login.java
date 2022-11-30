package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class Login implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Login");
		
		response.setContentType("text/html; charset=utf-8"); //현재문서인 한글값을 인코딩해는 코드
		request.setCharacterEncoding("utf-8"); //post값으로 전달된 한글값 인코딩
		
		PrintWriter out = response.getWriter(); // out 객체 생성
		HttpSession session = request.getSession();// session 객체 생성 .jsp가 아니어서 내장된 session객체가 없기 때문에 생성해줘야함. 
												   //request와 response는 서블릿 클래스인 컨트롤러클래스에서 매개변수로 받기 때문에 사용가능
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.memberAuth(id, passwd); // 회원인증. 매개변수는 2개의 값만 전달하기 때문에 굳이 DTO객체로 하지 않았다.
		if(result == 1) System.out.println("회원 인증 성공");
		
		if(result == 1) {		//회원 인증 성공
			session.setAttribute("id", id);  	// 세션 공유 설정
		}else {					//회원 인증 실패
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			
			return null; // execute함수를 완전히 빠져나감.
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //false를 리턴하기 때문에 컨트롤러 클래스에서 dispatcher 방식으로 포워딩 됨.
		forward.setPath("./member/main.jsp"); // 포워딩할 페이지 설정
		
		return forward; //컨트롤러클래스로 리턴함
	}

}
