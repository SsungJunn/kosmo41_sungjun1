//
// 기본 자료형의 값을 감싸는 래퍼 클래스
//

class A1_UseWrapperClass {
	public static void showData(Object obj) {	// 오버로드를 하지않기 위해
												// Object로 데이터 받음
		System.out.println(obj);
	}

	public static void main(String[] args) {
		
		// 정수 3으로 채워진 래퍼 인스턴스 셍성, 래퍼 클래스를 통해서 int형으로 변환 후 전송
		Integer iInst = new Integer(3);
		showData(iInst);
		
		// 실수 7.15로 채워진 래퍼 인스턴스 생성, 래퍼 클래스를 통해서 double형으로 변환 후 전송
		showData(new Double(7.15));
	}
}
// 이렇듯 기본 자료형의 값을 인스턴스로 감싸는 목적의 클래스를 카리켜 래퍼 클래스라 한다.