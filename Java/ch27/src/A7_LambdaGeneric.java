/*
 * ���ٽİ� ���׸�
 * �Լ��� �������̽� : �߻� �޼��尡 �� �ϳ��� �����ϴ� �������̽�!
 */

@FunctionalInterface
interface Calculate <T> {	// ���׸� ����� �Լ��� �������̽�
	T cal(T a, T b);
}

class A7_LambdaGeneric {

	public static void main(String[] args) {
		Calculate<Integer> ci = (a, b) -> a + b;
		System.out.println(ci.cal(4, 3));
		
		Calculate<Double> cd = (a, b) -> a + b;
		System.out.println(cd.cal(4.32, 3.45));
	}
}
// �������̽��� ���׸� ����̶� �Ͽ� Ư���� �Ű� �� �κ��� ����.
// Ÿ�� ���ڰ� ������ �Ǹ�(������ �Ǹ�) �߻� �޼ҵ���  T�� ������ �ǹǷ�!!