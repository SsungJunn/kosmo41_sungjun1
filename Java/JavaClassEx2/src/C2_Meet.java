//
// 인터페이스의 이용
// 상속 관계가 아닌 클래스에 기능을 제공하는 구조
// 클래스와 비슷한 구조이지만, 정의와 추상 메서드만이 멤버가 될 수 있다.
//

// 무언가를 만들기 위한 설계도라 보면됨
// 클래스의 규격화
interface Greet
{
	void greet();
}

interface Talk
{
	void talk();
}

// 인터페이스를 사용하기 위해서는 implements를 써줘야된다.
// implements를 사용해서 인터페이스 Greet, Talk를 Morning 클래스에서 사용하겠다
class Morning implements Greet, Talk
{
	public void greet()
	{
		System.out.println("안녕하세요.");
	}
	
	public void talk()
	{
		System.out.println("날씨 좋네요.");
	}
}

class C2_Meet {

	public static void main(String[] args) {
		Morning morning = new Morning();
		morning.greet();
		morning.talk();
	}
}