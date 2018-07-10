/*
 * NIO 기반 파일 복사 예제
 */
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

class C1_FileCopierVerNIO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대상파일: ");
		Path src = Paths.get(sc.nextLine());

		System.out.println("사본이름: ");
		Path dst = Paths.get(sc.nextLine());
		
		// 하나의 버퍼 생성
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		// try에서 두 개의 채널 생성
		try (FileChannel ifc = FileChannel.open (src, StandardOpenOption.READ);
				FileChannel ofc = 
						FileChannel.open(dst, StandardOpenOption.WRITE, 
										 StandardOpenOption.CREATE)) 
		{
			int num;
			while(true) {
				num = ifc.read(buf);	// 채널 ifc에서 버퍼로 읽어 들임
				if(num == -1)	// 읽어 들인 데이터가 없다면
					break;
				
				buf.flip();		// 모드 변환
				ofc.write(buf);	// 버퍼에서 채널 ofc로 데이터 전송
				buf.clear();	// 버퍼 비우기
			}	
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
}