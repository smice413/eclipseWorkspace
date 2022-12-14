// DAO (Data Access Object)

package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDBBean {

	// 싱글톤 : 객체 생성을 한번만 수행
	private static BoardDBBean instance = new BoardDBBean();
	
	public static BoardDBBean getinstance() { // 정적 메소드
		return instance;
	}
	
	// Connection Pool에서 컨넥션 구해오는 메소드
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 글작성
	public int insert(BoardDataBean board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "insert into board0 ";
				   sql+=" values(board0_seq.nextval,?,?,?,?,sysdate,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getPasswd());
			pstmt.setInt(5, board.getReadcount()); //초기값 0
			pstmt.setString(6, board.getContent());
			pstmt.setString(7, board.getIp());
			
			result = pstmt.executeUpdate();		// SQL문 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {} //컨넥션을 닫으면 빌려온 것을 컨넥션 풀에 다시 반환함.
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		return result;
	}
	
	// 총 데이터 갯수 구하기
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select count(*) from board0";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); 	// SQl문 실행
			
			if(rs.next()) {
				result = rs.getInt(1); // index번호이기 때문에 1번부터 저장됨.
//				result = rs.getInt("count(*)");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {} //컨넥션을 닫으면 빌려온 것을 컨넥션 풀에 다시 반환함.
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		return result;
	}
	
	// 게시판 목록 구하기 : 데이터 10개 추출
	public List<BoardDataBean> getList(int start, int end){
		List<BoardDataBean> list = new ArrayList<BoardDataBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select * from (select rownum rnum, board.* from "; //별칭명.* : 별칭에 있는 모든 컬럼 데이터를 가져오겠다는 의미
				   sql+= " (select * from board0 order by num desc) board ) ";
				   sql+= " where rnum >= ? and rnum <= ?";
				   
				   pstmt = con.prepareStatement(sql);
				   pstmt.setInt(1, start);
				   pstmt.setInt(2, end);
				   rs = pstmt.executeQuery(); //SQL문 실행
				   
				   while(rs.next()) {
					   BoardDataBean board = new BoardDataBean();
					   
					   board.setNum(rs.getInt("num"));
					   board.setWriter(rs.getString("writer"));
					   board.setEmail(rs.getString("email"));
					   board.setSubject(rs.getString("subject"));
					   board.setPasswd(rs.getString("passwd"));
					   board.setReg_date(rs.getTimestamp("reg_date"));
					   board.setReadcount(rs.getInt("readcount"));
					   board.setContent(rs.getString("content"));
					   board.setIp(rs.getString("ip"));
					   
					   list.add(board);
				   }
				   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {} //컨넥션을 닫으면 빌려온 것을 컨넥션 풀에 다시 반환함.
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		return list;
	}
	
	
	// 상세 페이지 : 조회수 증가 + 상세정보 구하기
	public BoardDataBean updateContent(int num) {
		BoardDataBean board = new BoardDataBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "update board0 set readcount=readcount+1 "; //조회수 증가
				   sql+= " where num=?";
				   
				   pstmt = con.prepareStatement(sql);
				   pstmt.setInt(1, num);
				   pstmt.executeUpdate();  	  // SQL문 실행
				  
				   sql = "select * from board0 where num=?"; //상세정보 구하기
				   
				   pstmt = con.prepareStatement(sql);
				   pstmt.setInt(1, num);
				   rs = pstmt.executeQuery(); // SQL문 실행
				   
				   if(rs.next()) {	//조건식을 만족하는 데이터 1개를 가져온다.
					   board.setNum(rs.getInt("num"));
					   board.setWriter(rs.getString("writer"));
					   board.setEmail(rs.getString("email"));
					   board.setSubject(rs.getString("subject"));
					   board.setPasswd(rs.getString("passwd"));
					   board.setReg_date(rs.getTimestamp("reg_date"));
					   board.setReadcount(rs.getInt("readcount"));
					   board.setContent(rs.getString("content"));
					   board.setIp(rs.getString("ip"));
				   }
				   
				   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {} //컨넥션을 닫으면 빌려온 것을 컨넥션 풀에 다시 반환함.
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		
		return board;
	}
	
	// 수정 폼 : 상세 정보 구하기
	public BoardDataBean getContent(int num) {
		BoardDataBean board = new BoardDataBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
		 
			String sql = "select * from board0 where num=?"; //상세정보 구하기
				   
				   pstmt = con.prepareStatement(sql);
				   pstmt.setInt(1, num);
				   rs = pstmt.executeQuery(); // SQL문 실행
				   
				   if(rs.next()) {	//조건식을 만족하는 데이터 1개를 가져온다.
					   board.setNum(rs.getInt("num"));
					   board.setWriter(rs.getString("writer"));
					   board.setEmail(rs.getString("email"));
					   board.setSubject(rs.getString("subject"));
					   board.setPasswd(rs.getString("passwd"));
					   board.setReg_date(rs.getTimestamp("reg_date"));
					   board.setReadcount(rs.getInt("readcount"));
					   board.setContent(rs.getString("content"));
					   board.setIp(rs.getString("ip"));
				   }
				   
				   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {} //컨넥션을 닫으면 빌려온 것을 컨넥션 풀에 다시 반환함.
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		
		return board;
	}
	
	// 글수정
	public int update(BoardDataBean board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update board0 set writer=?,email=?,subject=?,";
				   sql+= "content=? where num=?";
				   
				   pstmt = con.prepareStatement(sql);
				   pstmt.setString(1, board.getWriter());
				   pstmt.setString(2, board.getEmail());
				   pstmt.setString(3, board.getSubject());
				   pstmt.setString(4, board.getContent());
				   pstmt.setInt(5, board.getNum());
				   result = pstmt.executeUpdate();		//SQL문 실행. 성공적으로 실행되면 1을 리턴함
				   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {} //컨넥션을 닫으면 빌려온 것을 컨넥션 풀에 다시 반환함.
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		
		return  result;
	}
	
	// 글삭제
	public int delete(int num) {
		int result =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "delete from board0 where num=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();		//SQL문 실행. 삭제가 잘되면 1을 돌려줌. 예외발생하면 0을 돌려줌
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {} //컨넥션을 닫으면 빌려온 것을 컨넥션 풀에 다시 반환함.
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
}
