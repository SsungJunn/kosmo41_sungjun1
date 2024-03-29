//
// 기본 자료형 데이터의 저장과 참조
// 오토 박싱과 오토 언박싱 덕분에 컬렉션 인스턴스에
// 기본 자료형의 값도 저장 가능하다.
//

import java.util.Iterator;
import java.util.LinkedList;

class A7_PrimitiveCollection {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		// 저장 과정에서 오토 박싱
		list.add(10);
		list.add(20);
		list.add(30);
		
		int n;
		for(Iterator<Integer> itr = list.iterator(); itr.hasNext(); ) {
			n = itr.next();	// 오토 언박싱
			System.out.print(n + "\t");
		}
		System.out.println();
	}
}