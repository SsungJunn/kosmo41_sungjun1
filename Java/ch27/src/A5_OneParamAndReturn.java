//
// 매개변수가 있고 반환하는 람다식2
//

interface HowLong {
	int len(String s);	// 값을 반환하는 메소드
}

class A5_OneParamAndReturn {

	public static void main(String[] args) {
		HowLong h1 = s -> s.length();
		//int num = h1.len("I am so happy");	// 이와 같이 연산 결과가 남음
		System.out.println(h1.len("I am so happy"));
	}
}