//
// 오버라이딩 ---> 상속된 메서드와 동일한 이름, 동일한 인수를 가지는 메서드를 정의하여
//			   	메서드를 덮어쓰는 것. 반환값의 형도 같아야만 한다.

class Animal
{
	String name;
	int age;
	
	void printPet()
	{
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}

class Cat extends Animal
{
	String variety;
	
	void printPet()
	{
		// 서브 클래스 안에서 super라는 말을 사용하면 슈퍼 클래스의 필드와 메서드 참조가능
		super.printPet();
		System.out.println("종류 : " + variety);;
	}
}

class B1_Pet {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.name = "양순이";
		cat.age = 5;
		cat.variety = "페르시안";
		cat.printPet();
	}
}