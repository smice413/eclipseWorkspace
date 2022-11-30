package p2022_01_05;

class TestClass2 {
  private Object member;								//Object는 슈퍼 클래스로 String Integer Double등이 자식클래스로 되어있다.
  public void setValue(Object value){				//Object value = 3;
    member = value;
  }
   public Object getValue( ){  
    return member;    
  }                
}
class GenericTest02{  
  public static void main(String[] args) { 
   TestClass2 obj01=new TestClass2();
   
   // Object value = 3;					    오토박싱 + 업캐스팅	
   // Object value = new Integer(3);      박싱 + 업캐스팅 : 사실상 new (Object)Integer(3)인데 (Object)가 생략된것.
   obj01.setValue(3);
   System.out.println("되돌리는 값은->"+obj01.getValue( ));

   //다운 캐스팅 + 언박싱
   int n = ((Integer)(obj01.getValue())).intValue(); 
   //obj.getValue는 부모 클래스인데 Integer자식 클래스로 변환(다운 캐스팅)하고 .intValue()로 언박싱하여 int n 변수로 변환.
   //.intValue()안쓰면 자동 언박싱이 된다.
   
   
   // Object value = 3.4;					    오토박싱 + 업캐스팅	
   // Object value = new Double(3.4);         박싱 + 업캐스팅
   obj01.setValue(3.4);
   System.out.println("되돌리는 값은->"+obj01.getValue( ));

   //다운 캐스팅 + 언박싱
   double d = ((Double)(obj01.getValue())).doubleValue();
   
//   Object value = new String("이해할 수 있다.");   박싱+업캐스팅
   obj01.setValue("이해할 수 있다.");
   System.out.println("되돌리는 값은->"+obj01.getValue( ));

   //다운 캐스팅
    String str = (String)(obj01.getValue());  //String은 Wrapper 클래스가 아니기 때문에 언박싱 개념은 없다.
    										 // 즉, 문자열은 애초에 heap메모리에만 저장됨.					
   
   
  }
}                                                                                    
