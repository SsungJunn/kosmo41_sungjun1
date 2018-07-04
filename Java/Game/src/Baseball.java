import java.util.Random;
import java.util.Scanner;


class MyRandom2 {
	void randPrint1() {
		Scanner s = new Scanner(System.in);
		Random randomV1 = new Random();
		Random randomV2 = new Random();
		Random randomV3 = new Random();

		System.out.println("숫자로 하는 야구게임 시작!!!!");

		int Strike = 0;
		int Ball = 0;
		int Out = 0;
		int i = 0;

		while (true) {
			int com1 = (randomV1.nextInt(9) + 1);
			int com2 = (randomV2.nextInt(9) + 1);
			int com3 = (randomV3.nextInt(9) + 1);

			if (com1 == com2 && com1 == com3 && com2 == com3) {
				continue;
			}
			if (com1 != com2 && com1 != com3 && com2 != com3) {
				++i;

				System.out.print("세자리 숫자를 입력하세요!!!!");
				System.out.println("(" + i + "회)");
				int nNum1 = s.nextInt();
				int nNum2 = s.nextInt();
				int nNum3 = s.nextInt();

				System.out.println(com1 + ":" + com2 + ":" + com3);

				if (com1 == nNum1 || com2 == nNum2 || com3 == nNum3) {
					Strike++;
					System.out.println(Strike + " Strike" + "  " + Ball + " Ball" + "  " + Out + " Out");
				}

				if (com1 != nNum1 || com2 != nNum2 || com3 != nNum3) {
					if (com1 == nNum2 || com1 == nNum3) {
						Ball++;
						System.out.println(Strike + " Strike" + "  " + Ball + " Ball" + "  " + Out + " Out");
					} else if (com2 == nNum1 || com2 == nNum3) {
						Ball++;
						System.out.println(Strike + " Strike" + "  " + Ball + " Ball" + "  " + Out + " Out");
					} else if (com3 == nNum1 || com3 == nNum2) {
						Ball++;
						System.out.println(Strike + " Strike" + "  " + Ball + " Ball" + "  " + Out + " Out");
					} else if (com1 != nNum1 && com2 != nNum2 && com3 != nNum3) {
						Out++;
						System.out.println(Strike + " Strike" + "  " + Ball + " Ball" + "  " + Out + " Out");
					}
				}
				
				if (Strike == 3 || Out == 3) {
					System.out.println("YOU WIN!!!");
					break;
				}
			}
		}
	}
}


public class Baseball {

	public static void main(String[] args) {
		MyRandom2 rand = new MyRandom2();
		rand.randPrint1();
	}
}


/*
public class Baseball {
	public static void main(String[] args) {
		int com1 = 0, com2 = 0, com3 = 0; // 랜덤값의 각 자리수값을 받기 위한 변수
		int user1, user2, user3;		  // 입력값의 각 자리수값을 받기 위한 변수
		
		int i;	// 게임을 10회까지 계속하기 위한 for문용 변수
		
		int x = 0; // 스트라이크 표시
		int y = 0; // 볼 표시
		
		Random rand = new Random();
		Scanner s = new Scanner(System.in);
		
		// com1, com2, com3 이 서로 다른 값이 나오도록 설정
		while ( com1==com2 || com1==com3 || com2==com3 )
		{
			com1 = rand.nextInt(8) + 1;
			com2 = rand.nextInt(8) + 1;
			com3 = rand.nextInt(8) + 1;
		}
		
		System.out.println("숫자로 하는 야구게임시작");
		
		for ( i=0; i<=9; i++ )
		{
			x = 0;
			y = 0;
			
			System.out.println("세자리 숫자를 입력하세요.(" + i+1 + "회)");
			// System.out.println("컴퓨터 랜검값 : " + xom1 + xom2 + xom3 ); /*랜덤값 확인
			
			int nInput = s.nextInt();
			user1 = nInput / 100;
			user2 = (nInput - user1 * 100 / 10);
			user3 = (nInput - user1 * 100 - user2 * 10);
			System.out.println(user1 + ":" + user2 + ":" + user3);
			
			// 스트라이크 체크
			if(user1==com1)
			{
				x++;
			}
			if(user2==com2)
			{
				x++;
			}
			if(user3==com3)
			{
				x++;
			}
			
			// 볼 체크
			if(user1==com2 || user1==com3)
			{
				y++;
			}
			if(user2==com1 || user2==com3)
			{
				y++;
			}
			if(user3==com1 || user3==com2)
			{
			y++;
			}
			
			// 결과 출력
			System.out.println(x + " Strike    "+y+" Ball");
			
			// 스트라이크 세개일 경우 처리
			if(x==3)
			{
				System.out.println("YOU WIN!!!");
				break;
			}
			
			//10번 기회 제공. 패배 처리
			if(i==9)
			{
				System.out.println("YOU LOSE!!!");
				break;
			}
		} //for문 끝
	}
}
*/