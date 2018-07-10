/*
 * BufferedWriter ����
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class D4_StringWriter {

	public static void main(String[] args) {
		String ks = "���ο� �־ ���� �� �ʿ��� ���� �ƴϴ�.";
		String ms = "Money is not necessary for studing";
		String es = "Life is long if you know how to use it.";
		String ps = "Laugh more smile often, Love much";
		
		try(BufferedWriter bw = 
				new BufferedWriter(new FileWriter("String.txt"))) {
			bw.write(ks, 0, ks.length());
			bw.newLine();	// �� �ٲ� ���ڸ� ����(�ü�� �� �� �ٲ��� ǥ�� ����� �ٸ�)
			bw.write(ms, 0, ms.length());
			bw.newLine();
			bw.write(es, 0, es.length());
			bw.newLine();
			bw.write(ps, 0, ps.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
