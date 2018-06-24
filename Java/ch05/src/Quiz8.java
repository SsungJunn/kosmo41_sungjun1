import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int i;
		int sum = 0;
		
		for(i = 0; i < 5; i++)
		{
			System.out.println("정수 입력");
			
			int num1 = s.nextInt();
			
			if(num1 < 1)
			{
				System.out.println("재입력 바랍니다.");
				i--;
				continue;
			}
			sum = sum + num1;
		}
		System.out.println("sum = " + sum);
	}

}
