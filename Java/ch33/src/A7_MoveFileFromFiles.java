/*
 * ���� �� ���丮�� ����� �̵��� ��
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class A7_MoveFileFromFiles {

	public static void main(String[] args) throws IOException {
		Path src = Paths.get("D:\\sky794373\\study\\Empty2");
		Path dst = Paths.get("D:\\sky794373\\study\\Empty3");
		
		// src�� �����ϴ� ���丮�� dst�� �����ϴ� ���丮�� ����
		Files.move(src, dst, StandardCopyOption.REPLACE_EXISTING);
	}

}
