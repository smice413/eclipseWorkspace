package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Action;
import service.ActionForward;
import service.Delete;
import service.Idcheck;
import service.Login;
import service.MemberInsert;
import service.Update;
import service.UpdateMember;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do") // *(모든 이름).do : do확장자로 요청하는 모든 이름에 대해 요청받는다는 의미
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// doGet(), doPost() 메소드에서 공통적인 작업을 처리하는 메소드
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()); //13번째 인덱스 번호 부터 잃어라
		
		System.out.println("requestURI:"+requestURI); //  /model2member/MemberInsert.do
		System.out.println("contextPath:"+contextPath); // /model2member
		System.out.println("command:"+command); // /MemberInsert.do
		
		Action action = null;
		ActionForward forward = null;
		
		// 회원 가입
		if(command.equals("/MemberInsert.do")) {
			try {
				action = new MemberInsert(); //업케스팅
				forward = action.execute(request, response); // 메소드 오버라이딩된 것만 실행됨. 인터페이스의 추상메소드를 쓰려면, super.으로 생성자를 만들어야함.
			}catch(Exception e ) {
				e.printStackTrace();
			}
		// ID중복 검사(ajax)
			
		}else if(command.equals("/Idcheck.do")) {
			try {
				action = new Idcheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원가입 폼	
		}else if(command.equals("/MemberForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/memberform.jsp");
		
		// 로그인(회원인증)	
		}else if(command.equals("/Login.do")){
			try {
				action = new Login();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 로그인 폼	
		}else if(command.equals("/LoginForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/loginform.jsp");
		
		// 로그아웃
		}else if(command.equals("/Logout.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/logout.jsp"); // logout.jsp에서 세션값을 삭제하고 loginform.jsp로 가는 경로를 만들어야함.
		
		// 회원정보 수정 폼	
		}else if(command.equals("/UpdateMember.do")) {
			try {
				action = new UpdateMember();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 회원정보 수정	
		}else if(command.equals("/Update.do")) {
			try {
				action = new Update();
				forward = action.execute(request, response);
			}catch(Exception e) {
				
			}
			
		// 회원탈퇴 폼	
		}else if(command.equals("/DeleteMember.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/deleteform.jsp");
			
		// 회원탈퇴	
		}else if(command.equals("/Delete.do")) {
			try {
				action = new Delete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}// if end
		
		
		

		
		// 포워딩 처리
		if(forward != null) {
			if(forward.isRedirect()) {	// redirect 방식 포워딩
				response.sendRedirect(forward.getPath());
			}else {						// dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher =
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}// if end
		
		

		
	} // doProcess() end
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		
		doProcess(request, response); // doProcess() 호출
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");

		doProcess(request, response); // doProcess() 호출
	}

}
