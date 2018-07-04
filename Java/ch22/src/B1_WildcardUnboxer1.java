//
// 와일드카드
// 와일드카드는 제네릭보다 간결하게 보인다
//

import javax.swing.Box;

class Box4<T> {
	private T ob;
	public void set(T o) { ob = o; }
	public T get() { return ob; }
	
	@Override
	public String toString() {
		return ob.toString();
	}
}

class Unboxer4 {
	public static <T>T openBox(Box4<T> box) {
		return box.get();
	}
	
	public static void peekBox(Box4<?> box) {
		System.out.println(box);
	}
}

public class B1_WildcardUnboxer1 {
	public static void main(String[] args) {
		Box4<String> box = new Box4<>();
		box.set("So Simple String");
		Unboxer4.peekBox(box);
	}
}