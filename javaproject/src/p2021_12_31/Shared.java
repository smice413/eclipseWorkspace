package p2021_12_31;
//StaticCount파일에서 호출하는 것
public class Shared {
    public static void main( String[] args ) {
    
        StaticCount sc1 = new StaticCount();	//new 연산자를 쓰는 순간 heap메모리에 공간이 생기지만 정적필드는 공유영역에 저장되기 때문에
                                               //heap메모리 공간에는 필드값이 없다. 따라서 공유영역에서 초기값 3을 가져온다.
        System.out.println("sc1.number = " + sc1.number); //3
        
        sc1.number++;
        System.out.println("sc1.number = " + sc1.number);  //4 가장 마지막에 할당된 값이 4이다. 공유영역에 저장된 3에서 +1 된것.
        
        StaticCount sc2 = new StaticCount();
        System.out.println("sc2.number = " + sc2.number);	//4 공유영역에 저장된 마지막 값이 4이기 때문.
        													//heap메모리에 따로 저장되는 것이었으면 3이 나옴
        sc2.number++;
        System.out.println("sc2.number = " + sc2.number);	//5 가장 마지막에 할당된 값 4에 +1 한것.

        System.out.println(StaticCount.number); //5
        
        
    
    
    }
}
            
        
        
        