import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChatSender extends Thread {
	Socket socket;
	PrintWriter out = null;
	String name;

	// 생성자
	public ChatSender(Socket socket, String name) {
		this.socket = socket;
		try {
			out = new PrintWriter(this.socket.getOutputStream(), true);
			this.name = name;
		} catch (Exception e) {
			System.out.println("예외S3:" + e);
		}
	}

	// run()메소드 재정의
	@Override
	public void run() {

		Scanner s = new Scanner(System.in);
		try {
			// 서버에 입력한 사용자이름을 보내준다.
			out.println(name);

			while (out != null) {
				try {
					String s2 = s.nextLine();
					
					if (s2.equals("q") || s2.equals("Q")) {
						out.println(s2);
						break;
					} else {
						out.println("[" + name + "]" + " " + ":" + " " + s2);
					}

				} catch (Exception e) {
					System.out.println("예외S1:" + e);
				}
			}
			
			out.close();

			socket.close();

		} catch (Exception e) {
			System.out.println("예외2:" + e);
		}
	}
}