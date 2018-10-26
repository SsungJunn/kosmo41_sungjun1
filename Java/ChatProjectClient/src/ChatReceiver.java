import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

// 서버로 메시지를 전송하는 클래스
public class ChatReceiver extends Thread {
	//Scanner s = new Scanner(System.in);
	
	Socket socket;
	BufferedReader in = null;
	
	// Socket을 매개변수로 받는 생성자
	public ChatReceiver(Socket socket)
	{
		this.socket = socket;
		
		try {
			// 접속한 client로부터 데이터를 읽어들이기 위한 BufferedReader 생성
			in = new BufferedReader(new InputStreamReader(
					this.socket.getInputStream()));			
		} catch (Exception e) {
			System.out.println("����1:"+e);
		}
	}
	
	// run()메소드 재정의
	@Override
	public void run() {
		while (in!=null) {
			try {
				System.out.println("Thread Receive : " + in.readLine());
			} catch (java.net.SocketException ne) {
				break;
			} catch (Exception e) {
				System.out.println("예외2:"+e);
				//접속끊기??
				//클라이언트.RemoveClient(this.name)
			}
		}
		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외3:"+e);
		}
	}

}

