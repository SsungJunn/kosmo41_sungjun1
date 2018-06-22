import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num1;
		int mul = 1;
		
		System.out.println("입력정수");
		
		
		//while(i > 0)
		//{
			num1 = s.nextInt();
			
			for(int i = num1; i > 0; i--)
			{
				System.out.print(i + " * ");
				mul = mul * i; 
			}
			System.out.println(" = " + mul);
	//	}System.out.println(" = " + mul);

	}

}
