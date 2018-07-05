//
// ������ Ex
//

import java.util.ArrayDeque;
import java.util.Deque;

public class D2_ArrayDequeCollection {

	public static void main(String[] args) {
		// �Ѵ� ��밡��
		// Deque<String> deq = new LinkedList<>();
		Deque<String> deq = new ArrayDeque<>();
		
		// ������ �ְ�
		deq.offerFirst("1.Box");
		deq.offerFirst("2.Toy");
		deq.offerFirst("3.Robot");
		
		// ������ ������
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println();
		
		// �ڷ� �ְ�
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		// �ڷ� ������
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println();
		
		// �ڷ� �ְ�
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		// ������ ������
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
	}

}

