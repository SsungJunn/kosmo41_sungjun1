import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		
		int[] ar1 = new int[5];
		
		Scanner s = new Scanner(System.in);
				
		for(int i = 0 ; i < 5; i++);
		{
			System.out.println("숫자를 입력하세요.(100미만)");
			//ar1[i] = s.nextInt();
		}
		int nMax = 0;
		int nMin = 1000;
		
		if(nMax < ar1[0] ) {
			nMax = ar1[0];
		}
		if(nMax < ar1[1] ) {
			nMax = ar1[1];
		}
		if(nMax < ar1[2] ) {
			nMax = ar1[2];
		}
		if(nMax < ar1[3] ) {
			nMax = ar1[3];
		}
		if(nMax < ar1[4] ) {
			nMax = ar1[4];
		}
		

	}

}
