//
// ������ ����1
//

interface PrintableB {
	void print(String s);
}

class D2_Lambda2 {

	public static void main(String[] args) {
		PrintableB prn = new PrintableB() {	// �͸�Ŭ����
			public void print(String s) {
				System.out.println(s);
			}
		};
		prn.print("What is Lambda?");
	}
}
// ���� ���� ���� ����