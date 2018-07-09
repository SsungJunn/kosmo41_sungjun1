//
// 매개변수가 없는 람다식
//

import java.util.Random;

interface Generator	{
	int rand();	// 매개변수 없는 메소드
}

class A6_NoParamaAndReturn {

	public static void main(String[] args) {
		Generator gen = () -> {
			Random rand = new Random();
			return rand.nextInt(50);
		};
		System.out.println(gen.rand());
	}
}