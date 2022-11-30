package p2022_01_19;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Selectboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs01 = null;
		ResultSet rs02 = null;
		int count = 0;		// 총 데이터 갯수
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		SimpleDateFormat sd = 
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Class.forName(driver);
			con =  DriverManager.getConnection(url, "scott", "tiger");
			
			String sql="select count(*) from board";//count(*): 총 데이터 갯수 구해주는 그룹함수
			
			pstmt = con.prepareStatement(sql);
			rs01 = pstmt.executeQuery();	//SQL문 실행
			if(rs01.next()) {	//가져올 데이터가 있으면 true로 실행됨
				count = rs01.getInt(1);//메소드 오버로딩이 되어있기 때문에 index번호인 int형이나 columlabel인 string형 둘중에 하나 쓰면됨
//				count = rs01.getInt("count(*)");
			}
			System.out.println("총데이터 수:" + count);
			
			System.out.println("번호\t작성자명\t비밀번호\t제목\t내용\t날짜");
			System.out.println("------------------------------------------------");
			
			sql = "select * from board order by no desc";//order by no(정렬기준) desc: 큰수부터 작은 수(문자는 사전역순)로 내림차순으로 정렬됨
														//asc는 오름차순이다.
			pstmt = con.prepareStatement(sql);
			rs02 = pstmt.executeQuery();//SQL문 실행
			while(rs02.next()) {
				int no = rs02.getInt("no");
				String writer = rs02.getString("writer");
				String passwd = rs02.getString("passwd");
				String subject = rs02.getString("subject");
				String content = rs02.getString("content");
				Timestamp ts = rs02.getTimestamp("reg_date");//get으로 데이터를 받아도 timestamp자료형으로 받아야함
				
				System.out.print(no+"\t"+writer+"\t"+passwd+"\t");
				System.out.print(subject+"\t"+content+"\t"+sd.format(ts)+"\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs01 != null) rs01.close();
				if(rs02 != null) rs02.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
