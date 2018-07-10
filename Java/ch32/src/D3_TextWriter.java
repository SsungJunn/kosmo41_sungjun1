/*
 * FileWriter 예제
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

class D3_TextWriter {

	public static void main(String[] args) {
		try (Writer out = new FileWriter("data.txt")) {	// 문자 출력 스트림 생성
			
			for(int ch = (int)'A'; ch < (int)('Z'+1); ch++)
				out.write(ch);
			
			out.write(13);
			out.write(10);
			
			// a~z 출력
			for(int ch = (int)'A'+32; ch < (int)('Z'+1+32); ch++)
				out.write(ch);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
