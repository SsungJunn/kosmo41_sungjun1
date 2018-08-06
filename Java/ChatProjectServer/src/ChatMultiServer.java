import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class ChatMultiServer {

	public void ConnetionDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	ServerSocket serverSocket = null; // Client ������ �ޱ� ���� ServerSocket
	Socket socket = null; // ������ Client�� ����ϱ� ���� Socket
	Map<String, PrintWriter> clientMap;
	Map<String, PrintWriter> clientMap2;

	// ������
	public ChatMultiServer() {
		// Ŭ���̾�Ʈ�� ��½�Ʈ���� ������ �ؽ��� ����.
		clientMap = new HashMap<String, PrintWriter>();

		// �游��� �ޱ����ؼ� �����Ѱ�
		clientMap2 = new HashMap<String, PrintWriter>();

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

	// public synchronized void RemoveClient(String name) //ä�ù� ����� ���� �� ä�ù濡 �����ϴ�
	// Client���� ���� �ҽ��� �˸�
	// {
	// try {
	// clientmap.remove(name);
	// sendMsg(name + " �����ϼ̽��ϴ�.", "Server");
	// }catch(Exception e) {}
	// }
	// ä�ù� ���� �̰ɷ� �����Ҽ�����������?

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

	public static void main(String[] args) {
		// ������ü ����
		ChatMultiServer ms = new ChatMultiServer();
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

			{
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String waitingroomlist = "���� �� ����Ʈ�� [ ";
				
				try {
					con = ConnectionPool.getConnection();
					// ---------------------------------------------------
					String sql = "select * from CHAT";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						waitingroomlist = waitingroomlist +(String) rs.getString(2)+", ";
					
					}
					waitingroomlist = waitingroomlist.substring(0, waitingroomlist.length()-2) + " ]";
					out.println(waitingroomlist);
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
		}

		// �游�� �� ����Ʈ ���� (�ϴ��� ���ϳ��� �����ϴ� �����Ͽ�)
		public void ShowName2(String name) {
			Set<String> set = clientMap2.keySet();
			PrintWriter pr = (PrintWriter) clientMap2.get(name);

			pr.println("����� ����Ʈ [" + set + "]");
		}

		// �ӼӸ�
		public void ShowTalk(String s) {

			System.out.println("�ӼӸ�����!!!!!!");

			StringTokenizer t1 = new StringTokenizer(s);

			t1.nextToken();
			t1.nextToken();
			t1.nextToken();

			String strTmp = t1.nextToken();

			int nTmp2 = s.indexOf(" ");
			String strTmp2 = s.substring(nTmp2 + 1);
			nTmp2 = strTmp2.indexOf(" ");
			strTmp2 = strTmp2.substring(nTmp2 + 1);
			nTmp2 = strTmp2.indexOf(" ");
			strTmp2 = strTmp2.substring(nTmp2 + 1);
			nTmp2 = strTmp2.indexOf(" ");
			strTmp2 = strTmp2.substring(nTmp2 + 1);

			PrintWriter pr = (PrintWriter) clientMap.get(strTmp);
			pr.println("[" + name + "]" + "���� �ӼӸ� :" + strTmp2);
		}

		// �ӼӸ� ����
		public void ShowOnlyTalk(String s, String name) {

			String msg = "";

			System.out.println("�ӼӸ���������!!!!!!");

			StringTokenizer t1 = new StringTokenizer(s);
			t1.nextToken();
			t1.nextToken();
			t1.nextToken();

			String strTmp = t1.nextToken();

			while (true) {
				try {
					msg = in.readLine();

					int nTmp2 = msg.indexOf(" ");
					String strTmp2 = msg.substring(nTmp2 + 1);
					nTmp2 = strTmp2.indexOf(" ");
					strTmp2 = strTmp2.substring(nTmp2 + 1);
					
					PrintWriter pr = (PrintWriter) clientMap.get(strTmp);
					
					if (msg.equals("[" + name + "]" + " " + ":" + " " + "/bye")) {
						pr.println("������ �ӼӸ��� �������ϴ�.");
						out.println("������ �ӼӸ��� �������ϴ�.");
						break;
					}
					pr.println("[" + name + "]" + "���� �ӼӸ� :" + strTmp2);
				} catch (Exception e) {

				}
			}
		}

		public void BulletinBoard(String s, String name) {

			int nTmp = s.indexOf(" ");
			String msg = s.substring(nTmp + 1);
			nTmp = msg.indexOf(" ");
			msg = msg.substring(nTmp + 1);
			nTmp = msg.indexOf(" ");
			msg = msg.substring(nTmp + 1);
			System.out.println(msg);

			Iterator it = clientMap.keySet().iterator();
			Iterator it2 = clientMap2.keySet().iterator();

			while (it.hasNext()) {
				try {
					PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
					it_out.println("==============");
					it_out.println("==��������====> " + msg);
					it_out.println("==============");
				} catch (Exception e) {
					System.out.println("����" + e);
				}
			}
			
			while(it2.hasNext()) {
				try {
					PrintWriter it_out2 = (PrintWriter) clientMap2.get(it2.next());
					it_out2.println("==============");
					it_out2.println("==��������====> " + msg);
					it_out2.println("==============");
				} catch (Exception e) {
					System.out.println("����" + e);
				}
			}
		}
//		// �ߺ��̸� Ȯ�� => DB���� ã�Ҵµ� �ٽ� ������ �ε�ε�
//		public void OverlapName(String name) {
//			//////////////
//			// �ߺ��̸�üũ//
//			/////////////
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			try {
//				con = DriverManager.getConnection(
//						"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
//						"tiger");
//
//				String sql = "select * from CHAT";
//				pstmt = con.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//				while (rs.next()) {
//					// System.out.print("id : " + rs.getString(1));
//					if (rs.getString(1).equals(name)) {
//						PrintWriter pr = (PrintWriter) clientMap.get(name);
//						pr.println(name + "���� ID �Դϴ�. ���ο� ���̵� �����آa");
//						clientMap.remove(name);
//
//						// return; // ��� �ؾߵ��� ���⼭ ?!!!?!?!?!?!?!?!?!!?!?!?!?!?!?!?
//					}
//				}
//			} catch (SQLException sqle) {
//				sqle.printStackTrace();
//			} finally {
//				try {
//					if (rs != null)
//						rs.close();
//					if (pstmt != null)
//						pstmt.close();
//					if (con != null)
//						con.close();
//				} catch (Exception e) {
//				}
//			}
//		}

//		// ������Ʈ => DB���� ã�Ҵµ� �ٽ� ������ �ε�ε�
//		public void BanPerson(String name) {
//			//////////////////
//			/// ������Ʈ Ȯ�� ///
//			//////////////////
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			try {
//				con = ConnectionPool.getConnection();
//
//				String sql = "select * from Ban where player = " + name;
//				pstmt = con.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//				int count = 1;
//				while (rs.next())
//				{
//					if(rs.getString(1).equals(name)) {
//						count = 2;
//					try {
//						name = in.readLine();
//						count = 1;
//					} catch (Exception e) {
//						System.out.println("1111");
//						e.printStackTrace();
//					}
//					}
//					else
//					{
//						break;
//					}
//				}
//			} catch (SQLException sqle) {
//				sqle.printStackTrace();
//			} finally {
//				try {
//					if (rs != null)
//						rs.close();
//					if (pstmt != null)
//						pstmt.close();
//					if (con != null)
//						con.close();
//				} catch (Exception e) {
//				}
//			}
//		}

		// ��ȭ��� ���� ���� ������
		public void BlockPerson(String s, String name) {

			int nTmp2 = s.indexOf(" ");
			String strbp = s.substring(nTmp2);
			nTmp2 = strbp.indexOf(" ");
			strbp = strbp.substring(nTmp2 + 1, nTmp2 + 2);

			PrintWriter pr = (PrintWriter) clientMap.get(strbp);
			pr.println(name + "�Կ� ���� �� ���ܴ���");

		}

		// ���ο� �� �����(������), (�������)
		public void MakeRoom(String name) {

			String rn = "";

//			out.println("����(open)/����� ����(password)");
			try {
//				pr = in.readLine();
//				if (pr.equals(name + "=>" + "password")) {
//					PasswordRoom(name);
//				}
				out.println("�������� �Է��ϼ���.");
				rn = in.readLine();
				
				int nTmp = rn.indexOf(" ");
				String msg = rn.substring(nTmp + 1);
				nTmp = msg.indexOf(" ");
				rn = msg.substring(nTmp + 1);
				System.out.println(rn);
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				clientMap.remove(name);
				clientMap2.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.

				try {
					con = ConnectionPool.getConnection();

					System.out.println("�� ���������!!!!");
					out.println("�� ���������!!!!");

					String sql = "insert into MakeRoom values(?, ?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, rn);
					pstmt.setString(2, name);
					int updateCount = pstmt.executeUpdate();

					pstmt.clearParameters();
					sql = "delete from CHAT where player = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.executeUpdate();
					
					pstmt.clearParameters();
					System.out.println("2222");
					sql = "insert into RoomList values(?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, rn);
					updateCount = pstmt.executeUpdate();

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
					} catch (SQLException sqle) {
					}
				}
			} catch (Exception e) {
				System.out.println("����:" + e);
			}
		}

		// �� ������
		public void OutRoom(String name) {
			
			System.out.println(name + "���� �濡�� �����̽��ϴ�.");
			clientMap2.remove(name);
			clientMap.put(name, out);
			
			sendSomeMsg(name + "���� �����ϼ̽��ϴ�.");
			System.out.println("���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ConnectionPool.getConnection();
				String sql = "delete from MakeRoom where player = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.executeUpdate();

				// ----------------------------------------------------------------
				sql = "insert into CHAT values(?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "����");
				pstmt.setString(2, name);
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
							ShowTalk(s);
						}
						if (s.indexOf("/block") >= 0) {
							BlockPerson(s, name);
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
			
			String rn = "";
			
			try {

				out.println("���� �� �������� �Է��ϼ���.");
				rn = in.readLine();
				
				int nTmp = rn.indexOf(" ");
				String msg = rn.substring(nTmp + 1);
				nTmp = msg.indexOf(" ");
				msg = msg.substring(nTmp + 1);
				System.out.println(msg);
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				clientMap.remove(name);
				clientMap2.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.

				try {
					con = ConnectionPool.getConnection();

					System.out.println("�� �� ����!!!!");
					out.println("�� ������!!!!");

					String sql = "insert into MakeRoom values(?, ?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, msg);
					pstmt.setString(2, name);
					int updateCount = pstmt.executeUpdate();
					
					pstmt.clearParameters();
					sql = "select * from MakeRoom";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						if (rn.equals(rs.getString(1))) {
							// sql = "insert into MakeRoom values('" + JoinPerson + "', '" + name + "', " +
							// null + ")";
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1, rn);
							pstmt.setString(2, name);
							updateCount = pstmt.executeUpdate();
						}
					}
					
					pstmt.clearParameters();
					sql = "delete from CHAT where player = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.executeUpdate();
					
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
					} catch (SQLException sqle) {
					}
				}
			} catch (Exception e) {
				System.out.println("����:" + e);
			}
		}

		public void RoomList(String name) {

			{
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String roomlist = "��ü �� ����Ʈ�� [ ";
				
				try {
					con = ConnectionPool.getConnection();
					// ---------------------------------------------------
					String sql = "select * from RoomList";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						roomlist = roomlist +(String) rs.getString(1)+", ";
					
					}
					roomlist = roomlist.substring(0, roomlist.length()-2) + " ]";
					out.println(roomlist);
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
		}
		
		// �����带 ����ϱ� ���ؼ� run()�޼��� ������
		@Override
		public void run() {

			String s = "";

			try {
				// Ŭ���̾�Ʈ���� ó������ ������ �޽�����
				// Ŭ���̾�Ʈ�� ����� �̸��̴�.
				name = in.readLine();

//				BanPerson(name); // ������Ʈ üũ

				// OverlapName(name); // �ߺ� �̸� üũ

				clientMap.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.

				sendAllMsg(name + "���� �����ϼ̽��ϴ�."); // ���� ��ü�� ������ �ִ� ������ �����ϰ� �ٸ� ����(Ŭ���̾�Ʈ)�鿡�� ������ �˸�.

				System.out.println("���� ������ ���� " + clientMap.size() + "�� �Դϴ�.");

				Connection con = null;
				PreparedStatement pstmt = null;
				con = ConnectionPool.getConnection();
				
				try {					
					String sql = "insert into CHAT values(?, ?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "����");
					pstmt.setString(2, name);
					pstmt.executeUpdate();

				} catch (SQLException sqle) {
					System.out.println("6");
					sqle.printStackTrace();
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (con != null)
							con.close();
					} catch (SQLException sqle) {
					}
				}
				// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
				while (in != null) {

					s = in.readLine();
					System.out.println(s);

					if (s.equals("[" + name + "]" + " " + ":" + " " + "/room")) {
						MakeRoom(name);
						
						try {
							// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
							while (in != null) {

								s = in.readLine();
								System.out.println(s);

								if (s.equals("[" + name + "]" + " " + ":" + " " + "/list")) {
									ShowName(name);
								} else if (s.equals("[" + name + "]" + " " + ":" + " " + "//list")) {
									ShowName2(name);
								} else if (s.equals("[" + name + "]" + " " + ":" + " " + "/exit")) {
									OutRoom(name);
									break;
								} else if (s.indexOf("/tap") >= 0) {
									ShowTalk(s);
								} else if (s.indexOf("/Tap") >= 0) {
									ShowOnlyTalk(s, name);
								} else if (s.indexOf("/board") >= 0) {
									BulletinBoard(s, name);
								} else if (s.indexOf("/block") >= 0) {
									BlockPerson(s, name);
								} else {
									sendSomeMsg(s);
								}
							}
						} catch (Exception e) {
							System.out.println("����:" + e);
						}
						
					} else if (s.equals("[" + name + "]" + " " + ":" + " " + "/join")) {
						JoinRoom(name);
						
						try {
							// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
							while (in != null) {

								s = in.readLine();
								System.out.println(s);

								if (s.equals("[" + name + "]" + " " + ":" + " " + "/list")) {
									ShowName(name);
								} else if (s.equals("[" + name + "]" + " " + ":" + " " + "//list")) {
										ShowName2(name);
								} else if (s.equals("[" + name + "]" + " " + ":" + " " + "/exit")) {
									OutRoom(name);
									break;
								} else if (s.indexOf("/tap") >= 0) {
									ShowTalk(s);
								} else if (s.indexOf("/Tap") >= 0) {
									ShowOnlyTalk(s, name);
								} else if (s.indexOf("/board") >= 0) {
									BulletinBoard(s, name);
								} else if (s.indexOf("/block") >= 0) {
									BlockPerson(s, name);
								} else {
									sendSomeMsg(s);
								}
							}
						} catch (Exception e) {
							System.out.println("����:" + e);
						}
					} else if (s.equals("[" + name + "]" + " " + ":" + " " + "/list")) {
						ShowName(name);
					} else if (s.equals("[" + name + "]" + " " + ":" + " " + "//list")) {
						ShowName2(name);
					} else if (s.equals("[" + name + "]" + " " + ":" + " " + "/roomlist")) {
						RoomList(name);
					} else if (s.equals("q") || s.equals("Q")) {
						break;
					} else if (s.indexOf("/tap") >= 0) {
						ShowTalk(s);
					} else if (s.indexOf("/Tap") >= 0) {
						ShowOnlyTalk(s, name);
					} else if (s.indexOf("/board") >= 0) {
						BulletinBoard(s, name);
					} else if (s.indexOf("/block") >= 0) {
						BlockPerson(s, name);
					} else {
						sendAllMsg(s);
					}
				}
				// System.out.println("Bye...");

			} catch (Exception e) {
				System.out.println("����:" + e);
			} finally {
				System.out.println("7777777777777");
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
