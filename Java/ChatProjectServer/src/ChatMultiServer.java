//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//import java.util.StringTokenizer;
//
//public class ChatMultiServer {
//
//	public void ConnetionDBA() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		}
//	}
//
//	ServerSocket serverSocket = null; // Client ������ �ޱ� ���� ServerSocket
//	Socket socket = null; // ������ Client�� ����ϱ� ���� Socket
//	Map<String, PrintWriter> clientMap;
//	Map<String, PrintWriter> clientMap2;
//
//	// ������
//	public ChatMultiServer() {
//		// Ŭ���̾�Ʈ�� ��½�Ʈ���� ������ �ؽ��� ����.
//		clientMap = new HashMap<String, PrintWriter>();
//
//		// �游��� �ޱ����ؼ� �����Ѱ�
//		clientMap2 = new HashMap<String, PrintWriter>();
//
//		// �ؽ��� ����ȭ ����
//		Collections.synchronizedMap(clientMap);
//
//		// �游��� �ޱ����ؼ� �����Ѱ�
//		Collections.synchronizedMap(clientMap2);
//	}
//
//	public void init() {
//		try {
//			// ���� ���� ��ü ����
//			serverSocket = new ServerSocket(9999); // 9999��Ʈ�� �������� ��ü ����
//			System.out.println("������ ���۵Ǿ����ϴ�.");
//
//			while (true) {
//
//				socket = serverSocket.accept();
//				System.out.println(socket.getInetAddress() + ":" + socket.getPort());
//
//				Thread msr = new MultiServerT(socket); // ������ ����
//				msr.start(); // ������ �õ�.
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	// public synchronized void RemoveClient(String name) //ä�ù� ����� ���� �� ä�ù濡 �����ϴ�
//	// Client���� ���� �ҽ��� �˸�
//	// {
//	// try {
//	// clientmap.remove(name);
//	// sendMsg(name + " �����ϼ̽��ϴ�.", "Server");
//	// }catch(Exception e) {}
//	// }
//	// ä�ù� ���� �̰ɷ� �����Ҽ�����������?
//
//	// �濡 �ִ� ��� Ŭ���̾��Ʋ���� �޽����� ����.
//	public void sendSomeMsg(String msg) {
//
//		// ��½�Ʈ���� ���������� ���ͼ� �ش� �޽����� ����Ѵ�.
//		Iterator it = clientMap2.keySet().iterator();
//
//		while (it.hasNext()) {
//			try {
//				PrintWriter it_out = (PrintWriter) clientMap2.get(it.next());
//				it_out.println(msg);
//
//			} catch (Exception e) {
//				System.out.println("����" + e);
//			}
//		}
//	}
//
//	public void sendAllMsg(String msg) {
//
//		// ��½�Ʈ���� ���������� ���ͼ� �ش� �޽����� ����Ѵ�.
//		Iterator it = clientMap.keySet().iterator();
//
//		while (it.hasNext()) {
//			try {
//				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
//				it_out.println(msg);
//
//			} catch (Exception e) {
//				System.out.println("����" + e);
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		// ������ü ����
//		ChatMultiServer ms = new ChatMultiServer();
//		ms.init();
//	}
//
//	/////////////
//	// ���� Ŭ���� //
//	// Ŭ���̾�Ʈ�κ��� �о�� �޽����� �ٸ� Ŭ���̾�Ʈ(socket)�� ������ ������ �ϴ� �޼���
//
//	class MultiServerT extends Thread {
//		Socket socket;
//		PrintWriter out = null;
//		BufferedReader in = null;
//		String name = "";
//
//		// ������
//		public MultiServerT(Socket socket) {
//			this.socket = socket;
//			try {
//				out = new PrintWriter(this.socket.getOutputStream(), true);
//				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//			} catch (Exception e) {
//				System.out.println("����:" + e);
//			}
//		}
//
//		// ������ list Ȯ��
//		public void ShowName(String name) {
//			Set<String> set = clientMap.keySet();
//			PrintWriter pr = (PrintWriter) clientMap.get(name);
//
//			pr.println("����� ����Ʈ [" + set + "]");
//		}
//
//		// �游�� �� ����Ʈ ���� (�ϴ��� ���ϳ��� �����ϴ� �����Ͽ�)
//		public void ShowName2(String name) {
//			Set<String> set = clientMap2.keySet();
//			PrintWriter pr = (PrintWriter) clientMap2.get(name);
//
//			pr.println("����� ����Ʈ [" + set + "]");
//		}
//
//		// �ӼӸ�
//		public void ShowTalk(String s, String name) {
//
//			System.out.println("�ӼӸ�����!!!!!!");
//
//			StringTokenizer t1 = new StringTokenizer(s);
//
//			t1.nextToken();
//
//			String strTmp = t1.nextToken();
//
//			int nTmp2 = s.indexOf(" ");
//			String strTmp2 = s.substring(nTmp2 + 1);
//			nTmp2 = strTmp2.indexOf(" ");
//			strTmp2 = strTmp2.substring(nTmp2 + 1);
//
//			PrintWriter pr = (PrintWriter) clientMap.get(strTmp);
//			pr.println("==>"+"["+name+"]"+ "���� �ӼӸ� :" + strTmp2 );
//		}
//
//		// �ӼӸ� ����
//		public void ShowOnlyTalk(String s, String name) {
//
//			String msg = "";
//
//			System.out.println("�ӼӸ���������!!!!!!");
//
//			StringTokenizer t1 = new StringTokenizer(s);
//			t1.nextToken();
//			String strTmp = t1.nextToken();
//			System.out.println(strTmp);
//
//			while (true) {
//				try {
//					msg = in.readLine();
//					StringTokenizer t2 = new StringTokenizer(msg);
//					System.out.println(msg);
//					PrintWriter pr = (PrintWriter) clientMap.get(strTmp);
//					String strTmp2 = t2.nextToken();
//					if (msg.equals(name + "=>" + "/bye")) {
//						pr.println("[�ӼӸ� ����]");
//						break;
//					}
//					pr.println("==>"+"["+name+"]"+ "���� �ӼӸ� : " + strTmp2);
//					
//					
//				} catch (Exception e) {
//
//				}
//			}
//		}
//
//		//// ��������Ʈ => DB���� ã�Ҵµ� �ٽ� ������ �ε�ε�
//		// public void BanPerson(String name) {
//		// ////////////////
//		// // ��������Ʈ Ȯ��//
//		// ////////////////
//		// Connection con = null;
//		// PreparedStatement pstmt = null;
//		// ResultSet rs = null;
//		//
//		// try {
//		// try {
//		//// String s = "";
//		// con = DriverManager.getConnection(
//		// "jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe",
//		// "scott", "tiger");
//		//
//		// String sql = "select * from Ban";
//		// pstmt = con.prepareStatement(sql);
//		// rs = pstmt.executeQuery();
//		//
//		// while (rs.next()) {
//		// if (rs.getString(1).equals(name)) {
//		// out.println(name + "�� ��������Ʈ �Դϴ�. ���ο� ���̵� �����آa");
//		// name = in.readLine();
//		// }
//		// }
//		// } catch (SQLException sqle) {
//		// sqle.printStackTrace();
//		// } finally {
//		// try {
//		// if (rs != null)
//		// rs.close();
//		// if (pstmt != null)
//		// pstmt.close();
//		// if (con != null)
//		// con.close();
//		// } catch (Exception e) {
//		// }
//		// }
//		// } catch (Exception e) {
//		// }
//		// }
//
//		// // �ߺ��̸� Ȯ�� => DB���� ã�Ҵµ� �ٽ� ������ �ε�ε�
//		// public void OverlapName(String name) {
//		// //////////////
//		// // �ߺ��̸�üũ//
//		// //////////////
//		// Connection con = null;
//		// PreparedStatement pstmt = null;
//		// ResultSet rs = null;
//		//
//		// try {
//		// try {
//		// String s = "";
//		// con = DriverManager.getConnection(
//		// "jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe",
//		// "scott", "tiger");
//		//
//		// String sql = "select * from CHAT";
//		// pstmt = con.prepareStatement(sql);
//		// rs = pstmt.executeQuery();
//		// int a = 0;
//		//
//		// while (true) {
//		//
//		// while (rs.next()) {
//		// if (name.equals(rs.getString(1))) {
//		// out.println(name + "���� ID �Դϴ�. ���ο� ���̵� �����آa");
//		// name = in.readLine();
//		// a = 2;
//		// } else {
//		// a = 0;
//		// break;
//		// }
//		// }
//		// sql = "select * from CHAT";
//		// pstmt = con.prepareStatement(sql);
//		// rs = pstmt.executeQuery();
//		// if (a == 0) {
//		// break;
//		// }
//		// }
//		// } catch (SQLException sqle) {
//		// sqle.printStackTrace();
//		// } finally {
//		// try {
//		// if (rs != null)
//		// rs.close();
//		// if (pstmt != null)
//		// pstmt.close();
//		// if (con != null)
//		// con.close();
//		// } catch (Exception e) {
//		// }
//		// }
//		// } catch (Exception e) {
//		// }
//		// }
//
//		// ��ȭ��� ���� ���� ������
//		public void BlockPerson(String s, String name) {
//
//			int nTmp2 = s.indexOf(" ");
//			String strbp = s.substring(nTmp2);
//			nTmp2 = strbp.indexOf(" ");
//			strbp = strbp.substring(nTmp2 + 1, nTmp2 + 2);
//
//			PrintWriter pr = (PrintWriter) clientMap.get(strbp);
//			pr.println(name + "�Կ� ���� �� ���ܴ���");
//
//		}
//
//		public void BulletinBoard(String s, String name) {
//
//			// StringTokenizer t1 = new StringTokenizer(s);
//			//
//			// t1.nextToken();
//			//
//			// String strTmp = t1.nextToken();
//
//			int nTmp = s.indexOf(" ");
//			String msg = s.substring(nTmp + 1);
//			// nTmp = msg.indexOf(" ");
//			// msg = msg.substring(nTmp + 1);
//
//			Iterator it = clientMap.keySet().iterator();
//			Iterator it2 = clientMap2.keySet().iterator();
//
//			while (it.hasNext()) {
//				try {
//					PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
//					it_out.println(msg);
//
//					PrintWriter it_out2 = (PrintWriter) clientMap2.get(it2.next());
//					it_out2.println(msg);
//
//				} catch (Exception e) {
//					System.out.println("����" + e);
//				}
//			}
//		}
//
//		// ���ο� �� �����(������), (�������)
//		public void Room(String name) {
//
//			String pr = "";
//			String num = "";
//			
//			out.println("����(open)/����� ����(password)");
//			try {
//				pr = in.readLine();
//				if (pr.equals(name + "=>" + "password")) {
//					PasswordRoom(name);
//				}
//				try {
//					
//					out.println("�������� �Է��ϼ���.");
//					pr = in.readLine();
//					
//					out.println("���ȣ�� �Է��ϼ���.");
//					num = in.readLine();
//					
//					int nTmp = num.lastIndexOf("");
//					String number = num.substring(nTmp - 1);
//					
//					Connection con = null;
//					PreparedStatement pstmt = null;
//					ResultSet rs = null;
//
//					clientMap.remove(name);
//					clientMap2.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
//
//					try {
//						con = DriverManager.getConnection(
//								"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe",
//								"scott", "tiger");
//
//						System.out.println("�� ���������!!!!");
//						out.println(pr + "���� ��������ϴ�!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//						
//						String sql = "insert into Room values(?, ?, ?)";
//						pstmt = con.prepareStatement(sql);
//						pstmt.setString(1, pr);
//						pstmt.setString(2, name);
//						pstmt.setString(3, number);
//						int updateCount = pstmt.executeUpdate();
//
//						String s = "";
//
//						try {
//							// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
//							while (in != null) {
//
//								s = in.readLine();
//								System.out.println(s);
//
//								if (s.equals(name + "=>" + "/exit")) {
//									OutRoom(name);
//								}
//								if (s.equals(name + "=>" + "/list")) {
//									ShowName(name);
//								}
//								if (s.equals(name + "=>" + "//list")) {
//									ShowName2(name);
//								}
//								if (s.equals("q") || s.equals("Q")) {
//									break;
//								}
//								if (s.indexOf("/tap") >= 0) {
//									ShowTalk(s, name);
//								}
//								if (s.indexOf("/block") >= 0) {
//									BlockPerson(s, name);
//								} else {
//									sendSomeMsg(s);
//								}
//							}
//							// System.out.println("Bye...");
//
//						} catch (Exception e) {
//							System.out.println("����:" + e);
//						}
//
//					} catch (SQLException sqle) {
//						sqle.printStackTrace();
//					} finally {
//						try {
//							if (pstmt != null)
//								pstmt.close();
//							if (con != null)
//								con.close();
//							if (rs != null)
//								rs.close();
//						} catch (SQLException sqle) {
//						}
//					}
//				} catch (Exception e) {
//					System.out.println("����:" + e);
//				}
//			} catch (Exception e) {
//				System.out.println("����:" + e);
//			}
//		}
//
//		// �� ������
//		public void OutRoom(String name) {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			clientMap2.remove(name);
//			clientMap.put(name, out);
//
//			// StringTokenizer t1 = new StringTokenizer(msg);
//			// t1.nextToken();
//			// String roomname = t1.nextToken();
//
//			System.out.println(name + "���� �濡�� �����̽��ϴ�.");
//			sendSomeMsg(name + "���� �����ϼ̽��ϴ�.");
//			System.out.println("���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");
//
//			try {
//				con = DriverManager.getConnection(
//						"jdbc:oracle:thin:@ec2-52-79-250-121.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
//						"tiger");
//				String sql = "delete from Room where id = ? ";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, name);
//				pstmt.executeUpdate();
//
//				// ----------------------------------------------------------------
//				sql = "insert into CHAT values(?)";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, name);
//				// pstmt.setString(2, "1111");
//				pstmt.executeUpdate();
//
//			} catch (SQLException sqle) {
//				System.out.println("6");
//				sqle.printStackTrace();
//			} finally {
//				try {
//					if (rs != null)
//						rs.close();
//					if (pstmt != null)
//						pstmt.close();
//					if (con != null)
//						con.close();
//				} catch (SQLException sqle) {
//				}
//			}
//		}
//
//		// �������
//		public void PasswordRoom(String name) {
//
//			out.println("��й�ȣ�� �Է��Ͻÿ�.");
//			String pw = "";
//			try {
//				pw = in.readLine();
//
//				Connection con = null;
//				PreparedStatement pstmt = null;
//				ResultSet rs = null;
//
//				clientMap.remove(name);
//				clientMap2.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
//
//				try {
//					con = DriverManager.getConnection(
//							"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe",
//							"scott", "tiger");
//
//					// ���̺� ����
//					String sql = "create table Room(id varchar2(10)" + "password varchar2(10))";
//
//					// DB�� ������Ʈ�ϱ� ���� �ڵ�
//					pstmt = con.prepareStatement(sql);
//					int updateCount = pstmt.executeUpdate();
//					System.out.println("�� ���������!!!!");
//					out.println("�� ���������!!!!");
//
//					sql = "insert into Room values(?, ?)";
//					pstmt = con.prepareStatement(sql);
//					pstmt.setString(1, name);
//					pstmt.setString(2, pw);
//					updateCount = pstmt.executeUpdate();
//
//					String s = "";
//
//					try {
//						// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
//						while (in != null) {
//
//							s = in.readLine();
//							System.out.println(s);
//
//							if (s.equals(name + "=>" + "/list")) {
//								ShowName(name);
//							}
//							if (s.equals(name + "=>" + "//list")) {
//								ShowName2(name);
//							}
//							if (s.equals("q") || s.equals("Q")) {
//								break;
//							}
//							if (s.indexOf("/tap") >= 0) {
//								ShowTalk(s, name);
//							}
//							if (s.indexOf("/block") >= 0) {
//								BlockPerson(s, name);
//							} else {
//								sendSomeMsg(s);
//							}
//						}
//						// System.out.println("Bye...");
//
//					} catch (Exception e) {
//						System.out.println("����:" + e);
//					} finally {
//						System.out.println("8888888888888");
//						// ���ܰ� �߻��Ҷ� ���� �ؽ��ʿ��� �ش� ������ ����.
//						// ���� �����ϰų� ������ java.net.SocketException: ���ܹ߻�
//						clientMap.put(name, out); // ���� �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
//						clientMap2.remove(name);
//						sendSomeMsg(name + "���� �����ϼ̽��ϴ�.");
//						System.out.println("���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");
//
//						try {
//							in.close();
//							out.close();
//
//							socket.close();
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//
//				} catch (SQLException sqle) {
//					sqle.printStackTrace();
//				} finally {
//					try {
//						if (pstmt != null)
//							pstmt.close();
//						if (con != null)
//							con.close();
//						if (rs != null)
//							rs.close();
//					} catch (Exception e) {
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		// �濡 �����ؼ�~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		public void JoinRoom(String name) {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			clientMap.remove(name);
//
//			clientMap2.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
//
//			try {
//				con = DriverManager.getConnection(
//						"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
//						"tiger");
//
//				// ---------------------------------------------------
//				String sql = "insert into Room values(?)";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, name);
//				int updateCount = pstmt.executeUpdate();
//
//				// ---------------------------------------------------
//
//				Iterator it = clientMap2.keySet().iterator();
//
//				while (it.hasNext()) {
//					try {
//						PrintWriter it_out = (PrintWriter) clientMap2.get(it.next());
//						it_out.println(name + "���� �濡 ���Խ��ϴ�.");
//
//					} catch (Exception e) {
//						System.out.println("����" + e);
//					}
//				}
//
//				System.out.println("���� ���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");
//
//				String s = "";
//
//				try {
//					// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
//					while (in != null) {
//
//						s = in.readLine();
//						System.out.println(s);
//
//						if (s.equals(name + "=>" + "/list")) {
//							ShowName(name);
//							System.out.println("111122222222222222222222222211");
//						}
//						if (s.equals(name + "=>" + "//list")) {
//							ShowName2(name);
//						}
//						if (s.equals("q") || s.equals("Q")) {
//							break;
//						}
//						if (s.indexOf("/tap") >= 0) {
//							ShowTalk(s, name);
//						}
//						if (s.indexOf("/block") >= 0) {
//							BlockPerson(s, name);
//						} else {
//							sendSomeMsg(s);
//						}
//					}
//					// System.out.println("Bye...");
//
//				} catch (Exception e) {
//					System.out.println("����:" + e);
//				} finally {
//					System.out.println("8888888888888");
//					// ���ܰ� �߻��Ҷ� ���� �ؽ��ʿ��� �ش� ������ ����.
//					// ���� �����ϰų� ������ java.net.SocketException: ���ܹ߻�
//					clientMap.put(name, out); // ���� �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
//					clientMap2.remove(name);
//					sendSomeMsg(name + "���� �����ϼ̽��ϴ�.");
//					System.out.println("���� ������ ���� " + clientMap2.size() + "�� �Դϴ�.");
//
//					try {
//						in.close();
//						out.close();
//
//						socket.close();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//
//				// sql = "select * from CHAT";
//				// pstmt = con.prepareStatement(sql);
//				// rs = pstmt.executeQuery();
//				// while (rs.next()) {
//				// System.out.print("id : " + rs.getString(1));
//				// System.out.println(", password : " + rs.getString(2));
//				// }
//
//				// sql = "delete Ban where id = ?";
//				// pstmt = con.prepareStatement(sql);
//				// pstmt.setString(1, name);
//				// int up = pstmt.executeUpdate();
//				//
//				// name = in.readLine();
//
//				// ----------------------------------------------------
//				// sql = "drop table CHAT";
//				// pstmt = con.prepareStatement(sql);
//				// updateCount = pstmt.executeUpdate();
//				// System.out.println("dropCount : " + updateCount);
//
//				// ----------------------------------------------------
//
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
//
//		// �����带 ����ϱ� ���ؼ� run()�޼��� ������
//		@Override
//		public void run() {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			String name = "";
//
//			try {
//				// Ŭ���̾�Ʈ���� ó������ ������ �޽�����
//				// Ŭ���̾�Ʈ�� ����� �̸��̴�.
//				name = in.readLine();
//
//				// BanPerson(name); // ��������Ʈ üũ
//				con = ConnectionPool.getConnection();
//				// con = DriverManager.getConnection(
//				// "jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe",
//				// "scott",
//				// "tiger");
//
//				String sql = "insert into CHAT values(?)";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(2, name);
//				int updateCount = pstmt.executeUpdate();
//
////				sql = "select * from CHAT";
////				pstmt = con.prepareStatement(sql);
////				rs = pstmt.executeQuery();
////				// out.println(rs.next());
////				
////				int a = 1;
////				while (true) {
////					rs = pstmt.executeQuery("select * from chat");
////					while (rs.next()) {
////						String plyer = rs.getString("plyer");
////						if (name.equals(plyer)) {
////							out.println("���̵� �ߺ��̴� �ٽ� �Է��ϼ���.");
////							name = in.readLine();
////							a = 2;
////						} else
////							a = 1;
////					}
////					if (a == 1)
////						break;
////				}
//
//				
//				clientMap.put(name, out); // �ؽ��ʿ� Ű�� name���� ��½�Ʈ�� ��ü�� ����.
//
//				sendAllMsg(name + "���� �����ϼ̽��ϴ�."); // ���� ��ü�� ������ �ִ� ������ �����ϰ� �ٸ� ����(Ŭ���̾�Ʈ)�鿡�� ������ �˸�.
//
//				System.out.println("���� ������ ���� " + clientMap.size() + "�� �Դϴ�.");
//
//				// �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
//
//				String s = "";
//				while (in != null) {
//
//					s = in.readLine();
//					System.out.println(s);
//
//					if (s.equals("[" + name + "]" + " " + ":" + " " + "/room")) {
//						Room(name);
//					} else if (s.equals("[" + name + "]" + " " + ":" + " " + "/join")) {
//						JoinRoom(name);
//					} else if (s.equals("[" + name + "]" + " " + ":" + " " + "/list")) {
//						ShowName(name);
//					} else if (s.equals("q") || s.equals("Q")) {
//						break;
//					} else if (s.indexOf("/tap") >= 0) {
//						ShowTalk(s, name);
//					} else if (s.indexOf("/Tap") >= 0) {
//						ShowOnlyTalk(s, name);
//					} else if (s.indexOf("/board") >= 0) {
//						BulletinBoard(s, name);
//					}
//					// else if (s.indexOf("/block") >= 0) {
//					// BlockPerson(s, name);
//					// }
//					else {
//						System.out.println("11111111111111111111111");
//						sendAllMsg(s);
//					}
//				}
//				// System.out.println("Bye...");
//
//			} catch (Exception e) {
//				System.out.println("����:" + e);
//			} finally {
//				System.out.println("7777777777777");
//				// ���ܰ� �߻��Ҷ� ���� �ؽ��ʿ��� �ش� ������ ����.
//				// ���� �����ϰų� ������ java.net.SocketException: ���ܹ߻�
//				clientMap.remove(name);
//				sendAllMsg(name + "���� �����ϼ̽��ϴ�.");
//				System.out.println("���� ������ ���� " + clientMap.size() + "�� �Դϴ�.");
//
//				try {
//					in.close();
//					out.close();
//
//					socket.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//}