/*
 * ����� ��Ʈ�� ���� �ڵ��� ����:try-with-resource ���
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class A5_Write65ToFile3 {

	public static void main(String[] args) {
		try(OutputStream out = new FileOutputStream("data.dat")) 
		{
			out.write(65);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
