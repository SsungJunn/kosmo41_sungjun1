import java.util.Scanner;

public class B2_FinallyCase1 {

	public static void main(String[] args) {
		
		int num;
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		try {
			num = a / b;
		} catch(Exception e) {
			//e.printStackTrace();
			num = 0;
		} finally { // 무조건 타야됨
			// 데이터베이스 접속 종료 등... 무조건 해야 될 일
			//num = num + 1;
		}
		System.out.println(num);
	}

}
