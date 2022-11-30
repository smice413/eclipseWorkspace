// DAO(Data Access Object) 모든 DB와 관련된 것은 여기서 관리한다.

package JavaBeanMember.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LogonDBBean {

	// 싱글톤 : 객체 생성을 한번만 수행하는 것.
	// 외부에서 직접적으로 접근 못하게 private으로 하고 공유하기 위해 static으로함
	private static LogonDBBean instance = new LogonDBBean();

	public static LogonDBBean getInstance() {		//정적 메소드이며 싱클톤의 객체에게 값을 리턴하기 위해 자료형을 클래스명으로 썼다.
		return instance;
	}
	// 회원가입 : 주소값 전달에 의한 메소드 호출(Call by Reference방식)
	public int insertMember(LogonDataBean member) { //클래스형태의 자료형을 매개변수로 선언
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			// JDBC 방식
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","tiger");
			
			String sql = "insert into member2 values(?,?,?,?,?,?,?,sysdate)";
			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPasswd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getJumin1());
				pstmt.setString(5, member.getJumin2());
				pstmt.setString(6, member.getEmail());
				pstmt.setString(7, member.getBlog());
				
				result = pstmt.executeUpdate();		//SQL문 실행
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try { pstmt.close();}catch(Exception e){}
			if(con != null) try { con.close();}catch(Exception e){}
		}
		
		return result;
	}
	
	// 회원목록 출력  : 2개 이상인 전체 검색을 위해서 메소드 앞에 List가 오지만 하나만 검색하려면 DTO클래스가 오면됨
	public List<LogonDataBean> selectMember(){
		List<LogonDataBean> list = new ArrayList<LogonDataBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","tiger");
			
			String sql = "select * from member2";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();		//SQL문 실행
			
			while(rs.next()) {	//데이터를 1개씩 가져온다.
				LogonDataBean member = new LogonDataBean(); //기본 생성자 호출
//				member.id = "hong"; // private라 저장안됨 
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setJumin1(rs.getString("jumin1"));
				member.setJumin2(rs.getString("jumin2"));
				member.setEmail(rs.getString("email"));
				member.setBlog(rs.getString("blog"));
				member.setReg_date(rs.getDate("reg_date"));
				
				list.add(member);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) try { rs.close();}catch(Exception e){}
			if(pstmt != null) try { pstmt.close();}catch(Exception e){}
			if(con != null) try { con.close();}catch(Exception e){}
		}
		
		return list;
	}
	
	// 회원 수정 폼 : 회원 1명 정보 구하기 (메소드 앞에 DTO클래스 옴)
	public LogonDataBean updateForm(String id) {
		LogonDataBean member = new LogonDataBean();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","tiger");
			
			String sql = "select * from member2 where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();		//SQl문 실행
			
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setJumin1(rs.getString("jumin1"));
				member.setJumin2(rs.getString("jumin2"));
				member.setEmail(rs.getString("email"));
				member.setBlog(rs.getString("blog"));
				member.setReg_date(rs.getDate("reg_date"));
			}
			
		}catch(Exception e) {
			
		}finally {
			if(rs != null) try { rs.close();}catch(Exception e){}
			if(pstmt != null) try { pstmt.close();}catch(Exception e){}
			if(con != null) try { con.close();}catch(Exception e){}
		}
		return member;
	}
	
	// 회원 정보 수정
	// void는 값을 리턴해도되고 안해도 됨.
	public void update(LogonDataBean member) { //LogonDataBean은 클래스형태의 자료형으로 넣은 것으로 import는 같은 패키지 안에 있기 때문에 안했다.
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","tiger");
			
			String sql = "update member2 set name=?,jumin1=?,jumin2=?,";
				   sql+="email=?,blog=?,reg_date=sysdate where id=?";
				   
		    pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, member.getName());
		    pstmt.setString(2, member.getJumin1());
		    pstmt.setString(3, member.getJumin2());
		    pstmt.setString(4, member.getEmail());
		    pstmt.setString(5, member.getBlog());
		    pstmt.setString(6, member.getId());
		    pstmt.executeUpdate();	//SQL문 실행
		    
		    
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try { pstmt.close();}catch(Exception e){}
			if(con != null) try { con.close();}catch(Exception e){}
		}
	}
	// 회원정보 삭제
	public void delete(LogonDataBean member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","tiger");
			
			String sql = "delete from member2 where id=?";
				   
		    pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, member.getId());
		    pstmt.executeUpdate();	//SQL문 실행
		    
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try { pstmt.close();}catch(Exception e){}
			if(con != null) try { con.close();}catch(Exception e){}
		}
	}
	
	
}
