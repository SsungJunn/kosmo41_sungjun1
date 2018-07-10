/*
 * 문자 스트림의 생성(NIO.2기반)
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class B1_StringWriterNewVer {

	public static void main(String[] args) {
		String ks = "공부에 있어서 . . . ";
		String es = "Life is long if . . . ";
		Path fp = Paths.get("String.txt");
		
		try (BufferedWriter bw = Files.newBufferedWriter(fp)) {
			bw.write(ks, 0, ks.length());
			bw.newLine();
			bw.write(es, 0, es.length());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}