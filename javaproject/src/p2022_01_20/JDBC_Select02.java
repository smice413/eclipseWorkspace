package p2022_01_20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

class  JDBC_Select02{
  public static void main(String[] args)  {

//	String driver = "oracle.jdbc.driver.OracleDriver";
//    String url = "jdbc:oracle:thin:@localhost:1521:xe";

    /** My-SQL JDBC Driver *********************************************/
	String driver ="com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/jsptest";//localhost :3307 즉, 포트번호가 mysql에서 자동으로 지정하는 3306이 아닌 사람들은 이렇게 설정해야한다.
/*******************************************************************/
    
    
    Connection con  = null;
    PreparedStatement pstmt =  null;
    //---JDBC_Select 추가된 내용 -------
    ResultSet  rs   = null;
	int no = 0; 
    String name="", email="", tel="", address="";//ts;  //데이터베이스에서 얻어온 필드값 저장할 변수 선언
    Timestamp ts = null;
    String sql;               //SQL문을 저장할 변수 선언

    try{
      Class.forName(driver);
      con = DriverManager.getConnection(url, "jspid", "jsppass" );
     
      //---JDBC_Select 추가된 내용 -------
      sql = "SELECT * FROM customer";
      System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \t 주소\t 날짜\n");
      System.out.printf("-----------------------------------------------------------------\n");
	  pstmt = con.prepareStatement( sql );
      rs = pstmt.executeQuery();  //얻어진 레코드를 가져옴

      //회원가입한 날짜를 년,월,일,시,분,초,요일로 출력 하세요?
      SimpleDateFormat sim = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss EEE요일");
      
      while( rs.next() ){ //데이터를 1개씩 가져온다. 데이터가 있을 경우 true로 실행하게 된다.
		 no = rs.getInt("no"); 
         name = rs.getString("name");  
         email = rs.getString("email");     
         tel   = rs.getString("tel"); 
         address = rs.getString("address");
         ts = rs.getTimestamp("reg_date");//.toString을 붙어줌으로 timestamp를 String형으로 리턴함. 위에서 객체도 string으로 선언해야함
        System.out.printf(" %d \t %s \t %s \t %s\t %s\t %s\t  \n", no, name,email,tel,address,sim.format(ts));
      } 
    }
    catch(Exception e){
      System.out.println("데이터베이스 연결 실패!");
    }
    finally{
      try{//rs, stmt, con 객체를 close() 메서드를 호출해 해제
        if( rs != null )      rs.close();        
        if( pstmt != null )    pstmt.close();
        if( con != null )     con.close();
      }
      catch(Exception e){
        System.out.println( e.getMessage( ));  
      }
    }
  }
}  

