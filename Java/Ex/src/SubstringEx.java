public class SubstringEx {

	public static void main(String[] args) {
		
		//1. ������ 3���� �ڸ���
		String str1 = "ABCDEFG";
		String result1 = str1.substring(str1.length()-3, str1.length());
		System.out.println(result1);
		
		//2. Ư������ ����, ������ ���ڿ� ����
		String str2 = "AB/CD/EFGH";
		int num2 = str2.indexOf("/");
		String result2 = str2.substring(num2+1);
		System.out.println(result2);
		
		//3. Ư������ ����, ������ ���ڿ� ����
		String str3 = "AB/CD/EFGH";
		int num3 = str3.indexOf("/");
		String result3 = str2.substring(num3+1);
		System.out.println(result3);
	}

}
