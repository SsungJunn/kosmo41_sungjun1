/*
 * 입출력 스트림 관련 코드의 개선:try-with-resource 기반
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class A6_Read65FromFile3 {

	public static void main(String[] args) {
		try(InputStream in = new FileInputStream("data.dat"))
		{
			int dat = in.read();
			System.out.println(dat);
			System.out.printf("%c \n", dat);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
