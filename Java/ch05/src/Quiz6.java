import java.util.Scanner;

public class Quiz6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("어떤 단을 보고싶니?");
		
		int num1 = s.nextInt();
			
		for(int i = num1; i < 10; ) 
		{
			if(num1 != 0)
			{
				for(int j = 9; j > 0; j--) 
				{
				System.out.println(j + " x " + i + " = " + (i*j));
				}
			}break;
		}
	}
}



