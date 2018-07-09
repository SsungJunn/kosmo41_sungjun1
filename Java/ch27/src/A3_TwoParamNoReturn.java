//
// 매개변수가 둘 인 람다식 
//

interface Calculate3 {
	void cal(int a, int b);	// 매개변수 둘, 반환형 void
}

class A3_TwoParamNoReturn {

	public static void main(String[] args) {
		Calculate3 c;
		c = (a, b) -> System.out.println(a + b);
		c.cal(4, 3);	// 이번엔 덧셈이 진행
		
		c = (a, b) -> System.out.println(a - b);
		c.cal(4, 3);	// 이번엔 뺄셈이 진행
		
		c = (a, b) -> System.out.println(a * b);
		c.cal(4, 3);	// 이번엔 곱셈이 진행
	}
}