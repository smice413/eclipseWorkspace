package p2022_01_18;

import java.io.BufferedReader; // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class JDBC_Insert01 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection con = null;
		PreparedStatement pstmt = null;

		//ResultSet rs = null;
		String sql;

		String name, email, tel, no;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");

			// ---JDBC_Insert 추가된 내용-------
			// 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println(" customer 테이블에 값 입력하기 .....");
			System.out.print(" 번호 입력: ");
			no = br.readLine();
			System.out.print(" 이름 입력: ");
			name = br.readLine(); // 테이블에 추가할 name 필드 값을 입력 받음
			System.out.print(" 이메일 입력: ");
			email = br.readLine(); // 테이블에 추가할 email 필드 값을 입력 받음
			System.out.print(" 전화번호 입력: ");
			tel = br.readLine(); // 테이블에 추가할 tel 필드 값을 입력 받음

			int ino = Integer.parseInt(no);

			// INSERT 쿼리문을 작성
			sql = "INSERT into customer (no, name, email, tel) values (?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);//sql값을 읽어와야한다.왜냐하면 ?의 값을 설정하기 위함.//statement와 객체선언 위치가 다르다.
			pstmt.setInt(1, ino);//1은 첫번째 ?에 들어가라는 의미 //값을 설정하기 위해 set메소드씀
			pstmt.setString(2, name);//2는 두번째 ?에 들어가라는 의미
			pstmt.setString(3, email);
			pstmt.setString(4, tel);
			int result=pstmt.executeUpdate(); //넣은 값을 업데이트 해서 결과를 int형으로 돌려준다.
			if(result == 1){
				System.out.println("데이터 입력 성공");
			}else{
				System.out.println("데이터 입력 실패");
			}

		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		} finally {
			try {
		//		if (rs != null)
		//			rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
