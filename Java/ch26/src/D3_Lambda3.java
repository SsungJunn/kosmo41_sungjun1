//
// ������ ����
//

interface PrintableC {
	void print(String s);
}
class D3_Lambda3 {

	public static void main(String[] args) {
		// ���� ����, �ʹ� ª��, �͸�Ŭ������ ���� �����ϴ�!
		// ����Ʈ�ⷰ �� �Ű����� s�� �������̽���~
		PrintableC prn = (s) -> { System.out.println(s); };
		prn.print("What is Lambda??");
	}
}