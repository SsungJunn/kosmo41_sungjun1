//
// 찾기:Comparator<T> 기반의 Ex
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StrComp implements Comparator<String> {
	
	@Override
	public int compare(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);	// 대소문자 구분 없이 비교
	}
}
class A2_StringComparator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("Robot");
		list.add("Apple");
		list.add("Box");
		
		StrComp cmp = new StrComp();	// 정렬과 탐색의 기준
		Collections.sort(list, cmp);	// 정렬
		int idx = Collections.binarySearch(list, "Robot", cmp); // 탐색
		System.out.println(list.get(idx));	// 탐색의 결과 출력
	}

}
