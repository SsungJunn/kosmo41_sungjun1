import java.util.Scanner;
/*
public class Quiz52 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num1;
		int num2;
		double avg = 0;
			
			System.out.println("��� ������ �Է��Ұž�?");
			num1 = s.nextInt();
			
			System.out.println("�����Է�");
			
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
		System.out.println("�Է¹�����");
		int num1 = s.nextInt();
		float nSum = 0;
		
		System.out.println("����������");
		for(int i = 0; i < num1; i++) {
			
			i = s.nextInt();
			
			nSum = nSum + i;
		}
		System.out.println(nSum / num1);
	}
}