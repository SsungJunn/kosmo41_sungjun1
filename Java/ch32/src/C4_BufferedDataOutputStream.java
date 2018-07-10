/*
 * 파일에 기본 자료형 데이터를 저장하고 싶은데
 * 버퍼링 기능도 추가하면 좋겠드아~
 */
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class C4_BufferedDataOutputStream {

	public static void main(String[] args) {
		try(DataOutputStream out =
				new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream("data.dat")))) {
			out.writeInt(370);
			out.writeDouble(3.14);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}