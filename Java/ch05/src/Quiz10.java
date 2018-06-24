import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		int sum = 0;
		
		System.out.println("정수 입력");
		
		num1 = s.nextInt();
		num2 = s.nextInt();	
		
		if(num1 < num2) 
		{
			for(int i = num1; num1 <= num2; num1++)
				{
				sum = sum + num1;
				}
				System.out.println("sum = " + sum);
			}
		else
		{
			for(int i = num1; num1 >= num2; num1--)
				{
				sum = sum + num1;
				}
				System.out.println("sum = " + sum);
			}
		}
}