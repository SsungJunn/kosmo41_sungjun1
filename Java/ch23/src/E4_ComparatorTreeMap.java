//
// TreeMap<K, V>의 순차적 접근의 예
// Tree 자료구조의 특성상 반복자가 정렬된 순서대로 key들에 접근을 하고 있다.
// 이렇듯 반복자의 접근 순서는 컬레션 인스턴스에 따라 달라질 수 있다.
//

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class AgeComparator implements Comparator<Integer> {
	public int compare(Integer n1, Integer n2) {
		return n2.intValue() - n1.intValue();
	}
}
public class E4_ComparatorTreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>(new AgeComparator());
		map.put(45, "Brown");
		map.put(37, "James");
		map.put(23, "Martin");
		
		// Key만 담고 있는 컬렉션 인스턴스 생성
		Set<Integer> ks = map.keySet();
		
		// 전체 Key 출력 (for-each문 기반)
		for(Integer n : ks)
			System.out.print(n.toString() + '\t');
		System.out.println();
		
		// 전체 Value 출력 (for-each문 기반)
		for(Integer n : ks)
			System.out.print(map.get(n).toString() + '\t');
		System.out.println();
		
		// 전체 Value 출력 (반복자 기반)
		for(Iterator<Integer> itr = ks.iterator(); itr.hasNext();)
			System.out.print(map.get(itr.next()) + '\t');
		System.out.println();
	}
}