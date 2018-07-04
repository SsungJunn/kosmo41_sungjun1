import java.util.*;

class E2_StringTokenizer {
	public static void main(String[] args)
	{
		StringTokenizer v = new StringTokenizer("a b c"); 
		//("a:b:c", ",") 로도 쓸수 있다. 구분자만 잘 정해주면 된다.
		
		StringTokenizer n = new StringTokenizer("1 2 3");
		
		String s = v.nextToken();
		int sum = Integer.parseInt(n.nextToken());
		
		while (v.hasMoreTokens())
		{
			String str = v.nextToken();
			System.out.println(str);
			s = s+ " + " + (str);
			sum = sum + Integer.parseInt(n.nextToken());
		}
		
		System.out.println(s + " = " + sum);
		
	}

}
