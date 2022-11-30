package p2021_12_29;

public class ArrayEx08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 교재 p167~168 예제
// 배열 복사: for문으로 배열 복사
		
		int[] oldArray = {10, 20, 30}; //원본 배열
		int[] newArray = new int[5]; //새로운 배열
		//newArray에 oldArray 복사하려면 더 큰 저장 공간으로 해야함
		for(int i=0; i<oldArray.length; i++) {
			newArray[i] = oldArray[i]; //배열 복사
		}
		
		//복사된 배열 출력
		for(int i: newArray) {
			System.out.print(i+"\t");
		}
		
	}

}
