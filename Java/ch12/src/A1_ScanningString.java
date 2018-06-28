import java.util.Scanner;

public class A1_ScanningString {

	public static void main(String[] args) {
		String source = "1 3 5";
		Scanner sc = new Scanner(source);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		int sum = num1 + num2 + num3;
		System.out.printf("%d + %d + %d = %d\n", num1, num2, num3, sum);;
	}
}

// Scanner 클래스의 인스턴스 생성은 데이터를 뽑아 올 대상과의 연결을 의미.
// 연결 후에는 데이터 스캔 가능!