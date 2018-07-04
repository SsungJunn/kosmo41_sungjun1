//
// 배열에 저장된 인스턴스들의 정렬의 Ex
//

import java.util.Arrays;

class Person1 implements Comparable {
	private String name;
	private int age;
	
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 알파벳 순으로 정렬함
	@Override
	public int compareTo(Object o) {
		Person1 p = (Person1)o;
		
		int nNum = this.name.compareTo(p.name);
		return nNum;		
	}

// 나이가 낮은 순으로 정렬함
//	@Override
//	public int compareTo(Object o) {
//		Person1 p = (Person1)o;
//		
//		if(this.age > p.age)
//			return 1;
//		else if(this.age < p.age)
//			return -1;
//		else
//			return 0;
//	}
	
	
	@Override
	public String toString() {
		return name + ": " + age;
	}
}

public class D6_ArrayObjSort {

	public static void main(String[] args) {
		Person1[] ar = new Person1[3];
		
		ar[0] = new Person1("Goo", 29);
		ar[1] = new Person1("Soo", 15);
		ar[2] = new Person1("Lee", 37);
		
		Arrays.sort(ar);
		
		for(Person1 p : ar)
			System.out.println(p);
	}
}