public class myFunc {

	public static void main(String[] args) {
		boolean ste = true;
		int num1 = 11;
		
		if(ste) {
			//int num1 = 22;	// 주석 해제하면 컴파일 오류 발생 -> 메인에서 처음에 변수 선언을 했기 때문에 다시 못써
			num1++;
			System.out.println(num1);
		}
		
		{
			int num2 = 33;
			num2++;
			System.out.println(num2);
		}
		//System.out.println(num2);	// 주석 해제하면 컴파일 오류 발생 -> 
	}

}
