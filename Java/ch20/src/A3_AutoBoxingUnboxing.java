//
// 오토 박싱과 오토 언박싱
//

class A3_AutoBoxingUnboxing {

	public static void main(String[] args) {
		Integer iObj = 10; // 박싱
		Double dObj = 3.14; // 박싱
		
		System.out.println(iObj);
		System.out.println(dObj);
		System.out.println();
		
		// 메소드 호출을 통한 언박싱
		int num1 = iObj;	// 언박싱
		double num2 = dObj;	// 언박싱
		
		System.out.println(num1);
		System.out.println(num2);
	}
}