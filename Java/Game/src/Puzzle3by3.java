import java.util.Random;
import java.util.Scanner;

public class Puzzle3by3 {

	public static void main(String[] args) {
		char[][] arr = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', 'x', '8' } };
		char[][] arr2 = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', 'x' } };
		Scanner s = new Scanner(System.in);
		char change;

//		for (int x = 0; x < 100; x++) {
//			int com = (int) (Math.random() * 4);
//
//			for (int i = 0; i < 3; i++) {
//				for (int j = 0; j < 3; j++) {
//					if (com == 0) {
//						if (j == 0) {
//							continue;
//						}
//						change = arr[i][j - 1];
//						arr[i][j - 1] = arr[i][j];
//						arr[i][j] = change;
//
//					} else if (com == 1) {
//						if (j == 2) {
//							continue;
//						}
//						change = arr[i][j + 1];
//						arr[i][j + 1] = arr[i][j];
//						arr[i][j] = change;
//						j++;
//					} else if (com == 2) {
//						if (i == 2) {
//							continue;
//						}
//						change = arr[i + 1][j];
//						arr[i + 1][j] = arr[i][j];
//						arr[i][j] = change;
//						i++;
//					} else if (com == 3) {
//						if (i == 0) {
//							continue;
//						}
//						change = arr[i - 1][j];
//						arr[i - 1][j] = arr[i][j];
//						arr[i][j] = change;
//					}
//				}
//			}
//		}


		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		
		for (;;) {
			System.out.println("[ Move ] a:Left s:Right w:Up z:Down");
			System.out.println("[ Exit ] k:Exit");
			System.out.print("이동키를 입력하세요 : ");
			String num = s.nextLine();
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] == 'x') {
						if (num.equals("d")) {
							if(j == 0)
							{
								continue;
							}
							change = arr[i][j - 1];
							arr[i][j - 1] = arr[i][j];
							arr[i][j] = change;
							
						} else if (num.equals("a")) {
							if(j == 2)
							{
								continue;
							}
							change = arr[i][j + 1];
							arr[i][j + 1] = arr[i][j];
							arr[i][j] = change;
							j++;
						} else if (num.equals("w")) {
							if(i == 2)
							{
								continue;
							}
							change = arr[i + 1][j];
							arr[i + 1][j] = arr[i][j];
							arr[i][j] = change;
							i++;
						} else if (num.equals("s")) {
							if(i == 0)
							{
								continue;
							}
							change = arr[i - 1][j];
							arr[i - 1][j] = arr[i][j];
							arr[i][j] = change;
						}
					}
				}
			}
			if(num.equals("k"))
			{
				System.out.println("게임끝");
				break;
			}
			
			if(arr2.equals(arr))
			{
				System.out.println("게임끝");
				break;
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(arr[i][j] + "  ");
				}
				System.out.println();
			}
		}
	}
}