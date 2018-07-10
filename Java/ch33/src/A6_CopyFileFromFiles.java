/*
 * ���� �� ���丮�� ����� �̵��� ��
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class A6_CopyFileFromFiles {

	public static void main(String[] args) throws IOException {
		Path src = Paths.get("D:\\sky794373\\study\\1.java");
		Path dst = Paths.get("D:\\sky794373\\study\\2.java");
		
		// src�� �����ϴ� ������ dst�� �����ϴ� ��ġ�� �̸����� ����
		Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
	}

}
