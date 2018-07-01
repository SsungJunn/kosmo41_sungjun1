public class Quiz07 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		int[][] arr2 = new int[4][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + "\t");
				arr2[j][i] = arr[i][j];
			}
			System.out.println();

		}
		System.out.println("--------------------------");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

