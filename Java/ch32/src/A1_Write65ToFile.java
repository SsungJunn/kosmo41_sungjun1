/*
 * 파일 대상 입출력 스트림 생성의 예
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Write65ToFile {
	public static void main(String[] atgs) throws IOException {
		//	출력 스트림 생성
		
		OutputStream out = new FileOutputStream("data.dat");
		out.write(65);	// 65를 저장
		out.close();	// 스트림 종료
	}
}


