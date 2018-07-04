//
// 박싱과 언박싱 Ex
//

public class A2_BoxingUnboxing {

	public static void main(String[] args) {
		// 인스턴스에 값을 감싸는 박싱
		Integer iObj = new Integer(10); // 박싱
		Double dObj = new Double(3.14); // 박싱
		
		System.out.println(iObj);
		System.out.println(dObj);
		System.out.println();
		
		// 메소드 호출을 통한 언박싱
		int num1 = iObj.intValue();			// 언박싱
		double num2 = dObj.doubleValue();	// 언박싱
		
		System.out.println(iObj);
		System.out.println(dObj);
		System.out.println();
		
		// 래퍼 인스턴스 값의 증가 방법
		iObj = new Integer(iObj.intValue() + 10);
		dObj = new Double(dObj.doubleValue() + 1.2);
		
		System.out.println(iObj);
		System.out.println(dObj);
	}
}