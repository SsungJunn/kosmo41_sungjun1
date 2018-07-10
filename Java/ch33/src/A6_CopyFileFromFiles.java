/*
 * 파일 및 디렉토리의 복사와 이동의 예
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
		
		// src가 지시하는 파일을 dst가 지시하는 위치와 이름으로 복사
		Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
	}

}
