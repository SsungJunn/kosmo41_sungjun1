import java.util.Scanner;

public class Quiz08 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int sum = 0;
		int sum2 = 0;
		int[][] arr = new int[4][4];	
		
		for(int i = 0; i < 4; i++)
		{
			switch (i)
			{
			case 0:
				System.out.println("4명의 국어점수를 입력하시오.");
				break;
			case 1:
				System.out.println("4명의 영어점수를 입력하시오.");
				break;
			case 2:
				System.out.println("4명의 수학점수를 입력하시오.");
				break;
			case 3:
				System.out.println("4명의 국사점수를 입력하시오.");
				break;
			default:
				break;
			}
			for(int j = 0; j < 4; j++)
			{
				arr[i][j] = s.nextInt();
			}
		}System.out.println();
		
		System.out.println("구분"+"\t"+"이순신"+"\t"+"강감찬"+"\t"+"을지문덕"+"\t"+"권율"+"\t"+"총점");
		System.out.println();
		
		for(int i = 0; i < 4; i++)
		{
			switch (i)
			{
			case 0:
				System.out.print("국어\t");
				break;
			case 1:
				System.out.print("영어\t");
				break;
			case 2:
				System.out.print("수학\t");
				break;
			case 3:
				System.out.print("국사\t");
				break;
			default:
			break;
			}
			
			for(int j = 0; j < 4; j++)
			{
				System.out.print(arr[i][j] + "\t");
				sum = sum + arr[i][j];
				if(j == 3)
				{
					System.out.println(sum);
				}
			}sum = 0;
			System.out.println();
		}
		System.out.print("총점"+"\t"); 
		for(int j= 0; j < arr.length; j++)
		{
			for(int i = 0; i < arr.length; i++)
			{
				sum2 = sum2 + arr[i][j];
			}System.out.print(sum2 + "\t");
			sum2 = 0;
		}
	}
}