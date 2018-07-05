//
// 큐의 구현
//

import java.util.LinkedList;
import java.util.Queue;

public class D1_LinkedListQueue {

	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();	// LinkedList<E> 인스턴스 생성!
		que.offer("Box");
		que.offer("Toy");
		que.offer("Robot");
		
		// 무엇이 다음에 나올지 확인
		System.out.println("next: " + que.peek());
		
		// 첫 번째, 두 번째 인스턴스 꺼내기
		System.out.println(que.poll());
		System.out.println(que.poll());
		
		// 무엇이 다음에 나올지 확인
		System.out.println("next: " + que.peek());
		
		// 마지막 인스턴스 거내기
		System.out.println(que.poll());
		System.out.println(que.poll()); // 꺼낼 대상이 없으면 null로 반환
		
		System.out.println("next: " + que.peek()); // 확인 할 대상이 없으면 null로 반환
	}
}
// LinkdList<E>는 List<E>와 동시에 Queue<E>를 구현하는 컬렉션 클래스이다.
// 따라서 어떠한 타입의 참조변수로 참조하느냐에 따라 '리스트'로도 '큐'로도 동작한다.