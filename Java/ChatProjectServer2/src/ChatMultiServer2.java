import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ChatMultiServer2 {
	ServerSocket serverSocket = null;	// Client ������ �ޱ� ����  ServerSocket	
	Socket socket = null;	// ������ Client�� ����ϱ� ���� Socket
	Map<String, PrintWriter> clientMap;
	Map<String, PrintWriter> clientMap2;

	public void ConnetionDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void ConnectionDB(String name) {
		String nName = name;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott", "tiger");
			// ���̺� ����
//			String sql = "create table CHAT(id varchar(10), " + "password varchar(10))";
			
			// DB�� ������Ʈ�ϱ� ���� �ڵ�
//			pstmt = con.prepareStatement(sql);
//			int updateCount = pstmt.executeUpdate();
//			System.out.println("createCount : " + updateCount);

			// ---------------------------------------------------
			String sql = "insert into CHAT values(?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nName);
			int updateCount = pstmt.executeUpdate();
//			System.out.println("insertCount : " + updateCount);

			// ---------------------------------------------------
//			sql = "select * from CHAT";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				System.out.print("id : " + rs.getString(1));
//				System.out.println(", password : " + rs.getString(2));
//			}

			// sql = "delete Ban where id = ?";
			// pstmt = con.prepareStatement(sql);
			// pstmt.setString(1, name);
			// int up = pstmt.executeUpdate();
			//
			// name = in.readLine();
			
			// ----------------------------------------------------
//			sql = "drop table CHAT";
//			pstmt = con.prepareStatement(sql);
//			updateCount = pstmt.executeUpdate();
//			System.out.println("dropCount : " + updateCount);

			// ----------------------------------------------------
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}
	
	
	// ������
	public void ChatMultiServer() {
		// Ŭ���̾�Ʈ�� ��½�Ʈ���� ������ �ؽ��� ����.
		clientMap = new HashMap<String, PrintWriter>();
		
		// �游��� �ޱ����ؼ� �����Ѱ�
		clientMap2  = new HashMap<String, PrintWriter>();
		
		// �ؽ��� ����ȭ ����
		Collections.synchronizedMap(clientMap);
		
		// �游��� �ޱ����ؼ� �����Ѱ�
		Collections.synchronizedMap(clientMap2);
	}
	
	public void init() {
		try {
			// ���� ���� ��ü ����
			serverSocket = new ServerSocket(9999); // 9999��Ʈ�� �������� ��ü ����
			System.out.println("������ ���۵Ǿ����ϴ�.");

			while (true) {

				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + ":" + socket.getPort());

				Thread msr = new MultiServerT(socket); // ������ ����
				msr.start(); // ������ �õ�.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
//	  public synchronized void RemoveClient(String name)  //ä�ù� ����� ���� �� ä�ù濡 �����ϴ� Client���� ���� �ҽ��� �˸�
//    {
//        try {
//            clientmap.remove(name);
//            sendMsg(name + " �����ϼ̽��ϴ�.", "Server");
//            System.out.println("ä�� ���� �ο� : "+clientmap.size());
//        }catch(Exception e) {}
//    }
//ä�ù� ����	�̰ɷ� �����Ҽ�����������?

	// ���ӵ� ��� Ŭ���̾��Ʋ���� �޽����� ����.
	public void sendAllMsg(String msg) {

		// ��½�Ʈ���� ���������� ���ͼ� �ش� �޽����� ����Ѵ�.
		Iterator it = clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				it_out.println(msg);

			} catch (Exception e) {
				System.out.println("����" + e);
			}
		}
	}

	// �濡 �ִ� ��� Ŭ���̾��Ʋ���� �޽����� ����.
	public void sendSomeMsg(String msg) {

		// ��½�Ʈ���� ���������� ���ͼ� �ش� �޽����� ����Ѵ�.
		Iterator it = clientMap2.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap2.get(it.next());
				it_out.println(msg);

			} catch (Exception e) {
				System.out.println("����" + e);
			}
		}
	}

	public static void main(String[] args) {
		// ������ü ����
		ChatMultiServer2 ms = new ChatMultiServer2();
		ms.init();
	}

	/////////////
	// ���� Ŭ���� //
	// Ŭ���̾�Ʈ�κ��� �о�� �޽����� �ٸ� Ŭ���̾�Ʈ(socket)�� ������ ������ �ϴ� �޼���

	class MultiServerT extends Thread {
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		String name = "";
		
		// ������
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			} catch (Exception e) {
				System.out.println("����:" + e);
			}
		}

		// ������ list Ȯ��
		public void ShowName(String name) {
			Set<String> set = clientMap.keySet();

			out.println("����� ����Ʈ [" + set + "]");
		}

		// �游�� �� ����Ʈ ���� (�ϴ��� ���ϳ��� �����ϴ� �����Ͽ�)
		public void ShowName2(String name) {
			Set<String> set = clientMap2.keySet();
			PrintWriter pr = (PrintWriter) clientMap2.get(name);

			pr.println("����� ����Ʈ [" + set + "]");
		}
		
		// �ӼӸ�
		public void ShowTalk(String s, String name) throws IOException {

			System.out.println("�ӼӸ�����!!!!!!");

			StringTokenizer t1 = new StringTokenizer(s);

			t1.nextToken();

			String strTmp = t1.nextToken();

			int nTmp2 = s.indexOf(" ");
			String strTmp2 = s.substring(nTmp2 + 1);
			nTmp2 = strTmp2.indexOf(" ");
			strTmp2 = strTmp2.substring(nTmp2 + 1);
			
			PrintWriter pr = (PrintWriter) clientMap.get(strTmp);
			pr.println(strTmp2);
		}
		
		// �ӼӸ� ����
		public void ShowOlnyTalk(String name) throws IOException {

			System.out.println("�ӼӸ�����!!!!!!");

			String s = "";
			s = in.readLine();
			
			StringTokenizer t1 = new StringTokenizer(s);

			t1.nextToken();

			String strTmp = t1.nextToken();

			int nTmp2 = s.indexOf(" ");
			String strTmp2 = s.substring(nTmp2 + 1);
			nTmp2 = strTmp2.indexOf(" ");
			strTmp2 = strTmp2.substring(nTmp2 + 1);
			
			PrintWriter pr = (PrintWriter) clientMap.get(strTmp);
			pr.println(strTmp2);
		}
		
		// ���ο� �� �����(������), (�������)
		public void Room(String name) {

			String pr = "";

			out.println("����(open)/����� ����(password)");
			try {
				pr = in.readLine();
				if (pr.equals(name + "=>" + "password")) {
					PasswordRoom(name);
				}

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				clientMap.remove(name);
				clientMap2.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.

				try {
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe",
							"scott", "tiger");

					// ���̺� ����
					String sql = "create table Room(id varchar(10))";

					// DB�� ������Ʈ�ϱ� ���� �ڵ�
					pstmt = con.prepareStatement(sql);
					int updateCount = pstmt.executeUpdate();
					// System.out.println("createCount : " + updatCount);
					System.out.println("�� ���������!!!!");
					out.println("�� ���������!!!!");

					sql = "insert into Room values(?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					updateCount = pstmt.executeUpdate();

					String s = "";

					try {
						// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
						while (in != null) {

							s = in.readLine();
							System.out.println(s);

							if (s.equals(name + "=>" + "/exit")) {
								OutRoom(name);
							}
							if (s.equals(name + "=>" + "/list")) {
								ShowName(name);
							}
							if (s.equals(name + "=>" + "//list")) {
								ShowName2(name);
							}
							if (s.equals("q") || s.equals("Q")) {
								break;
							}
							if (s.indexOf("/tap") >= 0) {
								ShowTalk(s, name);
							}
							else {
								sendSomeMsg(s);
							}
						}
						// System.out.println("Bye...");

					} catch (Exception e) {
						System.out.println("����:" + e);
					}

				} catch (SQLException sqle) {
					sqle.printStackTrace();
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (con != null)
							con.close();
						if (rs != null)
							rs.close();
					} catch (SQLException sqle) { }
				}
			} catch (Exception e) {
				System.out.println("����:" + e);
			}
		}

		// �������
		public void PasswordRoom(String name) {
			
			out.println("��й�ȣ�� �Է��Ͻÿ�.");
			String pw = "";
					try {
						pw = in.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
	
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			clientMap.remove(name);
			clientMap2.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
				
			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				
				// ���̺� ����
				String sql = "create table Room(id varchar2(10)" + "password varchar2(10))";

				// DB�� ������Ʈ�ϱ� ���� �ڵ�
				pstmt = con.prepareStatement(sql);
				int updateCount = pstmt.executeUpdate();
				System.out.println("�� ���������!!!!");
				out.println("�� ���������!!!!");

				sql = "insert into Room values(?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, pw);
				updateCount = pstmt.executeUpdate();

				String s = "";

				try {
					// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
					while (in != null) {

						s = in.readLine();
						System.out.println(s);

						if (s.equals(name + "=>" + "/list")) {
							ShowName(name);
						}
						if (s.equals(name + "=>" + "//list")) {
							ShowName2(name);
						}
						if (s.equals("q") || s.equals("Q")) {
							break;
						}
						if (s.indexOf("/tap") >= 0) {
							ShowTalk(s, name);
						} else {
							sendSomeMsg(s);
						}
					}
					// System.out.println("Bye...");

				} catch (Exception e) {
					System.out.println("����:" + e);
				} finally {
					System.out.println("8888888888888");
					// ���ܰ� �߻��Ҷ� ���� �ؽ��ʿ��� �ش� ������ ����.
					// ���� �����ϰų� ������ java.net.SocketException: ���ܹ߻�
					clientMap.put(name, out); // ���� �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
					clientMap2.remove(name);
					sendSomeMsg(name + "���� �����ϼ̽��ϴ�.");
					System.out.println("���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");

					try {
						in.close();
						out.close();

						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
					if (rs != null)
						rs.close();
				} catch (Exception e) {
				}
			}
		}

		// �濡 �����ؼ�~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		public void JoinRoom(String name) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			clientMap.remove(name);

			clientMap2.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.

			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");

				// ---------------------------------------------------
				String sql = "insert into Room values(?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				int updateCount = pstmt.executeUpdate();

				// ---------------------------------------------------

				Iterator it = clientMap2.keySet().iterator();

				while (it.hasNext()) {
					try {
						PrintWriter it_out = (PrintWriter) clientMap2.get(it.next());
						it_out.println(name + "���� �濡 ���Խ��ϴ�.");

					} catch (Exception e) {
						System.out.println("����" + e);
					}
				}

				System.out.println("���� ���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");

				String s = "";

				try {
					// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
					while (in != null) {

						s = in.readLine();
						System.out.println(s);

						if (s.equals(name + "=>" + "/list")) {
							ShowName(name);
							System.out.println("111122222222222222222222222211");
						}
						if (s.equals(name + "=>" + "//list")) {
							ShowName2(name);
						}
						if (s.equals("q") || s.equals("Q")) {
							break;
						}
						if (s.indexOf("/tap") >= 0) {
							ShowTalk(s, name);
						} else {
							sendSomeMsg(s);
						}
					}
					// System.out.println("Bye...");

				} catch (Exception e) {
					System.out.println("����:" + e);
				} finally {
					System.out.println("8888888888888");
					// ���ܰ� �߻��Ҷ� ���� �ؽ��ʿ��� �ش� ������ ����.
					// ���� �����ϰų� ������ java.net.SocketException: ���ܹ߻�
					clientMap.put(name, out); // ���� �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
					clientMap2.remove(name);
					sendSomeMsg(name + "���� �����ϼ̽��ϴ�.");
					System.out.println("���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");

					try {
						in.close();
						out.close();

						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				// sql = "select * from CHAT";
				// pstmt = con.prepareStatement(sql);
				// rs = pstmt.executeQuery();
				// while (rs.next()) {
				// System.out.print("id : " + rs.getString(1));
				// System.out.println(", password : " + rs.getString(2));
				// }

				// sql = "delete Ban where id = ?";
				// pstmt = con.prepareStatement(sql);
				// pstmt.setString(1, name);
				// int up = pstmt.executeUpdate();
				//
				// name = in.readLine();

				// ----------------------------------------------------
				// sql = "drop table CHAT";
				// pstmt = con.prepareStatement(sql);
				// updateCount = pstmt.executeUpdate();
				// System.out.println("dropCount : " + updateCount);

				// ----------------------------------------------------

			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
				}
			}
		}
		
		// �� ������
		public void OutRoom(String name) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			clientMap2.remove(name);
			clientMap.put(name, out);

			// StringTokenizer t1 = new StringTokenizer(msg);
			// t1.nextToken();
			// String roomname = t1.nextToken();

			System.out.println(name + "���� �濡�� �����̽��ϴ�.");
			sendSomeMsg(name + "���� �����ϼ̽��ϴ�.");
			System.out.println("���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");

			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-52-79-250-121.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				String sql = "delete from Room where id = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.executeUpdate();

				// ----------------------------------------------------------------
				sql = "insert into CHAT values(?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				// pstmt.setString(2, "1111");
				pstmt.executeUpdate();

			} catch (SQLException sqle) {
				System.out.println("6");
				sqle.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException sqle) {
				}
			}
		}
		
		// �����带 ����ϱ� ���ؼ� run()�޼��� ������
		@Override
		public void run() {
			String name = "";

			try {
				name = in.readLine(); // Ŭ���̾�Ʈ���� ó������ ������ �޽�����
									  // Ŭ���̾�Ʈ�� ����� �̸��̴�.

				ConnectionDB(name); // DB����	
				
				sendAllMsg(name + "���� �����ϼ̽��ϴ�.");
				// ���� ��ü�� ������ �ִ� ������ �����ϰ� �ٸ� ����(Ŭ���̾�Ʈ)�鿡�� ������ �˸�.
				clientMap.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.

				System.out.println("���� ������ ���� " + clientMap.size() + "�� �Դϴ�.");

				// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
				
				String s = "";
				
				while (in != null) {
					
					s = in.readLine();
					System.out.println(s);

					if(s.equals(name + "=>" + "/room"))	{
						Room(name);							
					}
					if(s.equals(name + "=>" + "/join"))	{
						JoinRoom(name);							
					}
					if (s.equals(name + "=>" + "/list")) {
						ShowName(name);
					}
					if (s.equals(name + "=>" + "/to")) {
						ShowOlnyTalk(name);
					}
					if (s.equals("q") || s.equals("Q")) {
						break;
					}
					if (s.indexOf("/tap") >= 0) {
						ShowTalk(s, name);
					} 
					else {
						sendAllMsg(s);
					}
				}
				// System.out.println("Bye...");

			} catch (Exception e) {
				System.out.println("����:" + e);
			} finally {
				// ���ܰ� �߻��Ҷ� ���� �ؽ��ʿ��� �ش� ������ ����.
				// ���� �����ϰų� ������ java.net.SocketException: ���ܹ߻�
				clientMap.remove(name);
				sendAllMsg(name + "���� �����ϼ̽��ϴ�.");
				System.out.println("���� ������ ���� " + clientMap.size() + "�� �Դϴ�.");

				try {
					in.close();
					out.close();

					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}