/*abstract class Human {
	abstract void print();
}

class Man extends Human {
	String str;
	
	Man(String str) {
		this.str = str;
	}
	
	public void print() {
		System.out.println(str + " 생성1");
		System.out.println(str + " 생성2");
	}
}

class Woman extends Human {
	String str;
	
	Woman(String str) {
		this.str = str;
	}
	
	public void print() {
		System.out.println(str + " 생성1");
		System.out.println(str + " 생성2");
		System.out.println(str + " 생성3");
	}
}
class HumanFactory {
	public static Human create(String str) {
		if (str == "남자") {
			return new Man(str);
		} else if (str == "여자") {
			return new Woman(str);
		}
		return null;
	}
}

public class C5_SimpleFactoryPattern {
	public static void main(String[] args) {
		Human h1 = HumanFactory.create("남자");
		h1.print();
		
		Human h2 = HumanFactory.create("여자");
		h2.print();
	}
}
// Man이나 Woman이나 Human의 자식 객체이므로 부모 객체에 대할 수있다.
// 대입하고 리턴
*/

abstract class Human
{
	abstract void print();
}

class Man extends Human
{
	String str;
	
	Man(String str){
		this.str = str;
	}
	
	public void print() {
			System.out.println("생성1");
			System.out.println("생성2");
			System.out.println("생성3");
	}
}

class Woman extends Human
{
	String str;
	
	Woman(String str){
		this.str = str;
	}
	
	public void print() {
			System.out.println("생성1");
			System.out.println("생성2");
			System.out.println("생성3");
	}
}

class HumanFactory {
	public static Human create(String str) {
		if(str == "남자") {
			return new Man(str);
		} else if (str == "여자") {
			return new Woman(str);		
		}return null;
	}
}

public class C5_SimpleFactoryPattern {
	 public static void main(String[] args) {
		 Human h1 = HumanFactory.create("남자");
		 h1.print();
		 
		 Human h2 = HumanFactory.create("여자");
		 h2.print();
	 }
}






