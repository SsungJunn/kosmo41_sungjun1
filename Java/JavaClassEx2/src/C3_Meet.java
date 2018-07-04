//
// 인터페이스의 상속
// 인터페이스는 클래스처럼 상속할 수 있다.
//

interface Greet2
{
	void greet();
}

interface Bye extends Greet2
{
	void bye();
}

class Greeting implements Bye
{
	public void greet()
	{
		System.out.println("안녕하세요.");
	}
	
	public void bye()
	{
		System.out.println("안녕히 계세요.");
	}
}

class C3_Meet {

	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		greeting.greet();
		greeting.bye();
	}
}