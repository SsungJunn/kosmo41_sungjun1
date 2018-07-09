
/*
 * 파일 대상 입출력 스트림 생성의 예
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class A4_Read65FromFile2 {

	public static void main(String[] args) throws IOException {
		InputStream in = null;
		try {
			in = new FileInputStream("data.dat");
			int dat = in.read(); // 데이터 읽음
			System.out.println(dat);
			System.out.printf("%c", dat);
		} catch (IOException e) {
		}

		finally {
			if (in != null) // 입력 스트림 생성 성공했다면,
				in.close(); // 입력 스트림 종료
		}
	}
}