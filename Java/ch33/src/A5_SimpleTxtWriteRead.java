/*
 * 문자 데이터의 간단한 입력 및 출력의 예
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class A5_SimpleTxtWriteRead {

	public static void main(String[] args) throws IOException{
		Path fp = Paths.get("D:\\sky794373\\study\\simple.txt");
		String st1 = "One Simple String";
		String st2 = "Two Simple String";
		List<String> lst1 = Arrays.asList(st1, st2);
		
		Files.write(fp, lst1);	// 파일에 문자열 저장하기
		List<String> lst2 = Files.readAllLines(fp);
		System.out.println(lst2);
	}

}
