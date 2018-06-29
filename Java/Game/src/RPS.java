import java.util.Random;
import java.util.Scanner;

class MyRandom1
{
	void randPrint1() 
	{
		Scanner s = new Scanner(System.in);
		Random randomV1 = new Random();
		
		while(true)
		{
			int com = (randomV1.nextInt(4));
			
			System.out.print("무엇을 내시겠습니까? <1: 가위, 2:바위, 3:보> : ");
			
			int num = s.nextInt();
			
			if(num == 1 && com == 2 && com != 0)
			{
				System.out.println("사용자 : 가위" + ", 컴퓨터 : 바위");
				System.out.println("졌습니다.");
			}
			if(num == 1 && com == 3 && com != 0)
			{
				System.out.println("사용자 : 가위 " + ", 컴퓨터 : 보");
				System.out.println("이겼습니다.");
			}
			if(num == 2 && com == 1 && com != 0)
			{
				System.out.println("사용자 : 바위" + ", 컴퓨터 : 가위");
				System.out.println("이겼습니다.");
			}
			if(num == 2 && com == 3 && com != 0)
			{
				System.out.println("사용자 : 바위" + ", 컴퓨터 : 보");
				System.out.println("졌습니다.");
			}
			if(num == 3 && com == 1 && com != 0)
			{
				System.out.println("사용자 : 보" + ", 컴퓨터 : 가위");
				System.out.println("졌습니다.");
			}
			if(num == 3 && com == 2 && com != 0)
			{
				System.out.println("사용자 : 보" + ", 컴퓨터 : 바위");
				System.out.println("이겼습니다.");
			}
			if(num == 1 && com == 1 && com != 0)
			{
				System.out.println("사용자 : 가위" + ", 컴퓨터 : 가위");
				System.out.println("비겼습니다.");
			}
			if(num == 2 && com == 2 && com != 0)
			{
				System.out.println("사용자 : 가위" + ", 컴퓨터 : 가위");
				System.out.println("비겼습니다.");
			}
			if(num == 3 && com == 3 && com != 0)
			{
				System.out.println("사용자 : 가위" + ", 컴퓨터 : 가위");
				System.out.println("비겼습니다.");
			}
			if(num == 0)
			{
				break;
			}
		}
	}
}

public class RPS {

	public static void main(String[] args) {
		MyRandom1 rand = new MyRandom1();
		rand.randPrint1();
	}
}