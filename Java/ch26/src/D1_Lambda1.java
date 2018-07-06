//
// 람다의 이해1
//

interface PrintableA {
	void print(String s);
}

class PrinterA implements PrintableA {
	public void print(String s) {
		System.out.println(s);
	}
}

class D1_Lambda1 {

	public static void main(String[] args) {
		PrintableA prn = new PrinterA();
		prn.print("What is Lambda?");
	}
}