package p2021_12_29;

public class HomeWork2021_12_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2차원 배열을 이용해서 5명 학생들의 국어,영어,수학        
//	       점수를 저장 했을때, 과목별 총점과 학생별 총점을 
//	       출력하는 프로그램을 작성하세요?
//	    (단, 과목명(국어,영어,수학), 학생번호를 출력 하세요) 
//      *이름을 넣으려면 1차원 배열을 추가 해야함.		
		
		
		int[][] score = { { 85, 60, 70 }, // 0 행
						  { 90, 95, 80 }, // 1 행
						  { 75, 80, 100}, // 2 행
						  { 80, 70, 95 }, // 3 행
						  { 100, 65, 80 } // 4 행
						};
		int[] subject = new int[3]; // 과목총점 저장
		int[] student = new int[5]; // 학생의 총점 저장
		// subject[0]=0, student[0]=0;
		int r, c;
        String[] str1= {"국어","영어","수학"};
		String[] str2= new String[] {"학생1","학생2","학생3","학생4","학생5"};
		
		System.out.println("각 과목별 총점구하기 ");
		for (c = 0; c < 3; c++) { // 과목
			for (r = 0; r < 5; r++) { // 학생
				subject[c] += score[r][c];
			} // subject[c]=subject[c]+score[r][c];
			System.out.println(str1[c]+":"+subject[c]);
		}

		System.out.println("학생별 총점구하기");
		for (r = 0; r < 5; r++) { // 학생
			for (c = 0; c < 3; c++) { // 과목
				student[r] += score[r][c];
			} // student[r]=student[r]+score[r][c];
			System.out.println(str2[r]+":"+student[r]);
		}

	}

}
