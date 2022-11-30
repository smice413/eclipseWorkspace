package p2022_01_04;


//p512
public class SplitEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// String[] split("구분기호")//split의 구분기호는 여러가지 사용가능
		
		String text =  "홍길동&이수홍,박연수,김자바-최명호";
		
		String[] names = text.split("&|,|-");//구분기호 여러개 쓰기
		
		for(int i=0; i<names.length;i++)
			System.out.println(names[i]);
		System.out.println();
		
		//향상된(확장) for문
		for(String name : names)
			System.out.println(name);
		
	}

}
