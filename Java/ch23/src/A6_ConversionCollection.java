//
// 배열 기반 리스트를 연결 기반 리스트로...
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A6_ConversionCollection {

	public static void main(String[] args) {
		// 인자로 전달된 인스턴스들을 저장한 컬렉션 인스턴스의 생성 및 반환
		// 이렇게 생선된 리스트 인스턴스는 Immutable 인스턴스이다.
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
		list = new ArrayList<>(list);		
		
		// ArrayList<E> 인스턴스의 순환
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();
		
		// ArrayList<E>를 LinkedList<E>로 변환
		list = new LinkedList<>(list);
		
		// LinkedList<E> 인스턴스의 순환
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();
	}
}