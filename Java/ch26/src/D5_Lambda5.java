//
// �Ķ���Ͱ� ���� ���� ��
//

interface PrintableE {
	void print(String s, int n);
}

class D5_Lambda5 {

	public static void main(String[] args) {
		// ����� �������� �ش� �Ķ���Ϳ� �־ ���!
		PrintableE prn = (s, n) -> {
			System.out.println(s + " : " + n);
			System.out.println(s + " : " + n);
		};
		prn.print("What is Lambda??", 5);
	}
}