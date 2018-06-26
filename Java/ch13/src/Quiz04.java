import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
	
		int[] arr = new int[10];
		
		for(int i = 0; i < 10; i++)
		{
			Scanner s = new Scanner(System.in);
			System.out.println("숫자를 입력하세요.");
			
			arr[i] = s.nextInt();	
		}
		System.out.print("결과 = ");
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 != 0)
			{
				System.out.print(arr[i] + " ");
			}
		}
		
		for(int i = 9; i > 0; i--)
		{
			if(arr[i] % 2 == 0)
			{
				System.out.print(arr[i] + " ");
			}
		}
	}
}