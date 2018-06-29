import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		int arr[][] = new int[4][4];
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				System.out.println("배열에 넣을 숫자를 입력하세요.");
				Scanner s = new Scanner(System.in);
				arr[i][j] = s.nextInt();
			}
		}
		System.out.println("정렬해 놓은 배열을 90도 회전");
		System.out.println("---------------------------");
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 3; j >= 0; j--)
			{
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("정렬해 놓은 배열을 90도 회전");
		System.out.println("---------------------------");
		
		for(int i = 3; i >= 0; i--)
		{
			for(int j = 3; j >= 0; j--)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("정렬해 놓은 배열을 90도 회전");
		System.out.println("---------------------------");
		
		for(int j = 3; j >= 0; j--)
		{
			for(int i = 0; i < 4; i++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}