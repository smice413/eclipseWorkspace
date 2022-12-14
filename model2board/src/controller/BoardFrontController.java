package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;
import service.ActionForward;
import service.BoardAddAction;
import service.BoardDelete;
import service.BoardDetailAction;
import service.BoardListAction;
import service.BoardModify;
import service.BoardModifyAction;
import service.BoardReply;
import service.BoardReplyAction;

@WebServlet("*.do")// *(모든 이름).do : do확장자로 요청하는 모든 이름에 대해 요청받는다는 의미
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// doGet(), doPost() 메소드에서 공통적인 작업을 처리하는 메소드
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI:"+ requestURI);
		System.out.println("contextPath:"+ contextPath);
		System.out.println("command:"+ command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 글작성(원문작성)
		if(command.equals("/BoardAddAction.do")) {
			try {
				action = new BoardAddAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 글작성 폼
		}else if(command.equals("/BoardForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/qna_board_write.jsp");
		
		// 글목록	
		}else if(command.equals("/BoardListAction.do")) {
			try {
				action = new BoardListAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 상세페이지
		}else if(command.equals("/BoardDetailAction.do")) {
			try {
				action = new BoardDetailAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 댓글 폼	
		}else if(command.equals("/BoardReplyAction.do")) {
			try {
				action = new BoardReplyAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 댓글 작성	
		}else if(command.equals("/BoardReply.do")) {
			try {
				action = new BoardReply();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 수정 폼
		}else if(command.equals("/BoardModifyAction.do")) {
			try {
				action = new BoardModifyAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 글 수정
		}else if(command.equals("/BoardModify.do")) {
			try {
				action = new BoardModify();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 삭제 폼	
		}else if(command.equals("/BoardDeleteAction.do")) {
			forward = new ActionForward();
			forward.setRedirect(false); 	// dispatcher 방식으로 포워딩
			forward.setPath("./board/qna_board_delete.jsp");
		
		// 글 삭제	
		}else if(command.equals("/BoardDelete.do")) {
			try {
				action = new BoardDelete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		// 포워딩 처리
		if(forward != null) {
			if(forward.isRedirect()) {	//redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			}else {						//dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
		
	}// doProcess() end
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		
		doProcess(request, response); // doProcess() 메소드 호출
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		
		doProcess(request, response); // doProcess() 메소드 호출
	}

}
