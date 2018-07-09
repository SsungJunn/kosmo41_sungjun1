//
// 매개변수가 있고 반환하는 람다식1
//

interface Calculate4 {
	int cal(int a, int b);	// 값을 반환하는 추상 메소드
}
class A4_TwoParamAndReturn {

	public static void main(String[] args) {
		Calculate4 c;
		c = (a, b) -> { return a + b; };	// return문의 중괄호는 생략 불가!
		//int num = c.cal(4, 3);	// 이와 같이 연산 결과가 남는다.
		System.out.println(c.cal(4, 3));
		
		c = (a, b) -> a + b;;	// 연산 결과가 남으면, 별도로 명시하지 않아도 반환 대상이 됨!
		System.out.println(c.cal(4, 3));
	}
}
// 메서드 몸체에 해당하는 내용이 return 문이면
// 그 문장이 하나이더라도 중괄호의 생략이 불가능하다.