import java.util.Scanner;

public class Quiz7 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int avg = 0;
		
		System.out.println("국어");
		int num1 = s.nextInt();
		System.out.println("영어");
		int num2 = s.nextInt();
		System.out.println("수학");
		int num3 = s.nextInt();
		
		avg = (num1 + num2 + num3) / 3;
		
		if(avg >= 90)
			System.out.println("A");
		else if(avg >= 80)
			System.out.println("B");
		else if(avg >= 70)
			System.out.println("C");
		else if(avg >= 50)
			System.out.println("D");
		else
			System.out.println("F");
	}
}