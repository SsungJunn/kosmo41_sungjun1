//
// Static �׽�Ƽ�� Ŭ����
//

class Outer {
	private static int num = 0;
	static class Nested1 { // Static �׽�Ƽ�� Ŭ����
		void add(int n) { num += n; }	// Outer Ŭ������  static ���� ����!
	}
	static class Nested2 { // Static �׽�Ƽ�� Ŭ����
		int get() { return num; }	// Outer Ŭ������  static ���� ����!
	}
}
class A_StaticNested {

	public static void main(String[] args) {
		Outer.Nested1 nst1 = new Outer.Nested1(); // �ν��Ͻ� ���� ���!
		nst1.add(5);
		Outer.Nested2 nst2 = new Outer.Nested2();
		System.out.println(nst2.get());
	}
}
// Static �׽�Ƽ�� Ŭ������ static ������ ���� Ư���� �ݿ��� Ŭ�����̴�.
// ���� �ڽ��� ���δ� �ܺ� Ŭ������ �ν��Ͻ��� ������� static �׽�Ƽ��
// Ŭ������ �ν��Ͻ� ������ �����ϴ�.