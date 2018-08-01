
/*
 * �ܼ� ��Ƽä�� Ŭ���̾�Ʈ ���α׷�
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatMultiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�̸��� �Է��� �ּ���.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();

		PrintWriter out = null;

		try {
			String ServerIP = "192.168.0.105";
			// String ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999); // ���� ��ü ����
			System.out.println("������ ������ �Ǿ����ϴ�.......");

			// �������� ������ �޽����� ������� �ֿܼ� ����ϴ� ������.
			Thread receiver = new ChatReceiver(socket);
			receiver.start();

			Thread sender = new ChatSender(socket, s_name);
			sender.start();

		} catch (Exception e) {
			System.out.println("����[MultiClient class]:" + e);
		}
	}
}