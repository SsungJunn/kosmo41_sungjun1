
/*
 * ���� ��� ����� ��Ʈ�� ������ ��
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class A4_Read65FromFile2 {

	public static void main(String[] args) throws IOException {
		InputStream in = null;
		try {
			in = new FileInputStream("data.dat");
			int dat = in.read(); // ������ ����
			System.out.println(dat);
			System.out.printf("%c", dat);
		} catch (IOException e) {
		}

		finally {
			if (in != null) // �Է� ��Ʈ�� ���� �����ߴٸ�,
				in.close(); // �Է� ��Ʈ�� ����
		}
	}
}