package p2022_01_20;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Deleteboard {

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
			
			BufferedReader br=
				new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("삭제할 글번호를 입력하세요?");
			int ino = Integer.parseInt(br.readLine());//형변환을 반드시 해서 string형을 int형으로 바꾸고
			
			String sql = "delete from board where no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ino);//형변환된 int형 ino를 setint()메소드에 넣는다.
			
			int result = pstmt.executeUpdate();
			System.out.println("result"+result);
			if(result == 1) {//입력값이 정확하면 1이라는 결과로 나와서 true로 실행되지만, 입력값이 잘못되었으면 0이라는 결과가 나와서 false로 예외처리 발생한다
				System.out.println("글삭제 성공");
			}else {
				System.out.println("글삭제 실패");
			}
			
		}catch(Exception e) {
//			e.printStackTrace();
			System.out.println("글번호를 입력 하세요.");//혹여나 숫자 대신 문자를 입력했을 때 강제종료가 되지 않게 예외처리 해야한다.
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
