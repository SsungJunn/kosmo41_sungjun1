/*import java.util.Scanner;

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
*/
public class Quiz10 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 ,4 },
						{ 5, 6, 7, 8 },
						{ 9, 10, 11, 12 },
						{ 13, 14, 15 ,16 } };
		
		arrPrint(arr);
  
		for(int k=0; k < 4; k++) {
			int[][] arr2 = new int[4][4];
			int x;
			int y;
			y=0;
			
			for(int i = 0; i < 4; i++) {
				x = 3;
				
				for(int j =0; j < 4; j++) {
					arr[i][j] = arr[x][y];
					x--;
				}
				y++;
			}
			
			// 원래 배열에 값을 다시 복사
			for(int i= 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					arr[i][j] = arr2[i][j];
				}
			}
			
			arrPrint(arr2);
		}
	}

	public static void arrPrint(int[][] arr) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
  		}
		System.out.println();
  	}
}
