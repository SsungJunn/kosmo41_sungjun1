//
// 다형성(폴리모피즘)의 이해
// 상속한 클래스의 오브젝트는 슈퍼 클래스로도 서브 클래스로도 다룰 수 있다.
// 하나의 오브젝트와 메서드가 많은 형태를 가지고 있는 것을 다형성이라고 한다.
// 서브 클래스의 오브젝트는 슈퍼 클래스의 오브젝트로 생성할 수 있다.
// 추상 클래스의 활용
//

abstract class Calc2
{
	int a;
	int b;
	
	abstract int result();
	
	void printResult()
	{
		System.out.println(result());
	}
	
	void setData(int m, int n)
	{
		a = m;
		b = n;
	}
}

class Plus2 extends Calc2
{
	int result() { return a + b; }
}

class Minus extends Calc2
{
	int result() { return a - b; }
}

class C4_Calculation2 {
	public static void main(String[] args) {
		int x = 54, y = 12;
		
		Calc2 calc1 = new Plus2();
		Calc2 calc2 = new Minus();
		
		calc1.setData(x, y);
		calc2.setData(x, y);
		
		System.out.print(x + " + " + y + " = ");
		calc1.printResult();
		
		System.out.print(x + " - " + y + " = ");
		calc2.printResult();
	}
}
