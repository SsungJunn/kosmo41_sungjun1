//
// ť�� ����
//

import java.util.LinkedList;
import java.util.Queue;

public class D1_LinkedListQueue {

	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();	// LinkedList<E> �ν��Ͻ� ����!
		que.offer("Box");
		que.offer("Toy");
		que.offer("Robot");
		
		// ������ ������ ������ Ȯ��
		System.out.println("next: " + que.peek());
		
		// ù ��°, �� ��° �ν��Ͻ� ������
		System.out.println(que.poll());
		System.out.println(que.poll());
		
		// ������ ������ ������ Ȯ��
		System.out.println("next: " + que.peek());
		
		// ������ �ν��Ͻ� �ų���
		System.out.println(que.poll());
		System.out.println(que.poll()); // ���� ����� ������ null�� ��ȯ
		
		System.out.println("next: " + que.peek()); // Ȯ�� �� ����� ������ null�� ��ȯ
	}
}
// LinkdList<E>�� List<E>�� ���ÿ� Queue<E>�� �����ϴ� �÷��� Ŭ�����̴�.
// ���� ��� Ÿ���� ���������� �����ϴ��Ŀ� ���� '����Ʈ'�ε� 'ť'�ε� �����Ѵ�.