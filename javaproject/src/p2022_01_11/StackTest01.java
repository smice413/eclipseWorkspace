package p2022_01_11;

import java.util.Stack;

public class StackTest01 {
  public static void main(String[] args) {
    Stack myStack = new Stack();
    myStack.push("1-자바"); 
    myStack.push("2-C++"); 
    myStack.push("3-API"); 
    myStack.push("4-MFC"); //가장 나중에 넣은 자료지만 가장 먼저 출력됨.

//    System.out.println(myStack.pop()); 		//4-MFC
//    System.out.println(myStack.pop()); 		//3-API
//    System.out.println(myStack.pop()); 		//2-C++
//    System.out.println(myStack.pop()); 		//1-자바
//    System.out.println(myStack.pop()); 		//EmptyStackException 예외발생
    
    
    while(!myStack.isEmpty()) {	//비어있지 않을 때
      System.out.println( myStack.pop());//출력해라
    }
  }    
}                                                     
