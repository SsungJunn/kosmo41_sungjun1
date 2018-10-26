
/*
 * 콘솔 멀티채팅 클라이언트 프로그램
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatMultiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("이름을 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();

		PrintWriter out = null;

		try {
			String ServerIP = "192.168.0.105";
			// String ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999); // 소켓 객체 생성
			System.out.println("서버와 연결이 되었습니다.......");

			// 서버에서 보내는 메시지를 사용자의 콘솔에 출력하는 쓰레드.
			Thread receiver = new ChatReceiver(socket);
			receiver.start();

			Thread sender = new ChatSender(socket, s_name);
			sender.start();

		} catch (Exception e) {
			System.out.println("����[MultiClient class]:" + e);
		}
	}
}