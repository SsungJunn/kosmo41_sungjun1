/*
 * 버퍼링 기능을 제공하는 필터 스트림
 * 바이트 단위 복사가 진행되지만 버퍼링 되므로 속도는 빠르다!
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
		System.out.println("대상 파일: ");
		String src = sc.nextLine();
		System.out.println("사본 이름: ");
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
			System.out.println("걸린 시간: " + 
			Duration.between(start, end).toMillis());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
