//
// 디폴트 메서드
// 인터페이스의 디폴드 메서드의 특징
// 1. 자체로 완전한 메서드이다.(비록 인터페이스 안에 있다고 하더라도....)
// 2. 따라서 이를 구현하는 클래스에서 오버라이딩 하지 않아도 된다.
//

interface Printable3 {
	void print(String doc);
	default void printCMYK(String doc) {}
}

class Prn731Dr4 implements Printable3 {
	@Override
	public void print(String doc) {
		System.out.println("From MD-909 CMYK ver");
		System.out.println(doc);
	}
}

class Prn909Drv4 implements ColorPrintable {
	@Override
	public void print(String doc) {
		System.out.println("From MD-909 black & white ver");
		System.out.println(doc);
	}
	
	@Override
	public void printCMYK(String doc) {
		System.out.println("From MD-909 CMYK ver");
		System.out.println(doc);
	}
}

class B2_PrinterDriver {

	public static void main(String[] args) {
		String myDoc = "This is a report about...";
	
	ColorPrintable prn = new Prn909Drv4();
	prn.print(myDoc);
	
	System.out.println();
	prn.printCMYK(myDoc);
	}
}
