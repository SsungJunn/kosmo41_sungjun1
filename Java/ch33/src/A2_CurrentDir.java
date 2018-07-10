/*
 * ���� ���丮 ������ ��� ��
 */

import java.nio.file.Path;
import java.nio.file.Paths;

class A2_CurrentDir {

	public static void main(String[] args) {
		Path cur = Paths.get("");	// ���� ���丮 ���� '��� ���' ���·� ��� �ν��Ͻ� ����
		String cdir;
		
		if(cur.isAbsolute()) {
			cdir = cur.toString();
		} else {
//			System.out.println(1111);
			cdir = cur.toAbsolutePath().toString();
		}
		System.out.println("Current dir: " + cdir);
	}

}
