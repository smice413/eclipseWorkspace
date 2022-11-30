package p2022_01_06;

import java.text.DecimalFormat;

//반지름(r)이 5인 경우에 다음을 구하는 프로그램을 작성 하세요.
//(단, 결과는 소숫점 2째자리 까지 결과가 나타나도록 해야함)
//     DecimalFormat 클래스를 이용 해서 해결 하세요. 또는 printf이 것을 이용
//
//원주(원둘레) = 2 * PI * r
//원의 면적 =  PI * r * r
//구의 표면적 = 4 * PI * r * r
//구의 체적(부피) = 4/3 * PI * r * r * r

class Pi{
	double circle1 (double r) {
		return 2 * Math.PI * r;
	}
	double circle2 (double r) {
		return Math.PI * r * r;
	}
	double circle3 (double r) {
		return 4 * Math.PI *r * r;
	}
	double circle4 (double r) {
		return 4/3 * Math.PI *r *r * r;
	}
}

public class HomeWork2022_01_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int r = 5;
		Pi c = new Pi();
		System.out.printf("원둘레:"+"%.2f\n",c.circle1(r));
		System.out.printf("원의 면적:"+"%.2f\n",c.circle2(r));
		System.out.printf("구의 표면적:"+"%.2f\n",c.circle3(r));
		System.out.printf("구의 체적(부피):"+"%.2f\n",c.circle4(r));
		
		System.out.println();

		DecimalFormat cir = new DecimalFormat("###.00");
		System.out.println("원둘레"+cir.format(c.circle1(r)));
		System.out.println("원의 면적"+cir.format(c.circle2(r)));
		System.out.println("구의 표면적"+cir.format(c.circle3(r)));
		System.out.println("구의 체적(부피)"+cir.format(c.circle4(r)));
		
	}

}
