//
// 배열의 탐색: 기본 자료형 값 대상의 Ex
//

import java.util.Arrays;

class D7_ArraySearch {

	public static void main(String[] args) {
		int[] ar = {33, 55, 11, 44, 22};
		Arrays.sort(ar);	// 탐색 이전에 정렬이 선행되어야 한다.
		
		for(int n : ar)
			System.out.print(n + "\t");
		System.out.println();
		
		// 배열 ar에서 key(33) 값을 찹아서 있으면 key의 인덱스 값, 없으면 0보다 작은 수 반환
		int idx = Arrays.binarySearch(ar, 33);
		System.out.println("Index of 33: " + idx);
	}

}
