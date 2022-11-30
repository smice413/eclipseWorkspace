package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardBean;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardListAction");
		
		int page = 1; 			//현재 페이지 번호
		int limit = 10;			// 한 페이지에 출력할 데이터 갯수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// page =1 : startRow=1, endRow=10	1페이지의 위에서 부터 첫번째 게시글이 startRow=1 마지막 게시글이 endRow=10이다.
		// page =2 : startRow=11, endRow=20
		// page =3 : startRow=21, endRow=30
		int startRow = (page - 1) * limit +1;
		int endRow = page * limit;
		
		BoardDAO dao = BoardDAO.getInstance();
		int listcount = dao.getCount(); 	//총 데이터 갯수
		System.out.println("listcount:"+listcount);
		
		List<BoardBean> boardlist = dao.getList(startRow, endRow);
		System.out.println("boardlist:"+boardlist);
		
		// 총 페이지
		int pageCount = listcount/limit + ((listcount%limit == 0) ? 0 : 1);
		
		int startPage = ((page-1)/10) * limit + 1; // 1, 11, 21...
		int endPage = startPage + 10 - 1; 		   // 10, 20, 30.. // +10은 1개의 블럭단위(10개 페이지)를 의미함
		
		if(endPage > pageCount) endPage = pageCount; //값이 존재하지 않는 페이지가 나타나지 않게 하기 위함.
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// request 객체로 공유한 경우에는 dispatcher 방식으로 포워딩 되어야,
		// view 페이지에서 공유한 값에 접근 할  수 있다.
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);		// dispatcher 방식으로 포워딩
		forward.setPath("./board/qna_board_list.jsp");
		
		return forward;
	}

}
