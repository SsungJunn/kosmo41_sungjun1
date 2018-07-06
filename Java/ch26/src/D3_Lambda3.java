//
// 람다의 이해
//

interface PrintableC {
	void print(String s);
}
class D3_Lambda3 {

	public static void main(String[] args) {
		// 람다 등장, 너무 짧어, 익명클래스에 비해 간단하다!
		// 프린트출럭 한 매개변수 s를 인터페이스로~
		PrintableC prn = (s) -> { System.out.println(s); };
		prn.print("What is Lambda??");
	}
}