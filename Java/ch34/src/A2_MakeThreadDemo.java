/*
 * �����带 �����ϴ� ���
 */
public class A2_MakeThreadDemo {

	public static void main(String[] args) {
		Runnable task = () -> {		// �����尡 �����ϰ� �� ����
			try {
				Thread.sleep(3000);
				} catch (Exception e) {
				}
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (n1 + n2));
		};

		Thread t = new Thread(task);
		t.start();	// ������ ���� �� ����
		System.out.println("End " + Thread.currentThread().getName());
	}
}
// Runnable void run()
// 1�ܰ� Runnable�� ������ �ν��Ͻ� ����
// 2�ܰ� Thread �ν��Ͻ� ����
// 3�ܰ� start �޼ҵ� ȣ�⤤