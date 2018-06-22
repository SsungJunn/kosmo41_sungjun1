public class PrefixOp {

	public static void main(String[] args) {
		int num = 7;
		
		System.out.println(++num); 	// num의 값 하나 증가 후 출력
		System.out.println(++num);	// num의 값 하나 증가 후 출력
		System.out.println(num);
		
		System.out.println("------------");
		
		int num2 = 7;
		System.out.println(num2++); 	// num의 값 하나 감소 후 출력
		System.out.println(num2++);	// num의 값 하나 감소 후 출력
		System.out.println(num2);
	}

}
