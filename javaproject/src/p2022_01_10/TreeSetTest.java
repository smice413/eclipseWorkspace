package p2022_01_10;

import java.util.Iterator;
import java.util.TreeSet;

// TreeSet
// : 오름차순으로 정렬하고 저장하고 출력하는 기능을 제공. 중복된 데이터 저장X

// 오름차순 정렬: 
//숫자: 작은 숫자 부터 큰 숫자 순으로 정렬 ex)1,2,3,4,5
//문자: 사전순 정렬 ex)a,b,c,d,e



public class TreeSetTest {//set은 순차적인 기능이 없지만 상속 받는 treeset은 원소값을 오름차순 정리하여 나타낸다.
	/**
	 * HashSet 테스트
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet hs = new TreeSet();
		
		if(hs.add("korea")){//boolean형이 들어갔기 때문에 true가 되면 추가 성공.
			System.out.println("첫 번째 korea 추가 성공");
		}
		else{
			System.out.println("첫 번째 korea 추가 실패");
		}
		if(hs.add("japan")){
			System.out.println("japan 추가 성공");
		}
		else{
			System.out.println("japan 추가 실패");
		}
		if(hs.add("america")){
			System.out.println("america 추가 성공");
		}
		else{
			System.out.println("america 추가 실패");
		}
		if(hs.add("britain")){
			System.out.println("britain 추가 성공");
		}
		else{
			System.out.println("britain 추가 실패");
		}
		if(hs.add("korea")){//중복된 데이터 저장X
			System.out.println("두 번째 korea 추가 성공");
		}
		else{
			System.out.println("두 번째 korea 추가 실패");
		}
		
		//오름 차순으로 정렬된 결과를 출력
		System.out.println(hs);
		
		//반복자 : america, britain, japan, korea
		Iterator it = hs.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}		
	}
}
