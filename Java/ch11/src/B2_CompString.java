//
// 문자열의 내용 비교
//

public class B2_CompString {
	public static void main(String[] args) {
		String st1 = "Apple"; //Apple, Apple
		String st2 = "apple"; //apple, Banana
		int cmp;
		
		// 인스턴스의 내용 비교
		if(st1.equals(st2))
			System.out.println("두 문자열은 같습니다.");
		else
			System.out.println("두 문자열은 다릅니다.");
		
		cmp = st1.compareTo(st2);
		
		// 사전적 의미에서 앞에 위치하는 문자가 있는 문자열을 출력
		if(cmp ==0)
			System.out.println("두 문자열은 일치합니다.");
		else if (cmp < 0)
			System.out.println("사전의 앞에 위치하는 문자: " + st1);
		else
			System.out.println("사전의 앞에 위치하는 문자: " + st2);
		
		// 대소문자 확인
		if(st1.compareToIgnoreCase(st2) == 0)
			System.out.println("두 문자열은 같습니다.");
		else
			System.out.println("두 문자열은 다릅니다.");
	}

}