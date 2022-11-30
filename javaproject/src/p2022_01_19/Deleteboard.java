package p2022_01_19;



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
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			BufferedReader br=
				new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("삭제할 글번호를 입력하세요?");
			int ino = Integer.parseInt(br.readLine());//형변환을 반드시 해서 string형을 int형으로 바꾸고
			
			String sql = "delete from board where no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ino);//형변환된 int형 ino를 setint()메소드에 넣는다.
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("글삭제 성공");
			}else {
				System.out.println("글삭제 실패");
			}
			
		}catch(Exception e) {
//			e.printStackTrace();
			System.out.println("글번호를 입력 하세요.");
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
