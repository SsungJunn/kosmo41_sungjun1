//
// for-each문의 예제
//
public class D1_EnhancedFor {

	public static void main(String[] args) {
		
		int[] ar = {1, 2, 3, 4, 5};
		int sum = 0;
		
		// 배열 요소 전체 출력
		for(int e: ar) 
		{
			System.out.print(e + " ");
		}
		System.out.println();
		
		// 배열 요소의 전체 합 출력
		for(int e: ar) 
		{
			sum += e;
		}
		System.out.println("sum : " + sum);
	}
}