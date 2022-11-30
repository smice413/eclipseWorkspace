package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class Idcheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Idcheck");
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter(); //웹브라우저에 출력하는 객체 생성(콜백함수로 리턴 시키기 위함)
		
		
		String id = request.getParameter("id");
		System.out.println("id:"+id);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.idcheck(id); 			//ID중복검사
		System.out.println("result:"+result);	// 1 : 중복 ID
												// -1: 사용 가능한 ID
		
		//웹브라우저에 출력되는 값이 callback 함수로 리턴된다.
		out.println(result);
		
		
		return null; //콜백함수를 위해 비동기적 처리를 해야하기 때문에 결과값을 리턴하는것이 아니라 null을 줌으로써 메소드를 종료시킴. 
	}
	
}
