package p2021_12_28;

public class ArrayEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 배열에 저장된 데이터 중에서 최대값과 최소값을 구하는 프로그램을 작성하세요?
		
		double[] data = {9.5, 7.0, 13.6, 7.5, 10.5};
		
		double max, min;
		
		max = data[0];				//max변수의 초기값 9.5
		min = data[0];				//min변수의 초기값 9.5
		
		for(int i = 1; i<data.length; i++) {//i의 초기값을 1번 방으로 한 것은 본인과 비교 안해도 되기 때문
			if(data[i]>max) {
				max = data[i]; //1번 방부터 계속 max와 비교하면서 최대값 구하는 것.
			}//if문 end
			if(data[i]<min) {
				min = data[i];
			}//if문 end
		}//for문 end
		System.out.println("max:"+max);
		System.out.println("min:"+min);
		
		
		
		
		
	}

}
