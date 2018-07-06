//
// 파라미터가 여러 개일 때
//

interface PrintableE {
	void print(String s, int n);
}

class D5_Lambda5 {

	public static void main(String[] args) {
		// 기능을 직접만들어서 해당 파라미터에 넣어서 출루!
		PrintableE prn = (s, n) -> {
			System.out.println(s + " : " + n);
			System.out.println(s + " : " + n);
		};
		prn.print("What is Lambda??", 5);
	}
}