/*
 * ���� ��� ����� ��Ʈ�� ������ ��
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class A1_Read65FromFile {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("data.dat");
			// �Է� ��Ʈ�� ����
			
			int dat = in.read();	// ������ ����
			in.close();				// �Է� ��Ʈ�� ����
			
			System.out.println(dat);
			System.out.printf("%c", dat);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}