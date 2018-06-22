public class Quiz3 {

	public static void main(String[] args) {

		for(int i=1; i < 100; i++) {
				
			if(((i % 7) == 0) || ((i % 9) == 0)) {
				System.out.println(i);
			}
		}
	}
}

	// 뭐(x)부터 뭐(y)까지(미만까지)
	//		--> 반복문 : for (int i=x; i<y; i++)

	// 계속 ~ --> 반복문
	// n의 배수 --> (숫자 % n == 0)