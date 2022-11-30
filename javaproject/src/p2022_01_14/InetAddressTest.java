package p2022_01_14;

import java.awt.Frame;
import java.awt.Label;
import java.awt.List; //메뉴판 만들기 위한 list
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest implements ActionListener {
    private Frame f;//제목
    private List list;//큰 빈 화면
    private TextField tf;  //host쓰는 빈칸
    private InetAddress address;
    
    // constructor
    public InetAddressTest() {
	f = new Frame( "InetAddress" );
	list = new List( 10 );
	tf = new TextField( 25 );
	
	// window 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit(0); //화면의x버튼을 누를때 닫게 하는 코딩.
	    }
	});

	Panel p = new Panel();
	p.add( new Label( "HOST", Label.CENTER ));
	p.add( tf );
	
	//위치값 설정하는 것.
	f.add( list, "Center" );
	f.add( p, "South" );	
	f.setSize( 300, 300 );
	f.setLocation(300, 300);
	f.setResizable( false );
	f.setVisible( true ); //true로 해야 프레임이 나타남.
	tf.addActionListener( this );
    }//생성자 end

    // 버튼 이벤트를 처리하는 메소드
    //인터페이스로 부터 메소드 오버라이딩 된것.
    public void actionPerformed( ActionEvent ae ) { //TextField에 글을 입력하면 ActionEvent가 발생.
	list.removeAll();
	// 텍스트 필드에 입력된 내용을 저장
	String name = tf.getText();//kbs.co.kr
	System.out.println( "name = " + name );

	try {
	    // Host 명을 받아들여 InetAddress 클래스 객체 생성
	    address = InetAddress.getByName( name );//InetAddress: getbyname메소드에 도메인 명(kbs.co.kr)이 들어가면 ip주소를 구해옴
	} catch ( UnknownHostException e ) {//존재하지 않는 도메인일  때 예외발생
	    System.out.println( e );
	}
		
	// InetAddress 클래스에 정의된 메소드
	list.add( "InetAddress : " + address );
	list.add( "Host Name : " + address.getHostName() );
	list.add( "Host Address : " + address.getHostAddress() );

	try {
	    list.add( "" ); //화면에 한줄 간격을 주기 위함.
		list.add( "LocalHost : " + InetAddress.getLocalHost() ); //본인 컴퓨터에 대한 정보와 ip주소를 알기 위함.
		list.add( "LocalHost Name : " + 
				InetAddress.getLocalHost().getHostName() );//본인 컴퓨터 이름
	    list.add( "LocalHost address : " + 
				InetAddress.getLocalHost().getHostAddress() );//본인 컴퓨터 ip주소만 알려줌.
	} catch ( UnknownHostException ue ) {
	    System.out.println( ue );
	}
		
	// 텍스트 필드에 값을 입력한 후 엔터를 치고 난 후 텍스트 필드를
	//	 깨끗이 지우고 포커스를 텍스트 필드에 맞춘다. 
	tf.setText( "" );
	tf.requestFocus();
    }
	
	public static void main( String[] args ) {
	    InetAddressTest it = new InetAddressTest();
	}
}

