//
// �Ű������� ���� ���ٽ�
//

import java.util.Random;

interface Generator	{
	int rand();	// �Ű����� ���� �޼ҵ�
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