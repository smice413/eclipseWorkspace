package p2022_01_11;

import java.util.LinkedList;
import java.util.Queue;

class LinkedListTest {
  public static void main(String[] args) {

	  
//	큐(Queue) : FIFO(First Input First Output)구조
	Queue myQue = new LinkedList();		//업캐스팅  
//    LinkedList myQue = new LinkedList();  
    myQue.offer("1-자바");              
    myQue.offer("2-C++");
    myQue.offer("3-API");
    myQue.offer("4-MFC");
        
//    System.out.println(myQue.poll());	//1-자바 //출력을 시키면 자료구조의 데이터는 삭제됨. 그래서 다음 자료데이터가 첫입력값으로 출력됨
//    System.out.println(myQue.poll());	//2-C++
//    System.out.println(myQue.poll());	//3-API
//    System.out.println(myQue.poll());	//4-MFC
//    System.out.println(myQue.poll());	//null	//앞에 출력을 다시키고 자료구조의 데이터가 모두 삭제되었기 때문에 비어있어서 null이 뜸
////  큐(Queue)가 비어있으면 null값을 리턴함.  
    
//.peek() 가장 마지막 데이터를 구해오는 역할   
    while(myQue.peek() != null)        //큐가 비어있지 않다면
      System.out.println(myQue.poll()); //큐에서 데이터를 꺼내온다.
  }  
 }    