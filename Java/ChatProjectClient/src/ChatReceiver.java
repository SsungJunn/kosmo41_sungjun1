import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

// ������ �޽����� �����ϴ� Ŭ����
public class ChatReceiver extends Thread {
	//Scanner s = new Scanner(System.in);
	
	Socket socket;
	BufferedReader in = null;
	
	// Socket�� �Ű������� �޴� ������
	public ChatReceiver(Socket socket)
	{
		this.socket = socket;
		
		try {
			// ������ Client�κ��� �����͸� �о���̱� ���� BufferedReader ����
			in = new BufferedReader(new InputStreamReader(
					this.socket.getInputStream()));			
		} catch (Exception e) {
			System.out.println("����1:"+e);
		}
	}
	
	// run()�޼ҵ� ������
	@Override
	public void run() {
		while (in!=null) {
			try {
				System.out.println("Thread Receive : " + in.readLine());
			} catch (java.net.SocketException ne) {
				break;
			} catch (Exception e) {
				System.out.println("����2:"+e);
				//���Ӳ���??
				//Ŭ���̾�Ʈ.RemoveClient(this.name)
			}
		}
		try {
			in.close();
		} catch (Exception e) {
			System.out.println("����3:"+e);
		}
	}

}

