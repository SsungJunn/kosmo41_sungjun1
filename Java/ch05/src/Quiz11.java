import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num1;
		int num2 = 1;
		int mul = 1;
		
		System.out.print("입력정수 = ");
		num1 = s.nextInt();
		
		while(num2 < num1)
		{
			mul = mul * num1;
			
			System.out.print(num1 + " * ");
			
			num1--;
		}
		System.out.println("1 = " + mul);
	}
}