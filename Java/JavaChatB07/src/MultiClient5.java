
/*
 * 콘솔 멀티채팅 클라이언트 프로그램
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultiClient5 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("이름을 입력해 주세요.(무조건 한글자)");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();

		PrintWriter out = null;

		try {
			String ServerIP = "192.168.0.129";
			// String ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999); // 소켓 객체 생성
			System.out.println("서버와 연결이 되었습니다.......");

			// 서버에서 보내는 메시지를 사용자의 콘솔에 출력하는 쓰레드.
			Thread receiver = new Receiver5(socket);
			receiver.start();

			Thread sender = new Sender5(socket, s_name);
			sender.start();

		} catch (Exception e) {
			System.out.println("예외[MultiClient class]:" + e);
		}
	}
}