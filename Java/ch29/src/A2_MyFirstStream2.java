/*
 * 스트림의 첫 번째 예제와 이해
 * 이전의 예제를 스트림을 이용해 간략하게 정리함.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

class A2_MyFirstStream2 {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5 };
		int sum =Arrays.stream(ar)	// 스트림 생성
					   .filter(n -> n%2 == 1)	// filter 통과,
					   .sum();	// sum 통과 결과 반환
		System.out.println(sum);
	}
}