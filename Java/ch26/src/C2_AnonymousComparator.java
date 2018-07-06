//
// 익명 클래스 사용의 Ex
// 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class C2_AnonymousComparator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ROBOT");
		list.add("APPLE");
		list.add("BOX");
	
		// 인터페이스임... 안에 구체적으로 기능을 넣어줌으로써 사용가능!
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};

		Collections.sort(list, cmp);
		System.out.println(list);
	}
}
