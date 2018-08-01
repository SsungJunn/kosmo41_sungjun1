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
					
					// 귓속말 고정 됬다 시부렐 또 안되네///;;; 당황스럽게
					if(s2.length()>3&&s2.substring(0, 3).equals("/to"))
					{
						out.println(s2);
						String t[] = s2.split(" ");
						String name = t[1];
						while(true)
						{
							String tt = s.nextLine();
							if(tt.equals("//to"))
							{
								break;
							}
							out.println("/to" + " " + name + " " + tt);
						}
					}
					
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