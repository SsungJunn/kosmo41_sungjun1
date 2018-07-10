/*
 * Path�� Path Ŭ����
 * Java.no.file.Path - ���� �� ���丮�� ��� ǥ���� ���� �ڹ� 7���� �߰��� �������̽�
 * Get �޼ҵ� ȣ���� ���� ���δ� �ش� ���� �Ǵ� ���丮�� ���� ���ο� ��� ����.
 */

import java.nio.file.Path;
import java.nio.file.Paths;

class A1_PathDemo {

	public static void main(String[] args) {
		Path pt1 = Paths.get("C:\\JavaStudy\\PathDemo.java");
		Path pt2 = pt1.getRoot();
		Path pt3 = pt1.getParent();
		Path pt4 = pt1.getFileName();
		
		System.out.println("Absolute: " + pt1);
		System.out.println("Root: " + pt2);
		System.out.println("Parent: " + pt3);
		System.out.println("File: " + pt4);
	}

}
