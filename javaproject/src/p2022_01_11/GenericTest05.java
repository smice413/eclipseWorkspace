package p2022_01_11;

class GenericClass<T> {//<T> 템플릿이라고 여러자료형이 올 수 있다는 제네릭. 물론 값은 일시적 저장만 됨.
  private T member;
  public void setValue(T value){
    member = value;
  }                                
   public T getValue( ){  
    return member;    
  }                
}
class GenericTest05{  
  public static void main(String[] args) { 
     GenericClass<Double> obj01=new GenericClass<Double>();
     obj01.setValue(3.4);
     System.out.println("되돌리는 값은->" + obj01.getValue( ));

     GenericClass<Integer> obj02=new GenericClass<Integer>( );
     obj02.setValue(new Integer(10));
     System.out.println("되돌리는 값은->" + obj02.getValue( ));

     GenericClass<String> obj03=new GenericClass<String>( );
     obj03.setValue("이해할 수 있다.");
     System.out.println("되돌리는 값은->" + obj03.getValue( ));
  }
}     