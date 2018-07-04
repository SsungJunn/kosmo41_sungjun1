//
// 두 배열의 내용 비교
//

import java.util.Arrays;

public class D3_ArrayEquals {

	public static void main(String[] args) {
		int[] ar1 = {1, 2, 3, 4, 5};
		int[] ar2 = Arrays.copyOf(ar1, ar1.length);
		// 두 배열에 저장된 데이터의 수, 순서 그리고 내용이 같을 때 true를 반환(다르면 false반환)
		System.out.println(Arrays.equals(ar1, ar2));
	}
}