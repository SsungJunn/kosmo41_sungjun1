
/*
 * ����� ��Ʈ�� ���� �ڵ��� ����: finally ��� close
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Write65ToFile2 {
	public static void main(String[] atgs) throws IOException {
		// ��� ��Ʈ�� ����

		OutputStream out = null;
		try {
			out = new FileOutputStream("data.dat");
			out.write(66); // 65�� ����
		} catch (IOException e) {
		} finally {
			if (out != null) // ��� ��Ʈ�� ���� �����ߴٸ�,
				out.close(); // ��Ʈ�� ����
		}
	}
}
