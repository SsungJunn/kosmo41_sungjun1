//
// 배열의 탐색: 인스턴스 대상의 Ex
//

import java.util.Arrays;

class Person2 implements Comparable {
	private String name;
	private int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Object o) {
		Person2 p = (Person2)o;
		return this.age - p.age;	// 나이가 같으면 0을 반환
	}
	
	@Override
	public String toString() {
		return name + ": " + age;
	}
}

public class D8_ArrayObjSearch {

	public static void main(String[] args) {
		Person2[] ar = new Person2[3];
		
		ar[0] = new Person2("Lee", 29);
		ar[1] = new Person2("Gee", 15);
		ar[2] = new Person2("Soo", 37);
		
		Arrays.sort(ar);	// 탐색에 앞서 정렬을 진행
		
		int idx = Arrays.binarySearch(ar,  new Person2("Who are you?", 37));
		System.out.println(ar[idx]);
	}
}

