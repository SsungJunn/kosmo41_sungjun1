import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChatSender extends Thread {
	Socket socket;
	PrintWriter out = null;
	String name;

	// ������
	public ChatSender(Socket socket, String name) {
		this.socket = socket;
		try {
			out = new PrintWriter(this.socket.getOutputStream(), true);
			this.name = name;
		} catch (Exception e) {
			System.out.println("����S3:" + e);
		}
	}

	// run()�޼ҵ� ������
	@Override
	public void run() {

		Scanner s = new Scanner(System.in);
		try {
			// ������ �Է��� ������̸��� �����ش�.
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
					System.out.println("����S1:" + e);
				}
			}
			
			out.close();

			socket.close();

		} catch (Exception e) {
			System.out.println("����2:" + e);
		}
	}
}