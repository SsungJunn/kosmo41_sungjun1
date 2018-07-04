//
// 제네릭 클래스와 상속
// 같은 타입만 상속받아 사용가능하다 
//

class Box1<T> {
	protected T ob;
	
	public void set(T o) { ob = o; }
	public T get() { return ob; }
}

class SteelBox1<T> extends Box1<T> {
	public SteelBox1(T o) {		// 제네릭 클래스의 생성자
		ob = o;
	}
}

class A1_GenericInheritance {

	public static void main(String[] args) {
		Box1<Integer> iBox = new SteelBox1<>(7959);
		Box1<String> sBox = new SteelBox1<>("Simple");
		
		System.out.println(iBox.get());
		System.out.println(sBox.get());
	}

}
