import java.util.Random;

class MyRandom1
{
	void randPrint1()
	{
		Random randomV1 = new Random();
		Random randomV2 = new Random();
		Random randomV3 = new Random();
	
		while(true)
		{
			int num1 = (randomV1.nextInt(10));
			int num2 = (randomV2.nextInt(10));
			int num3 = (randomV3.nextInt(10));
		
			if((num1 != 0) && (num1 != num2) && (num1 != num3) && (num2 != num3))
			{
				System.out.print(num1);
				System.out.print(num2);
				System.out.print(num3);
				System.out.println(""
						+ "");
				break;
				}
			else 
			{
				continue;
				}
			}
		}
	void randPrint2()
	{
	Random randomV1 = new Random();
	Random randomV2 = new Random();
	Random randomV3 = new Random();

	while(true)
	{
		int num1 = (randomV1.nextInt(10));
		int num2 = (randomV2.nextInt(10));
		int num3 = (randomV3.nextInt(10));
	
		if((num1 != 0) && (num1 != num2) && (num1 != num3) && (num2 != num3))
		{
			System.out.print(num1);
			System.out.print(num2);
			System.out.print(num3);
			break;
			}
		else 
		{
			continue;
			}
		}
	}
}

public class Quiz15 {

	public static void main(String[] args)
	{
		MyRandom1 rand = new MyRandom1();
		rand.randPrint1();
		rand.randPrint2();
		
	}
}

	
	/*	
	System.out.println(randomV1.nextBoolean());
	System.out.println(randomV1.nextFloat());
	System.out.println(randomV1.nextInt());
	System.out.println(randomV1.nextInt(1000));
	
	//Type #2 : 1~1000 사이의 값 출력
	double randomV2 = Math.random();
	System.out.println("1 : " + randomV2);
	int intVal = (int)(randomV2 * 100) + 1;
	System.out.println("2 : " + intVal);
	
	//(int)(Math.random() * (최대값 - 최소값 + 1)) + 최소  */


/*		for(num1 = 0; num1 < 10; num1++)
{
	for(num2 = 0; num2 < 10; num2++)
	{
		if(num1 != num2)
		{
			System.out.println("y");
			for(num3 = 0; num3 < 10; num3++)
			{
				if(num1 != num3 && num2 != num3)
				{
					System.out.print(randomV1.nextInt(9));
					System.out.print(randomV2.nextInt(9));
					System.out.print(randomV3.nextInt(9));							
					break;
				}
			}break;
		}break;
	}break;
}*/