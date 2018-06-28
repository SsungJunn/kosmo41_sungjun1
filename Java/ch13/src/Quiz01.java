import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int[] arr = new int[5];
		int nMax = 0;
		int nMin = 1000;
		int sum = 0;
		
		for(int i = 0 ; i < arr.length; i++)
		{	
			System.out.println("숫자를 입력하세요.(100미만)");
			arr[i] = s.nextInt();
			sum = sum + arr[i];
		
			if(nMax < arr[0] ) {
				nMax = arr[0];
			}	
			if(nMax < arr[1] ) {
				nMax = arr[1];
			} 
			if(nMax < arr[2] ) {
				nMax = arr[2];
			} 
			if(nMax < arr[3] ) {
				nMax = arr[3];
			} 
			if(nMax < arr[4] ) {
				nMax = arr[4];
			}
		}	System.out.println("최대값 = " + nMax + '\n');
		for(int i = 0; i < arr.length; i++)
		{
			if(nMin > arr[0] ) {
				nMin = arr[0];
			}	
			if(nMin > arr[1] ) {
				nMin = arr[1];
			} 
			if(nMin > arr[2] ) {
				nMin = arr[2];
			} 
			if(nMin > arr[3] ) {
				nMin = arr[3];
			} 
			if(nMin > arr[4] ) {
				nMin = arr[4];
			}
		}	System.out.println("최대값 = " + nMin + '\n');
		System.out.println("합 = " + sum);
	}
}
