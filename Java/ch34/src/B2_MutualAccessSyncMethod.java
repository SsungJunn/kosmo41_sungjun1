class Counter2 {
	int count = 0; // �����Ǵ� ����

	synchronized public void increment() {
		count++; // ù ��° �����忡 ���� ����
	}

	synchronized public void decrement() {
		count--; // �� �ٸ� �����忡 ���� ����
	}

	public int getCount() {
		return count;
	}
}

public class B2_MutualAccessSyncMethod {
	public static Counter2 cnt = new Counter2();

	public static void main(String[] args) throws InterruptedException {
		Runnable task1 = () -> {
			for (int i = 0; i < 1000; i++)
				cnt.increment(); // ���� 1 ����
		};

		Runnable task2 = () -> {
			for (int i = 0; i < 1000; i++)
				cnt.decrement(); // ���� 1 ����
		};

		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);

		t1.start();
		t2.start();

		t1.join(); // t1�� �����ϴ� �������� ���Ḧ ��ٸ�
		t2.join(); // t2�� �����ϴ� �������� ���Ḧ ��ٸ�

		// �����尡 ����Ǹ� ����� ������. �� join�� ����
		System.out.println(cnt.getCount());
	}
}