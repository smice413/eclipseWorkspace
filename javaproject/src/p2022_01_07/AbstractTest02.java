package p2022_01_07;

abstract class ShapeClass{		//추상클래스
	abstract void draw();		//추상메소드
}
//메소드의 다형성: 상속을 받으면서 같은 코딩을 했지만 구현 내용만 다르게 하여(=메소드 오버라이딩) 동작이 다양하게 나타나는 특징을 말함
class Circ extends ShapeClass{
	void draw(){				//추상클래스의 상속 받았기 때문에 추상메소드를 반드시 오버라이딩해야함
		System.out.println("원을 그린다");
	}
}
class Rect extends ShapeClass{
	void draw(){				//추상클래스의 상속 받았기 때문에 추상메소드를 반드시 오버라이딩해야함
		System.out.println("사각형을 그린다");
	}
}
class Tria extends ShapeClass{
	void draw(){         		//추상클래스의 상속 받았기 때문에 추상메소드를 반드시 오버라이딩해야함
		System.out.println("삼각형을 그린다");
	}
}
public class AbstractTest02{
	public static void main(String args[]){
		Circ c =  new Circ();
		Rect r = new Rect();
		Tria t=  new Tria();
	
		c.draw();
		r.draw();
		t.draw();
	}
}

