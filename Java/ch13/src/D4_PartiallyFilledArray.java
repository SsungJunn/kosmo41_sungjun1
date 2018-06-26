//
// 2차원 배열의 초기화
//

public class D4_PartiallyFilledArray {
	public static void main(String[] args) {
		int[][] arr = {
			{11},
			{22, 33},
			{44, 55, 66},
			{77, 88, 99, 100}
		};
	
		// 배열에 구조대로 값을 출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}