//
// Key-Value 방식의 데이터 저장과 HashMap<K, V> 클래스
// Hash�� ���� ���� ������ ȿ�������� Value���� ã���ش�.
//

import java.util.HashMap;

public class E1_HashMapCollection {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		
		// Key-Value 기반 데이터 저장
		map.put(45, "Brown");
		map.put(37, "James");
		map.put(23, "Martin");
		
		
		// 데이터 탐색
		System.out.println("23��: " + map.get(23));
		System.out.println("37��: " + map.get(37));
		System.out.println("45��: " + map.get(45));
		
		// 데이터 삭제
		map.remove(37);
		
		// 데이터 삭제 확인
		System.out.println("37��: " + map.get(37));
	}
}