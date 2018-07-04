//
// Number 클래스의 추상 메소드 호출의 Ex
// 당연한 결과에 당황하지마
//

public class A5_NumberMethod {

	public static void main(String[] args) {
		Integer num1 = new Integer(29);
		System.out.println(num1.intValue());	// int형 값으로 반환
		System.out.println(num1.doubleValue()); // double형 값으로 반환
		
		Double num2 = new Double(3.14);
		System.out.println(num2.intValue());	// int형 값으로 반환
		System.out.println(num2.doubleValue()); // double형 값으로 반환
	}
}