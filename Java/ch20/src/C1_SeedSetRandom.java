import java.util.Random;

public class C1_SeedSetRandom {

	public static void main(String[] args) {
		Random rand = new Random(12);
		//seed 값을 줌으로써 결과값의 패턴이 똑같이 나옴
		for(int i = 0; i < 7; i++)
			System.out.println(rand.nextInt(1000));
	}

}
