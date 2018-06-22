import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int i;
		int sum = 0;
		
		System.out.println("정수 입력");
		
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		int num3 = s.nextInt();
		int num4 = s.nextInt();
		int num5 = s.nextInt();
		/*
		if(z <1)
		{
			z--;
			continue;
		}
*/
		sum = num1 + num2 + num3 + num4 + num5;
		
		System.out.println("sum = " + sum);
	
	}

}
