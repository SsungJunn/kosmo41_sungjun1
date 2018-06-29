import java.util.Random;
import java.util.Scanner;

class MyRandom2
{
	void randPrint1()
	{
		Scanner s = new Scanner(System.in);
		Random randomV1 = new Random();
		Random randomV2 = new Random();
		Random randomV3 = new Random();				
		
		System.out.println("숫자로 하는 야구게임 시작!!!!");
		
		int Strike = 0;
		int Ball = 0;
		int i = 0;
		
		while(true)
		{	
			int com1 = (randomV1.nextInt(10));
			int com2 = (randomV2.nextInt(10));
			int com3 = (randomV3.nextInt(10));
			//int nCom = com1 * 100 + com2 * 10 + com3;
			++i;
			System.out.print("세자리 숫자를 입력하세요!!!!");
			System.out.println("(" + i + "회)");
			int nNum1 = s.nextInt();
			int nNum2 = s.nextInt();
			int nNum3 = s.nextInt();
			//int nNumSum = nNum1 * 100 + nNum2 * 10 + nNum3;
		
			System.out.println(com1 + ":" + com2 + ":" + com3);
			
			if(com1 == com2 || com2 == com3 || com1 == com3)
			{
				continue;
			}
			if(com1 != com2 && com1 != com3 && com2 != com3 )
			{
				if(com1 == nNum1 || com2 == nNum2 || com3 == nNum3)
				{
					Strike++;
					System.out.println(Strike + " Strike" + "\t" + Ball + " Ball");
				}
				
				if(com1 != nNum1 && com2 != nNum2 && com3 != nNum3)
				{
					if(com1 == nNum2 || com1 == nNum3)
					{
						Ball++;
						System.out.println(Strike + " Strike" + "\t" + Ball + " Ball");
					} else if(com2 == nNum1 || com2 == nNum3) {
						Ball++;
						System.out.println(Strike + " Strike" + "\t" + Ball + " Ball");
					} else if(com3 == nNum1 || com3 == nNum2) {
						Ball++;
						System.out.println(Strike + " Strike" + "\t" + Ball + " Ball");
					}
				}
					
				if(Strike == 3)
				{
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
