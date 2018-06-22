import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num1;
		int sum = 0;
		
		do {
			System.out.println("숫자를 입력하세요.");
			num1 = s.nextInt();
			sum = sum + num1;
			
		}while(num1 != 0);
		System.out.println("sum = " + sum);
	}

}
