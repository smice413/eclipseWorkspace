package p2022_01_20;
//MYSQL과 JAVA연동 테스트하는 코딩
public class JDBC_Connect01{

  public static void main(String[] args)  {

/** ORACLE JDBC Driver Test ***************************/
//	String driver = "oracle.jdbc.driver.OracleDriver";  // oracle.jdbc.driverㅡ>ojdbc6.jar의 패키지 경로 이다.//OracleDriver ㅡ>바이트 코드이다.
/******************************************************/

/** My-SQL JDBC Driver Test **************************/	
	String driver ="com.mysql.jdbc.Driver";//mysql과 java연동이 되었는지 확인한다.//com.mysql.jdbc패키지 안에 Driver.class라는 바이트코드가 있다.
/*****************************************************/

    try{//DB연동하는 것에서 반드시 예외처리 해야한다.
      Class.forName(driver);//JDBC Driver Loading
      //class안에 있는 .forname()정적 메소드로 jdbc driver를 메모리 상에 가장 먼저 로딩해야한다.그래야 연동됨
      
      System.out.println("JDBC Driver Loading 성공~!!");

    }catch(Exception e){
      System.out.println("JDBC Driver Loading 실패~!!");
	  e.printStackTrace();
    }
 }
}  
