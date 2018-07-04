//
// 제네릭 이전 코드가 갖는 문제점 2
// 프로그래머의 실수가 실행 과정에서 조차 발견되지 않을 수 있다!!
//

class Apple4 {
	public String toString() {
		return "I am an apple.";
	}
}

class Orange4 {
	public String toString() {
		return "I am an orange.";
	}
}

class Box4 {
	private Object ob;
	
	public void set(Object o) {
		ob = o;
	}
	public Object get() {
		return ob;
	}
}

public class A4_FruitAndBoxFault2 {

	public static void main(String[] args) {
		// 과일 담는 박스 생성
		Box4 aBox = new Box4();
		Box4 oBox = new Box4();
		
		// 과일을 박스에 담은 것일까?
		// 아래 두 문장에서는 사과와 오렌지가 아닌 '문자열'을 담았다.
		aBox.set("Apple");
		oBox.set("Orange");
		
		System.out.println(aBox.get());
		System.out.println(oBox.get());
	}
}
