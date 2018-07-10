/*
 * ���� ���� �ӵ��� ���� ���� ���α׷�
 * 1K ����Ʈ ���� ��� ���� ���� ���α׷�
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class B2_BufferedFileCoper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��� ����: ");
		String src = sc.nextLine();
		System.out.println("�纻 �̸�: ");
		String dst = sc.nextLine();

		try (InputStream in = new FileInputStream(src); 
			 OutputStream out = new FileOutputStream(dst)) {
			
			Instant start = Instant.now();
			
			byte buf[] = new byte[1024];
			int len;

			while (true) {
				len = in.read(buf);	// �迭 buf�� �����͸� �Ͼ� ���̰�, (�� �̻� �о� ���� ������ ������ -1 ��ȯ)
				if (len == -1)
					break;
				out.write(buf, 0, len);	// len ����Ʈ��ŭ �����͸� �����Ѵ�.
			}
			
			Instant end = Instant.now();
			System.out.println("�ɸ� �ð�: " + 
			Duration.between(start, end).toMillis());
			
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
// public int read(byte[] b) throws IOException
// -> ���Ͽ� ���޵� �迭�� �����͸� b�� ���޵� �迭�� ����
// public void write(byte[] b, int off, int len) throws IOException
// -> b�� ���޵� �迭�� �����͸� �ε��� off�������� len ����Ʈ��ŭ ���Ͽ� ����