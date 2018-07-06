//
// 람다의 이해1
//

interface PrintableB {
	void print(String s);
}

class D2_Lambda2 {

	public static void main(String[] args) {
		PrintableB prn = new PrintableB() {	// 익명클래스
			public void print(String s) {
				System.out.println(s);
			}
		};
		prn.print("What is Lambda?");
	}
}
// 람다 아직 등장 안함