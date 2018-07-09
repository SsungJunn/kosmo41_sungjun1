
/*
 * 입출력 스트림 관련 코드의 개선: finally 기반 close
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Write65ToFile2 {
	public static void main(String[] atgs) throws IOException {
		// 출력 스트림 생성

		OutputStream out = null;
		try {
			out = new FileOutputStream("data.dat");
			out.write(66); // 65를 저장
		} catch (IOException e) {
		} finally {
			if (out != null) // 출력 스트리 생성 성공했다면,
				out.close(); // 스트림 종료
		}
	}
}
