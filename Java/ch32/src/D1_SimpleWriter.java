/*
 * ���� ��Ʈ�� ��ݿ��� ���ڸ� �����ϸ�???
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

class D1_SimpleWriter {

	public static void main(String[] args) {
		try (Writer out = new FileWriter("data.txt")) {	// ���� ��� ��Ʈ�� ����
			out.write('A');		// ���� 'A' ����
			out.write('��');		// ���� '��' ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}