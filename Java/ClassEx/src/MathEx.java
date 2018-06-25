//메서드 호출 - 다른 오브젝트의 메서드를 호출하기 위해서는 '.'를 사용하여 다음과 같이 기술한다.

class Calc
{
	int add(int a, int b)
	{
		return a + b;
	}
}

class MathEx 
{
	public static void main(String[] args) 
	{
		Calc calc = new Calc();
		int nRtn = calc.add( 3, 9 );
		
		System.out.println("3 + 9 = " + nRtn);
	}
}