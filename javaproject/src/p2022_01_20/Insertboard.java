package p2022_01_20;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insertboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		
		 /** My-SQL JDBC Driver *********************************************/
		String driver ="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/jsptest";//localhost :3307 즉, 포트번호가 mysql에서 자동으로 지정하는 3306이 아닌 사람들은 이렇게 설정해야한다.
	/*******************************************************************/
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "jspid", "jsppass" ); 
			
			BufferedReader br = 
			new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("작성자명을 입력 하세요?");
			String writer = br.readLine();
			System.out.print("비밀번호를 입력 하세요?");
			String passwd = br.readLine();
			System.out.print("제목을 입력 하세요?");
			String subject = br.readLine();
			System.out.print("내용을 입력 하세요?");
			String content = br.readLine();
			
			String sql="insert into board(writer,passwd,subject,content,reg_date) "; // )뒤에 간격벌려라. 밑의 values 앞에 간격벌려라
			       sql+=" values(?,?,?,?,sysdate())";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			
			int result = pstmt.executeUpdate();	// SQL문 실행
			if(result == 1) {
				System.out.println("글작성 성공");
			}else {
				System.out.println("글작성 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}		
		
	}

}
