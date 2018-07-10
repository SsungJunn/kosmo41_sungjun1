
/*
 * ����Ʈ ���� ���� �� ��� ��Ʈ��
 * ����Ʈ ���� ���� ���� ���α׷�
 * �������� �� ������ ����� ���� �����Ѵ�.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class B1_BytesFileCopier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��� ����: ");
		String src = sc.nextLine();
		System.out.println("�纻 �̸�: ");
		String dst = sc.nextLine();

		try (InputStream in = new FileInputStream(src); 
			 OutputStream out = new FileOutputStream(dst)) {
			
			Instant start = Instant.now();
			
			int data;
			while (true) {
				data = in.read(); // ���Ϸκ��� 1 ����Ʈ�� �д´�.
				if (data == -1) // �� �̻� �о� ���� �����Ͱ� ���ٸ�,
					break;
				out.write(data); // ���Ͽ� 1����Ʈ�� ����.
			}
			
			Instant end = Instant.now();
			System.out.println("�ɸ� �ð�: " + 
			Duration.between(start, end).toMillis());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
