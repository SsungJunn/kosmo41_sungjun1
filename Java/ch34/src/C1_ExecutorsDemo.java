/*
 * ������ �� ����� ����1
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class C1_ExecutorsDemo {

	public static void main(String[] args) {
		Runnable task = () -> {	// �����忡�� ��ų �۾�
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (n1 + n2));
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor();
		exr.submit(task);	// ������ Ǯ�� �۾��� ����
		
		System.out.println("End " + Thread.currentThread().getName());
		exr.shutdown();	// ������ Ǯ�� �� �ȿ� �ִ� �������� �Ҹ�
	}

}