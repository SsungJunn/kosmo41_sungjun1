//
// �Ű������� �ְ� ��ȯ�ϴ� ���ٽ�1
//

interface Calculate4 {
	int cal(int a, int b);	// ���� ��ȯ�ϴ� �߻� �޼ҵ�
}
class A4_TwoParamAndReturn {

	public static void main(String[] args) {
		Calculate4 c;
		c = (a, b) -> { return a + b; };	// return���� �߰�ȣ�� ���� �Ұ�!
		//int num = c.cal(4, 3);	// �̿� ���� ���� ����� ���´�.
		System.out.println(c.cal(4, 3));
		
		c = (a, b) -> a + b;;	// ���� ����� ������, ������ ������� �ʾƵ� ��ȯ ����� ��!
		System.out.println(c.cal(4, 3));
	}
}
// �޼��� ��ü�� �ش��ϴ� ������ return ���̸�
// �� ������ �ϳ��̴��� �߰�ȣ�� ������ �Ұ����ϴ�.