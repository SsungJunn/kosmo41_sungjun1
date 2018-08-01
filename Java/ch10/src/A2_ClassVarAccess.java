//
// 클래스 변수 접근의 예
//


class AccessWay {
	static int num = 0;
	
	AccessWay() {incrCnt();}
	void incrCnt() {
		// 클래스 내부에서 이름을 통한 접근
		System.out.println(num);
		num++;
		
	}
}

class A2_ClassVarAccess {

	public static void main(String[] args) {

		// 외부에서 인스턴스의 이름을 통한 접근
		AccessWay way = new AccessWay();
		System.out.println(way.num);
		way.num++;
		System.out.println("num = " + way.num);
		
		// 외부에서 클래스의 이름을 통한 접근
		AccessWay.num++;
		System.out.println("num = " + AccessWay.num);
	}

}