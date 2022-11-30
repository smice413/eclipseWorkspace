package p2022_01_20;
//MYSQL과 JAVA연동 테스트하는 코딩
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connect02{

  public static void main(String[] args)  {

/** ORACLE JDBC Driver Test *****************************************/
//	String driver = "oracle.jdbc.driver.OracleDriver"; 
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";//사용하게될 DB의 경로를 url로 표시
	//java와 oracle이 같은 ip로 접근하는 경우는 localhost로 접근
	//만약에 원격으로 한다면 아마존 웹서버로 접속하면 같은 ip가 아니기 때문에 oracle이 설치된 곳의 ip를 써야함.도메인으로 쓰는 것도 가능
	//port번호 1521로 서버와 클라이언트가 socket을 연결
	//xe 는 전역데이터베이스 명이다. 현재 프로그램 버전이xe이기 때문에 xe로 접속해야한다.
//	String url = "jdbc:oracle:thin:@3.36.123.111:1521:xe"; 강사님 아마존서버에 오라클 설치한것 
/*******************************************************************/

/** My-SQL JDBC Driver *********************************************/
	String driver ="com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/jsptest";//localhost :3307 즉, 포트번호가 mysql에서 자동으로 지정하는 3306이 아닌 사람들은 이렇게 설정해야한다.
/*******************************************************************/

    Connection con = null;//import 필요

    try{

      Class.forName(driver);

/**   ORACLE에서 Connection 객체 ***********************************/
//    con = DriverManager.getConnection(url, "scott", "tiger" ); //계정과 비번
    //DriverManager클래스명의.getConnection(url, "scott", "tiger" )정적 메소드(메소드 오버로딩(매개변수 3개))
    //static 정적메소드 이기 때문에 클래스명.메소드로 호출가능
/*******************************************************************///여기 까지가 공통적인 코드임

/**   My-SQL에서 Connection 객체 ***********************************/
	  con = DriverManager.getConnection(url, "jspid", "jsppass" );
/*******************************************************************/

		System.out.println("데이터베이스 연결 성공~!!");

    } catch(Exception e){
		System.out.println("데이터베이스 연결 실패~!!");
		e.printStackTrace();
    } finally{
		try{
			if( con != null )         con.close();
		} catch(Exception e){
			System.out.println( e.getMessage( ));  
        }
   }
 }
}  
