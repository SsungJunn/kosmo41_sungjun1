/*
 * FileReader ����
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

class D2_TextReader {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ����: ");
		String src = sc.nextLine();

		try (Reader in = new FileReader(src)) {	// ���� �Է� ��Ʈ�� ����
			int ch;

			while (true) {
				ch = in.read();		// ���ڸ� �ϳ��� �д´�.
				if (ch == -1)		// �� �̻� ���� ���ڰ� ���ٸ�,
					break;
				System.out.print((char)ch);	// ���ڸ� �ϳ��� ����Ѵ�.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}