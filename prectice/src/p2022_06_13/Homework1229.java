package p2022_06_13;

public class Homework1229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2차원 배열을 이용해서 5명 학생들의 국어,영어,수학        
//	       점수를 저장 했을때, 과목별 총점과 학생별 총점을 
//	       출력하는 프로그램을 작성하세요?
//	    (단, 과목명(국어,영어,수학), 학생번호를 출력 하세요) 
//   *이름을 넣으려면 1차원 배열을 추가 해야함.
		
		
		int[][] score = {{100,100,50},
						 {90,75,80},
						 {65,40,100},
						 {25,100,30},
						 {100,100,100}};
		int[] subs= new int[3];
		int[] stus= new int[5];
		
		String[] sub = {"국어","영어","수학"}; 
		String[] stu = {"a","b","c","d","e"};
		for(int i=0; i<3; i++) {
			for(int j=0; j<5; j++) {
				subs[i] += score[j][i];
			}
			System.out.println(sub[i]+":"+subs[i]);
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				stus[i] += score[i][j];
			}
			System.out.println(stu[i]+":"+stus[i]);
		}
		
		
	}

}
