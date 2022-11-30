package p2022_01_05;

class TestClass {
  private int member;						//필드
  public void setValue(int value){			//set메소드: 필드값을 수정하기 위한 메소드.
    member = value;							//member = 3
  }
  
  public void setValue(double d) {
	
  }
  public void setValue(String s) {
	 
  }
  
  
  
   public int getValue( ){  				//get메소드: 메소드 호출한 곳에 값을 돌려주는 역할 
    return member;    
  }                
}
class GenericTest01{  
  public static void main(String[] args) { 
     TestClass obj01=new TestClass();
     obj01.setValue(3);
     System.out.println("되돌리는 값은->" + obj01.getValue( ));
     obj01.setValue(3.4);
     System.out.println("되돌리는 값은->" + obj01.getValue( ));
     obj01.setValue("이해할 수 있다.");
     System.out.println("되돌리는 값은->" + obj01.getValue( ));
  }
}                                                                                    
