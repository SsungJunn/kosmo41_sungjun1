//
// 제네릭 클래스의 타입 인자 제한하기
// 인스턴스 생성 시 타입 인자로 Number 또는 이를 상속하는 클래스만 올 수 있음.
//

class Box8<T extends Number> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

public class B3_BoundedBox {

	public static void main(String[] args) {
		Box8<Integer> iBox = new Box8<>();
		iBox.set(24);
		
		Box8<Double> dBox = new Box8<>();
		dBox.set(5.98);

		System.out.println(iBox.get());
		System.out.println(dBox.get());
	}
}