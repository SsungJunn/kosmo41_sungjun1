/*
 * 람다식과 제네릭
 * 함수형 인터페이스 : 추상 메서드가 딱 하나만 존재하는 인터페이스!
 */

@FunctionalInterface
interface Calculate <T> {	// 제네릭 기반의 함수형 인터페이스
	T cal(T a, T b);
}

class A7_LambdaGeneric {

	public static void main(String[] args) {
		Calculate<Integer> ci = (a, b) -> a + b;
		System.out.println(ci.cal(4, 3));
		
		Calculate<Double> cd = (a, b) -> a + b;
		System.out.println(cd.cal(4.32, 3.45));
	}
}
// 인터페이스가 제네릭 기반이라 하여 특별히 신경 쓸 부분은 없다.
// 타입 인자가 전달이 되면(결정이 되면) 추상 메소드의  T는 결정이 되므로!!