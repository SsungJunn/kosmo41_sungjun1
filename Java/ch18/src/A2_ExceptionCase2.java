//
// try ~ catch의 예
//

import java.util.Scanner;

public class A2_ExceptionCase2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		try {
			System.out.print("a/b...a? ");
			int n1 = kb.nextInt();
			System.out.print("a/b...a? ");
			int n2 = kb.nextInt();
			System.out.printf("%d /%d = %d \n", n1, n2, n1 / n2); // 예외 발생 지점
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Good bye");
	}
}