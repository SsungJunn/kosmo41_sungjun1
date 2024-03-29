//
// finalize 메소드의 오버라이딩 Ex
//

class Person
{
	String name;
	public Person(String name)
	{
		this.name = name;
	}
	@Override
	protected void finalize() throws Throwable 
	{
		super.finalize();	// 상위 클래스의 finalize 메소드 호출
		System.out.println("destroyed: " + name);
	}
}

public class A1_ObjextFinalize {

	public static void main(String[] args) {
		Person p1 = new Person("Yoon");
		Person p2 = new Person("Park");
		p1 = null;	// 참조대상을 가비지 컬렉션의 대상으로 만듦
		p2 = null;	// 참조대상을 가비지 컬렉션의 대상으로 만듦
		
		//System.gc();
		//System.runFinalization();
		
		// System.gc();, System.runFanalization(); 을 쓰지 않으면 main이 
		// 죽을 때 p1, p2도 같이 죽어서 오버라이딩 되지않고 end of program이 출력됨
		
		System.out.println("end of program");
	}

}