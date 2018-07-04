//
// 제네릭 이전 코드가 갖는 문제점 1
//

class Apple3 {
	public String toString() {
		return "I am an apple.";
	}
}

class Orange3 {
	public String toString() {
		return "I am an orange.";
	}
}

class Box3 {
	private Object ob;
	
	public void set(Object o) {
		ob = o;
	}
	public Object get() {
		return ob;
	}
}

public class A3_FruitAndBoxFault {

	public static void main(String[] args) {
		// 과일 담는 박스 생성
		Box3 aBox = new Box3();
		Box3 oBox = new Box3();
		
		// 과일을 박스에 담은 것일까?
		// 아래 두 문장에서는 사과와 오렌지가 아닌 '문자열'을 담았다.
		aBox.set("Apple");
		oBox.set("Orange");
		
		// 박스에서 과일을 제대로 꺼낼 수 있을까?
		// 상자에 과일이 담기지 않았는데 과일을 꺼내려 해서 error가 남.
		Apple3 ap = (Apple3)aBox.get();
		Orange3 og = (Orange3)oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}
}
