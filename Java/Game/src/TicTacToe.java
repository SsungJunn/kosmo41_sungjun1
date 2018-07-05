import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		String[][] arr = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
		Scanner s = new Scanner(System.in);

		for (int x = 0; x < 10; x++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (j == 1 || j == 2) {
						System.out.print("|  ");
					}
					System.out.print(arr[i][j] + "  ");
				}
				System.out.println();
				if (i == 0 || i == 1) {
					System.out.print("---| --- | --- ");
				}
				System.out.println();
			}

			System.out.println();
			System.out.println("Player 1, please enter the number of the square");
			System.out.print("where you want to place your X: ");
			String num = s.nextLine();

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {

					if (num.equals(arr[i][j])) {
						arr[i][j] = "X";
					}
					if (j == 1 || j == 2) {
						System.out.print("|  ");
					}
					System.out.print(arr[i][j] + "  ");
				}
				System.out.println();
				if (i == 0 || i == 1) {
					System.out.print("---| --- | --- ");
				}
				System.out.println();
			}
			
			if (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2]) {
				System.out.println("Player 1 has wonn");
				break;
			} else if (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2]) {
				System.out.println("Player 1 has wonn");
				break;
			} else if (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2]) {
				System.out.println("Player 1 has wonn");
				break;
			} else if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) {
				System.out.println("Player 1 has wonn");
				break;
			} else if (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1]) {
				System.out.println("Player 1 has wonn");
				break;
			} else if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2]) {
				System.out.println("Player 1 has wonn");
				break;
			} else if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
				System.out.println("Player 1 has wonn");
				break;
			} else if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
				System.out.println("Player 1 has wonn");
				break;
			}

			System.out.println("Player 2, please enter the number of the square");
			System.out.print("where you want to place your O: ");
			String num2 = s.nextLine();

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {

					if (num2.equals(arr[i][j])) {
						arr[i][j] = "O";
					}
				}
			}
			
			if (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2]) {
				System.out.println("Player 2 has wonn");
				break;
			} else if (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2]) {
				System.out.println("Player 2 has wonn");
				break;
			} else if (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2]) {
				System.out.println("Player 2 has wonn");
				break;
			} else if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) {
				System.out.println("Player 2 has wonn");
				break;
			} else if (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1]) {
				System.out.println("Player 2 has wonn");
				break;
			} else if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2]) {
				System.out.println("Player 2 has wonn");
				break;
			} else if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
				System.out.println("Player 2 has wonn");
				break;
			} else if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
				System.out.println("Player 2 has wonn");
				break;
			}
		}
	}
}

// for문 비교
// for (int i = 0; i < 3; i++) {
//	 for (int j = 0; j < 1; j++) {
//		 if(arr[i][j].equals(arr[i][j+1].equals(arr[i][j+2])))
//		 {
//	 		 System.out.println("1 win");
//	 		 break;
//	  	 }
//	 }
//}
