package service;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardBean;

public class BoardDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDelete");
		
		response.setContentType("text/html; charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String board_pass = request.getParameter("board_pass");
		
		String path = request.getRealPath("boardupload"); //경로
		System.out.println("path:"+path);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardBean old = dao.getDetail(board_num);	// 상세정보 구하기
		if(old.getBoard_pass().equals(board_pass)) {	// 비번일치시
			int result = dao.delete(board_num);	// delete SQL문 실행
			if(result == 1) System.out.println("삭제 성공");
				
			// 첨부파일이 있을 경우에 첨부파일 삭제
			if(old.getBoard_file() != "") {
				File file = new File(path);
				file.mkdir(); //폴더를 생성하는데 만들면 true값을 리턴함.
				System.out.println("file.mkdir():"+file.mkdir());
				
				// boardupload 디렉토리의 모든 첨부파일을 구해오기
				File[] f = file.listFiles();
				for(int i=0; i<f.length; i++) {
					if(f[i].getName().equals(old.getBoard_file())) {
						f[i].delete();
					}
				}
				
			}
			
			
		}else{			// 비번 불일치시
			out.println("<script>");
			out.println("alert('비번이 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.do?page="+page);
		
		return forward;
	}

}
