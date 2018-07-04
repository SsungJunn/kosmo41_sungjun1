/* 이미 다른 자바 파일에 Calc클래스를 만들어 놓아서 별도로 다시 써주지 않아도 사용가능
 *  여기서 쓰고 싶으면 클래스 이름을 바꿔서 사용하면 된다. 
 메서드 호출2 - main() 메서드와 같은 오브젝트 내의 메서드에는 static을 붙인다.*/

class Calc2
{
	int add(int a, int b)
	{
		return a + b;
	}
}

class Calculation 
{
	static void disp()
	{
		int nRtn;
		Calc calc = new Calc(); // 참조변수
		nRtn = calc.add( 3,  9 );
		
		System.out.println("3 + 9 = " + nRtn);
	}
	public static void main(String[] args) 
	{
		disp();
	}
}