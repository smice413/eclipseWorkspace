package p2022_06_13;

public class Arraysum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 2. 배열 합치기
//	임의의 알파벳 대문자를 담은 무작위 길이의 배열 A, B와 각 배열의 길이 A_LEN, B_LEN이 주어지면 다음과 같은 조건으로 두 배열을 병합하고 합쳐진 새로운 배열 C를
//	return하는 함수를 작성해 주세요.
//	
//	배열 병합 조건
//	-A의 데이터는 순서대로 C의 0,2,4,.. 번 인덱스에 삽입됩니다.
//	-B의 데이터는 순서대로 C의 1,3,5,.. 번 인덱스에 삽입됩니다.
//  -B의 데이터를 모두 삽입해도 A의 데이터가 모두 삽입되지 않았을 경우 다시 B의 첫번째 데이터부터 삽입된다.
//  -A의 데이터가 모두 삽입된 경우 이에 대응하는 B의 데이터까지 모두 삽입해야 병합이 완료된다.

//  조건
//	-A_LEN은 B_LEN보다 크거나 같음
//  -A_LEN은 B_LEN의 2배 이하임
//  -A_LEN, B_LEN 모두 0보다 크고 100보다 작음

//  Ex)
		char[] A = { 'A', 'B', 'C', 'D', 'E' };
		char[] B = { 'X', 'Y' };
//  C=['A','X','B','Y','C','X','D','Y','E','X']
//  A=['A','B','C','D']
//  B=['X','Y','Z']
//	C=['A','X','B','Y','C','Z','D','X']	
//		String[] A = { "A", "B", "C", "D", "E" };
//		String[] B = { "X", "Y" };
		
		System.out.println(array(A, B));

	}

	public static char[] array(char[] a, char[] b) {
//	public static String[] array(String[] A, String[] B) {
		
		
		
		int length = a.length * 2;
		
		char[] c = new char[length];
		
		for(int i=0; i<length; i++) {
			if(i%2 ==0) {
				c[i]= a[i/2];
			
				
			}else {
					int index=(i-1)/2;
					if(index>=b.length) {
						index = index % b.length;
					}
					c[i]=b[index];
				
			}
		}
		
		
		
		return c;
		

		
		
//		String[] answer = new String[A.length*2];
//
//		for(int i=0; i<answer.length; i++){
//		   int index = 0;
//		   if(i%2 == 0){
//		      //A는 0,2,4....
//		      index = (int) i/2;
//		      answer[i] = A[index];
//		   }else{
//		      //B는 1,3,5...
//		      index = (int) (i-1)/2;
//
//		      //B를 다 넣었어도 처음부터 반복으로 돌아야 하므로
//		      if(index >= B.length){
//		         index = index%B.length;
//		      }
//		      answer[i] = B[index];
//		   }
//		}
//		for(int i=0; i<answer.length; i++) {
//			System.out.println(answer[i]);
//		}
//		return answer;		

		
		
	
	}
	


}
