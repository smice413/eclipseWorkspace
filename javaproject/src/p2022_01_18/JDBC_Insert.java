package p2022_01_18;

// 도스 콘솔 창에서 사용자 입력을 받아들이기 위해 BufferedReader 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class  JDBC_Insert{ //데이터를 넣는 것으로 SQL과 연동이 되어 있어야 가능하다
public static void main(String[] args) {

  String driver = "oracle.jdbc.driver.OracleDriver";
  String url = "jdbc:oracle:thin:@localhost:1521:xe";
  
//Connection과 Statement 객체를 try와 finally밖에 선언해야 2군데 모두 사용가능
  Connection con = null; //데이터 연결 객체
  Statement stmt = null; //SQL문 실행 객체

 // ResultSet  rs   = null;
  String sql;

   String name, email, tel, no ;
  
     try{
      Class.forName(driver);//JDBC Driver Loading //가장 먼저 실행해야 SQL과 연동가능
      con = DriverManager.getConnection(url, "scott", "tiger" );// connection 연결하기 위함
      stmt= con.createStatement();//insert객체를 아래에서 만들기 위해 선언해야함.

      //---JDBC_Insert 추가된 내용-------
      // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println(" customer 테이블에 값 입력하기 .....");
      System.out.print(" 번호 입력: ");
      no = br.readLine();
      System.out.print(" 이름 입력: ");
      name = br.readLine();            //테이블에 추가할 name 필드 값을 입력 받음
      System.out.print(" 이메일 입력: ");
      email = br.readLine();             //테이블에 추가할 email 필드 값을 입력 받음
      System.out.print(" 전화번호 입력: ");
      tel = br.readLine();               //테이블에 추가할 tel 필드 값을 입력 받음
      
      // INSERT 쿼리문을 작성 //statement인터페이스를 쓰면 ''와""를 쓸때 어렵다. 그래서 preparedstatement를 주로 쓰게 된다.
      sql = "INSERT into customer(no, name, email, tel) values " ;//insert(데이터 입력) 형식 2가지 중 컬럼명 쓰는 것.
      //values " 따옴표와 values사이에 공간을 띄어놔야 한다. 나중에 붙어서 결과가 출력될 수 있기 때문
      sql += "(" + no + ",'" + name +"','" + email +"','"+ tel +"')" ;
      //no는 숫자 입력값이기 때문에 ''가 없고 ""만 있다. name,email,tel은 문자값으로 넣어서 '"문자값"'이러한 형식을 취함.
      
      //Statement 객체의 executeUpdate(sql) 메서드를 이용해 
      int res = stmt.executeUpdate(sql) ;  //데이터베이스 파일에 새로운 값을 추가시킴//insert객체 선언
	  if(res == 1){//정상적으로 데이터가 추가 되었다면 1이라는 값을 리턴한다. 이는 결과가 성공적으로 진행되었다는 의미
		 System.out.println(" Data insert success!! ");
      }else{
		System.out.println(" Data insert failed ");
	  }
	}
    catch(Exception e){
      System.out.println("데이터베이스 연결 실패!");
    }
    finally{
      try{
 //       if( rs != null )   rs.close();        
        if( stmt != null ) stmt.close();
        if( con != null )  con.close();
      }
      catch(Exception e){ 
        System.out.println( e.getMessage());
      }
    }
  }
} 
