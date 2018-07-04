//
// 둘 이상의 예외 처리를 위한 구성2
// 목적 : 예외가 발생했을 시 어떻게 처리해야되는지!!!
//

import java.util.InputMismatchException;
import java.util.Scanner;

public class A5_ExceptionCase5 {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		try {
			System.out.print("a/b...a? ");
			int n1 = kb.nextInt();
			System.out.print("a/b...a? ");
			int n2 = kb.nextInt();
			System.out.printf("%d /%d = %d \n", n1, n2, n1 / n2); // 예외 발생 지점
		}
		catch(ArithmeticException | InputMismatchException e) {
			e.getMessage();
			
			
		}
		
		System.out.println("Good bye~~!");
	}
}