//
// 인터페이스의 상속
// 인터페이스를 상속받아 컬러프린트 사용가능
// 인터페이스 하나에 같이 구현하게 되면 해당되는 인터페이스의 모든 메소드를 구현해야되기 때문에
// 인터페이스의 상속을 이용하여 이러한 문제를 해결 함.
//

interface Printable2 {
	void print(String doc);
}

interface ColorPrintable extends Printable2 {
	void printCMYK(String doc);
}

class Prn909Drv3 implements ColorPrintable {
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

class B1_PrinterDriver {

	public static void main(String[] args) {
		String myDoc = "This is a report about...";
	
	ColorPrintable prn = new Prn909Drv3();
	prn.print(myDoc);
	
	System.out.println();
	prn.printCMYK(myDoc);
	}
}
