package send;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloWorld
 */
//@ : 어노테이션
//urlPatterns = { "/HelloWorld" } : 클라이언트의 요청으로 자바서블릿클래스를 찾을때 이 값이 필요함. form태그의 액션속성에 jsp경로 대신 쓰게됨.
@WebServlet(description = "처음 작성하는 자바서블릿", urlPatterns = { "/HelloWorld" })
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// response.getWriter(): out객체(출력 스트림 객체)
		//.append("Served at: ") : 화면에 출력될 내용
		// request.getContextPath(): 현재 프로젝트 명 불러옴 즉, /jsppro 출력
		
		// 현재 문서의 한글값을 인코딩(utf-8)을 시켜준다.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 	//출력 스트림 객체
		HttpSession session = request.getSession(); // 세션 객체
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>안녕 하세요?<h1>");
		out.println("<h1>안녕히 가세요.<h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// post방식으로 전달할 때 쓰는 메소드이다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
