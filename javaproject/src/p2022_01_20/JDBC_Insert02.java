package p2022_01_20;

import java.io.BufferedReader;  // 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

class  JDBC_Insert02{
public static void main(String[] args) {

//  String driver = "oracle.jdbc.driver.OracleDriver";
//  String url = "jdbc:oracle:thin:@localhost:1521:xe";	

  /** My-SQL JDBC Driver *********************************************/
	String driver ="com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/jsptest";//localhost :3307 즉, 포트번호가 mysql에서 자동으로 지정하는 3306이 아닌 사람들은 이렇게 설정해야한다.
/*******************************************************************/
  
  
  Connection con = null;
  PreparedStatement pstmt =  null;

 // ResultSet  rs   = null;
  String sql;

   String name, email, tel, no, address;
  
     try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "jspid", "jsppass" );      

      //---JDBC_Insert 추가된 내용-------
      // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println(" customer 테이블에 값 입력하기 .....");
      //시퀀스로 번호 넣기//시퀀스 대신 다른 함수(auto_increment)로 넣음
//      System.out.print(" 번호 입력: ");
//      no = br.readLine().trim();	  
      System.out.print(" 이름 입력: ");
      name = br.readLine().trim();            //테이블에 추가할 name 필드 값을 입력 받음
      System.out.print(" 이메일 입력: ");
      email = br.readLine().trim();             //테이블에 추가할 email 필드 값을 입력 받음
      System.out.print(" 전화번호 입력: ");
      tel = br.readLine().trim();               //테이블에 추가할 tel 필드 값을 입력 받음
      System.out.println("주소를 입력 하세요?");
      address = br.readLine().trim();
//	  int ino = Integer.parseInt(no);
      
	  Timestamp ts = new Timestamp(System.currentTimeMillis());
	  
      // INSERT 쿼리문을 작성 
	  
	  sql = "INSERT into customer(name,email,tel,address,reg_date) "; //no컬럼은 빼고 작성한다. //)와"사이에 간격 벌리거나, "와 values 사이에 간격벌려야함.
	  sql+= " values(?, ?, ?, ?,sysdate())";//mysql은 시퀀스가 없기 때문에 넣지 말고 mysql작성문에서 auto_increment가 시퀀스 대신 들어가있다 ,
	                                        //sysdate() 괄호를 mysql에서는 넣어야한다.

	  pstmt = con.prepareStatement( sql );
//	  pstmt.setInt(1, ino);
	  pstmt.setString(1, name);
	  pstmt.setString(2, email);
	  pstmt.setString(3, tel);
	  pstmt.setString(4, address);
//	  pstmt.setTimestamp(5, ts);
	  int result=pstmt.executeUpdate();   
	  	if(result == 1){
			 System.out.println(" Data insert success!! ");
	  	}else{
			System.out.println(" Data insert failed ");
		}
    } catch(Exception e){
      System.out.println("데이터베이스 연결 실패!");
      e.printStackTrace();
    } finally{
		try{
//			if( rs != null )   rs.close();        
			if( pstmt != null ) pstmt.close();
			if( con != null )  con.close();
		 } catch(Exception e){ 
			System.out.println( e.getMessage());
		}
    }
  }
} 
