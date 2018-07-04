
//
// 추상 클래스
//

// abstract class ---> 추상클래스
abstract class Calc
{
	int a;
	int b;
	
	abstract void answer();
	
	void setData(int m, int n)
	{
		a = m;
		b = n;
	}
}

class Plus extends Calc
{
	// answer는 있는데 구체적인 방법이 없으니깐
	// 너가 만들기 나름이니라~
	void answer()
	{
		System.out.println( a + " + " + b + " = " + (a+b) );
	}
}

class C1_Calculation {

	public static void main(String[] args) {
		Plus plus = new Plus();
		plus.setData(27, 32);
		plus.answer();
	}
}