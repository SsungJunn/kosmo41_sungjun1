/*
 * ���� ��� ����� ��Ʈ�� ������ ��
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Write65ToFile {
	public static void main(String[] atgs) throws IOException {
		//	��� ��Ʈ�� ����
		
		OutputStream out = new FileOutputStream("data.dat");
		out.write(65);	// 65�� ����
		out.close();	// ��Ʈ�� ����
	}
}


