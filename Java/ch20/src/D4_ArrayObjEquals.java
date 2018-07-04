//
// 인스턴스 저장 배열의 비교 Ex 및
// Object 클래스의 equals 메소드 오버라이딩 결과
//

import java.util.Arrays;

class INum {
	private int num;
	public INum(int num) {
		this.num = num;
	}

// 두 배열안의 값을 알고 싶으면 오버라이딩을 해야만 한다. 배열안의 값이 같으므로 true가 나온다.
// 오버라이딩을 하지않을 경우 두 배열을 비교하기 때문에 false가 나온다.
//	@Override
//	public boolean equals(Object obj) {		
//	if(this.num == ((INum)obj).num)
//		return true;
//	else
//		return false;
//	}
}

class D4_ArrayObjEquals {

	public static void main(String[] args) {
		INum[] ar1 = new INum[3];
		INum[] ar2 = new INum[3];
		ar1[0] = new INum(1); ar2[0] = new INum(1);
		ar1[1] = new INum(2); ar2[1] = new INum(2);
		ar1[2] = new INum(3); ar2[2] = new INum(3);
		System.out.println(Arrays.equals(ar1, ar2));
	}

}

