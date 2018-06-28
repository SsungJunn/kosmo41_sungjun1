//
//	선언된 클래스의 모든 인스턴스가 공유하는 클래스 변수
// 	static으로 선언하지 않은 변수는 매번 초기화되지만
//	static으로 선언한 변수는 개별 인스턴스의 내부 변수가 아니라 
//	모든 인스턴스가 공휴하는 클래스 변수가 된다.
//

class InstCnt {
	//int instNum = 0;
	static int instNum = 0;
	
	InstCnt() {
		instNum++;
		System.out.println("인스턴스 생성: " + instNum);
	}
}

class A1_ClassVar {
	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
	}

}
