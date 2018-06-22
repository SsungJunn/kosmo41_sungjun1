import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		
		int num1 = s.nextInt();
		
		if(num1 == num1)
		{
		System.out.println("제곱한 결과 : " + (num1*num1));
		}
	}

}
