import java.util.Scanner;

public class Quiz9 {

	public static void main(String[] args) {
		
		int arr[] = new int[5];
		int change = 0;
		
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("배열에 넣을 숫자를 입력하세요.");
			Scanner s = new Scanner(System.in);
			arr[i] = s.nextInt();	
		}
		
		for(int i = 0; i < 5; i++)
		{
			for(int j= i; j < 4; j++)
			{
				if(arr[i] > arr[j+1])
				{
					change = arr[i];
					arr[i] = arr[j+1];
					arr[j+1] = change;
				}
			}System.out.print(arr[i] + "\t");
		}
	}
}
