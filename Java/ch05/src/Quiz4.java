import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("���ڸ� �Է��ϼ���.");
		
		int num1 = s.nextInt();
		int num2 = s.nextInt();

		if(num1 > num2)
			System.out.println(num1 - num2);
		else
			System.out.println(num2 - num1);	
	}
}
