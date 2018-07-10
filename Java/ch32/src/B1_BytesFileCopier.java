
/*
 * 바이트 단위 입출 및 출력 스트림
 * 바이트 단위 파일 복사 프로그램
 * 예제실행 시 파일을 만들어 놓고 시작한다.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class B1_BytesFileCopier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대상 파일: ");
		String src = sc.nextLine();
		System.out.println("사본 이름: ");
		String dst = sc.nextLine();

		try (InputStream in = new FileInputStream(src); 
			 OutputStream out = new FileOutputStream(dst)) {
			
			Instant start = Instant.now();
			
			int data;
			while (true) {
				data = in.read(); // 파일로부터 1 바이트를 읽는다.
				if (data == -1) // 더 이상 읽어 들일 데이터가 없다면,
					break;
				out.write(data); // 파일에 1바이트를 쓴다.
			}
			
			Instant end = Instant.now();
			System.out.println("걸린 시간: " + 
			Duration.between(start, end).toMillis());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
