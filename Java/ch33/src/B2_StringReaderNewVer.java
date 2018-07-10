/*
 * 문자 스트림의 생성(NIO.2기반)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class B2_StringReaderNewVer {

	public static void main(String[] args) {
		Path fp = Paths.get("String.txt");
		
		try (BufferedReader br = Files.newBufferedReader(fp)) {
			String str;
			while(true) {
				str = br.readLine();
				if(str == null)
					break;
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}