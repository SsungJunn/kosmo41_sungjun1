//
// 제네릭 이후의 코드 : 개선된 결과
// 

class Apple5 {
	public String toString() {
		return "I am an apple.";
	}
}

class Orange5 {
	public String toString() {
		return "I am an orange.";
	}
}

class Box5<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class A5_FruitAndBox2_Generic {

	public static void main(String[] args) {
		// 과일 담는 박스 생성
		Box5<Apple5> aBox = new Box5<Apple5>();		// T를 Apple5로 결정
		Box5<Orange5> oBox = new Box5<Orange5>(); 	// T를 Orange5로 결정
		
		//aBox.set("Apple");
		//oBox.set("Orange");
		
		// 과일을 박스에 담는다.
		aBox.set(new Apple5());
		oBox.set(new Orange5());
		
		// 박스에서 과일을 꺼내는데 형 변환 하지 않는다.
		Apple5 ap = aBox.get();
		Orange5 og = oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}
}

