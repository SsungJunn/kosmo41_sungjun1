/*
 * 간단한 입력 및 출력의 예(바이트 단위)
 * 파일 open, close 과정 없음
 * 데이터 읽을 때 배열도 준비해 둘 필요가 없음
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class A4_SimpleBinWriteRead {

	public static void main(String[] args) throws IOException {
		Path fp = Paths.get("D:\\sky794373\\study\\simple.bin");
		
		// 파일 생성, 파일이 존재하면 예외 발생
		fp = Files.createFile(fp);
		
		byte buf1[] = {0x13, 0x14, 0x15};	// 파일에 쓸 데이터
		for(byte b : buf1)	// 저장할 데이터의 출력을 위한 반복문
			System.out.print(b + "\t");
		System.out.println();
		
		//파일에 데이터 쓰기
		Files.write(fp, buf1, StandardOpenOption.APPEND);
		
		// 파일로부터 데이터 읽기
		byte buf2[] = Files.readAllBytes(fp);
		
		for(byte b : buf2)	// 앍어 들인 데이터의 출력을 위한 반복문
			System.out.print(b + "\t");
		System.out.println();
	}

}
