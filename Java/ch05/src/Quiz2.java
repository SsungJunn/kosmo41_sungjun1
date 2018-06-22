import java.util.Scanner;
/*
public class Quiz52 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num1;
		int num2;
		double avg = 0;
			
			System.out.println("몇개의 정수를 입력할거야?");
			num1 = s.nextInt();
			
			System.out.println("정수입력");
			
			for(num2 = 0; num2 < num1; num2++) {
				num2 = s.nextInt();
				avg = (avg + num2);
			}
		System.out.println("Avg = " + (avg/num1));
	}
}
*/

public class Quiz2 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("입력받으삼");
		int num1 = s.nextInt();
		float nSum = 0;
		
		System.out.println("정수넝으삼");
		for(int i = 0; i < num1; i++) {
			
			i = s.nextInt();
			
			nSum = nSum + i;
		}
		System.out.println(nSum / num1);
	}
}