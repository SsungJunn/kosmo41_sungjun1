public class PrefixOp {

	public static void main(String[] args) {
		int num = 7;
		
		System.out.println(++num); 	// num�� �� �ϳ� ���� �� ���
		System.out.println(++num);	// num�� �� �ϳ� ���� �� ���
		System.out.println(num);
		
		System.out.println("------------");
		
		int num2 = 7;
		System.out.println(num2++); 	// num�� �� �ϳ� ���� �� ���
		System.out.println(num2++);	// num�� �� �ϳ� ���� �� ���
		System.out.println(num2);
	}

}
