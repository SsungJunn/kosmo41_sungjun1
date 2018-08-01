//
// Comparator<T> 인터페이스 기반 TreeSet<E>의 예
// String 클래스의 정렬 기준은 사전 편찬순이다.
// 이를 길이 순으로 바꾸는 문장
//

import java.util.Comparator;
import java.util.TreeSet;

class StringComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}

class C4_ComparatorString {

	public static void main(String[] args) {
		TreeSet<String> tree = new TreeSet<>(new StringComparator());
		//TreeSet<String> tree = new TreeSet<>();
		tree.add("Box");
		tree.add("Rabbit");
		tree.add("Robot1");
		tree.add("Robot");
		
		for(String s : tree)
			System.out.print(s.toString() + '\t');
		
		System.out.println();
	}

}
