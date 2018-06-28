import java.util.Random;
import java.util.Scanner;

class MyRandom
{
	void randPrint1()
	{
		Scanner s = new Scanner(System.in);
		Random randomV1 = new Random();
		Random randomV2 = new Random();
		
		
		int num1 = (randomV1.nextInt(10));
		int num2 = (randomV2.nextInt(10));
		int nNum = num1 * 10 + num2;
		
		System.out.println("나는 지금 0 부터 100 사이의 값 중에 하나를 생각할거야.");
		System.out.println("너가 그 숫자를 6회 안에 맞추면 집에 보내주지!");		
		
		while(true)
		{
			for(int i = 0; i < 6; i++)
			{
				System.out.print("몇이라고 생각해? <0 to 100>  ");
				int num = s.nextInt();
			
				if(num < nNum && num != nNum)
					System.out.println(num + " 는 내가 정한 숫자보다 작아");
				if(num > nNum && num != nNum)
					System.out.println(num + " 는 내가 정한 숫자보다  커");
				if(num == nNum)
				{
					System.out.println(num + " 는 정답이야 집에가도되!");
					System.out.println("High / Low 게임을 플레이해줘서 고마워");
					break;
				}
				if(i < 5)
				{
					System.out.println((5-i) + "의 기회가 남았어");	
				}
			}
			
			System.out.println("또 할래?? <y/n> ");
			
			String word = s.next();
			
			if(!word.equalsIgnoreCase("y"))
			{
				System.out.println("Good Bye ~");
				break;
			}
			if(word == "y")
			{
				continue;
			}
		}		
	}
}

public class HighLow {

	public static void main(String[] args) {
		MyRandom rand = new MyRandom();
		rand.randPrint1();
	}
}