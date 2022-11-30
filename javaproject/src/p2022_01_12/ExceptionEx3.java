package p2022_01_12;

public class ExceptionEx3 {

	public static void main(String[] args) {
		int var = 50;
								//args[0] = "5" 예외발생 안함 //run configuration-Argument-5-Apply-run
								//args[0] = "a" 예외발생	
								//args[0] = "0"	예외발생
		try {
			int data = Integer.parseInt(args[0]);

			System.out.println(var / data);

			// Exception 예외 클래스가 하위 예외 클래스들을
			// 모두 가지고 있기 때문에 먼저 정의해서는 안된다.
		/*}catch (Exception e) {
		 System.out.println("Exception !!");
				*///즉, 이렇게 처음에 오면 하위 예외 클래스들을 실행 못하게되어서 오류가 발생.
		} catch (NumberFormatException ne) {
			System.out.println("숫자가 아닙니다.");
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌순 없죠?");
		} catch (Exception e) {
			System.out.println("Exception !!");//예외가 해당 catch와 맞는 것이 없기 때문에 모든 것을 포함한Exception으로 오게됨. 
		}

		System.out.println("프로그램 종료!");
	}
}
