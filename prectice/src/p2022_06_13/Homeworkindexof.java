package p2022_06_13;

import java.util.StringTokenizer;

public class Homeworkindexof {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String message = "Java program creates many objects.";
		
		System.out.println(message.length());
		int index = message.indexOf("a");
		System.out.println(index);
		int lastindex = message.lastIndexOf("a");
		System.out.println(lastindex);
		int index1 = message.indexOf("a", 12);
		System.out.println(index1);
		int lastindex1 = message.lastIndexOf("a", 17);
		System.out.println(lastindex1);
		
		char chart = message.charAt(13);
		System.out.println(chart);
		int leng = message.length();
		
		for(int i=0; i<leng; i++) {
			char chart1 = message.charAt(i);
			if(chart1 == 'a') {
				System.out.println("index:"+i);
			}
		}
		
		String[] paxing = message.split(" ");
//		for(int i=0; i<paxing.length; i++) {
//			System.out.println(paxing[i]);
//		}
		for(String s : paxing) {
			System.out.println(s);
		}
		
		StringTokenizer stz = new StringTokenizer(message , " ");
		
		while(stz.hasMoreTokens()) {
			System.out.println(stz.nextToken());
		}
		
		
	}

}
