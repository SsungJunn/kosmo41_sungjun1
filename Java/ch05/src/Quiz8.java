import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int i;
		int sum = 0;
		
		for(i = 0; i < 5; i++)
		{
			System.out.println("���� �Է�");
			
			int num1 = s.nextInt();
			
			if(num1 < 1)
			{
				System.out.println("���Է� �ٶ��ϴ�.");
				i--;
				continue;
			}
			sum = sum + num1;
		}
		System.out.println("sum = " + sum);
	}

}
