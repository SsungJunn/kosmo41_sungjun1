/*
 * 파일 대상 입출력 스트림 생성의 예
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class A1_Read65FromFile {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("data.dat");
			// 입력 스트림 생성
			
			int dat = in.read();	// 데이터 읽음
			in.close();				// 입력 스트림 종료
			
			System.out.println(dat);
			System.out.printf("%c", dat);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}