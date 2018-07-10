/*
 * 보다 빠른 속도의 파일 복사 프로그램
 * 1K 바이트 버퍼 기반 파일 복사 프로그램
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class B2_BufferedFileCoper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대상 파일: ");
		String src = sc.nextLine();
		System.out.println("사본 이름: ");
		String dst = sc.nextLine();

		try (InputStream in = new FileInputStream(src); 
			 OutputStream out = new FileOutputStream(dst)) {
			
			Instant start = Instant.now();
			
			byte buf[] = new byte[1024];
			int len;

			while (true) {
				len = in.read(buf);	// 배열 buf로 데이터를 일어 들이고, (더 이상 읽어 들일 데이터 없으면 -1 반환)
				if (len == -1)
					break;
				out.write(buf, 0, len);	// len 바이트만큼 데이터를 저장한다.
			}
			
			Instant end = Instant.now();
			System.out.println("걸린 시간: " + 
			Duration.between(start, end).toMillis());
			
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
// public int read(byte[] b) throws IOException
// -> 파일에 전달된 배열의 데이터를 b로 전달된 배열에 저장
// public void write(byte[] b, int off, int len) throws IOException
// -> b로 전달된 배열의 데이터를 인덱스 off에서부터 len 바이트만큼 파일에 저장