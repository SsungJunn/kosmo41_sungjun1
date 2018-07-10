/*
 * ���۸� ����� �����ϴ� ���� ��Ʈ��
 * ����Ʈ ���� ���簡 ��������� ���۸� �ǹǷ� �ӵ��� ������!
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

class C3_BufferedStreamFileCopier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��� ����: ");
		String src = sc.nextLine();
		System.out.println("�纻 �̸�: ");
		String dst = sc.nextLine();
		
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst)))	{
			
			Instant start = Instant.now();
			
			int data;
			while(true) {
				data = in.read();
				if(data == -1)
					break;
				out.write(data);
			}
			
			Instant end = Instant.now();
			System.out.println("�ɸ� �ð�: " + 
			Duration.between(start, end).toMillis());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
