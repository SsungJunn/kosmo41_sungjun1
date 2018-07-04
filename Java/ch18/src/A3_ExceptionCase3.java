//
// try로 감싸야 할 영역의 결정
//

import java.util.InputMismatchException;
import java.util.Scanner;

public class A3_ExceptionCase3 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		try {
			System.out.print("a/b...a? ");
			int n1 = kb.nextInt();
			System.out.print("a/b...a? ");
			int n2 = kb.nextInt();
			System.out.printf("%d /%d = %d \n", n1, n2, n1 / n2); // 예외 발생 지점
		}
		catch(InputMismatchException e) {
			e.getMessage();
		}
		System.out.println("Good bye");
	}
}