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
//	ServerSocket serverSocket = null; // Client 접속을 받기 위한 ServerSocket
//	Socket socket = null; // 접속한 Client와 통신하기 위한 Socket
//	Map<String, PrintWriter> clientMap;
//	Map<String, PrintWriter> clientMap2;
//
//	// 생성자
//	public ChatMultiServer() {
//		// 클라이언트의 출력스트림을 저장할 해쉬맵 생성.
//		clientMap = new HashMap<String, PrintWriter>();
//
//		// 방만들고 받기위해서 수정한거
//		clientMap2 = new HashMap<String, PrintWriter>();
//
//		// 해쉬맵 동기화 설정
//		Collections.synchronizedMap(clientMap);
//
//		// 방만들고 받기위해서 수정한거
//		Collections.synchronizedMap(clientMap2);
//	}
//
//	public void init() {
//		try {
//			// 서버 소켓 객체 생성
//			serverSocket = new ServerSocket(9999); // 9999포트로 서버소켓 객체 생성
//			System.out.println("서버가 시작되었습니다.");
//
//			while (true) {
//
//				socket = serverSocket.accept();
//				System.out.println(socket.getInetAddress() + ":" + socket.getPort());
//
//				Thread msr = new MultiServerT(socket); // 쓰레드 생성
//				msr.start(); // 쓰레드 시동.
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
//	// public synchronized void RemoveClient(String name) //채팅방 사용자 제거 및 채팅방에 존재하는
//	// Client에게 퇴장 소식을 알림
//	// {
//	// try {
//	// clientmap.remove(name);
//	// sendMsg(name + " 퇴장하셨습니다.", "Server");
//	// }catch(Exception e) {}
//	// }
//	// 채팅방 퇴장 이걸로 강퇴할수있지않을까?
//
//	// 방에 있는 모든 클라이언드틀에게 메시지를 전달.
//	public void sendSomeMsg(String msg) {
//
//		// 출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
//		Iterator it = clientMap2.keySet().iterator();
//
//		while (it.hasNext()) {
//			try {
//				PrintWriter it_out = (PrintWriter) clientMap2.get(it.next());
//				it_out.println(msg);
//
//			} catch (Exception e) {
//				System.out.println("예외" + e);
//			}
//		}
//	}
//
//	public void sendAllMsg(String msg) {
//
//		// 출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
//		Iterator it = clientMap.keySet().iterator();
//
//		while (it.hasNext()) {
//			try {
//				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
//				it_out.println(msg);
//
//			} catch (Exception e) {
//				System.out.println("예외" + e);
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		// 서버객체 생성
//		ChatMultiServer ms = new ChatMultiServer();
//		ms.init();
//	}
//
//	/////////////
//	// 내부 클래스 //
//	// 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서드
//
//	class MultiServerT extends Thread {
//		Socket socket;
//		PrintWriter out = null;
//		BufferedReader in = null;
//		String name = "";
//
//		// 생성자
//		public MultiServerT(Socket socket) {
//			this.socket = socket;
//			try {
//				out = new PrintWriter(this.socket.getOutputStream(), true);
//				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//			} catch (Exception e) {
//				System.out.println("예외:" + e);
//			}
//		}
//
//		// 접속자 list 확인
//		public void ShowName(String name) {
//			Set<String> set = clientMap.keySet();
//			PrintWriter pr = (PrintWriter) clientMap.get(name);
//
//			pr.println("사용자 리스트 [" + set + "]");
//		}
//
//		// 방만든 곳 리스트 보기 (일단은 방하나만 관리하는 조건하에)
//		public void ShowName2(String name) {
//			Set<String> set = clientMap2.keySet();
//			PrintWriter pr = (PrintWriter) clientMap2.get(name);
//
//			pr.println("사용자 리스트 [" + set + "]");
//		}
//
//		// 귓속말
//		public void ShowTalk(String s, String name) {
//
//			System.out.println("귓속말시작!!!!!!");
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
//			pr.println("==>"+"["+name+"]"+ "님의 귓속말 :" + strTmp2 );
//		}
//
//		// 귓속말 고정
//		public void ShowOnlyTalk(String s, String name) {
//
//			String msg = "";
//
//			System.out.println("귓속말고정시작!!!!!!");
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
//						pr.println("[귓속말 끊기]");
//						break;
//					}
//					pr.println("==>"+"["+name+"]"+ "님의 귓속말 : " + strTmp2);
//					
//					
//				} catch (Exception e) {
//
//				}
//			}
//		}
//
//		//// 블랙리스트 => DB에서 찾았는데 다시 못받음 부들부들
//		// public void BanPerson(String name) {
//		// ////////////////
//		// // 블랙리스트 확인//
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
//		// out.println(name + "은 블랙리스트 입니다. 새로운 아이디를 생성해줭");
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
//		// // 중복이름 확인 => DB에서 찾았는데 다시 못받음 부들부들
//		// public void OverlapName(String name) {
//		// //////////////
//		// // 중복이름체크//
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
//		// out.println(name + "동일 ID 입니다. 새로운 아이디를 생성해줭");
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
//		// 대화상대 차단 아직 안했음
//		public void BlockPerson(String s, String name) {
//
//			int nTmp2 = s.indexOf(" ");
//			String strbp = s.substring(nTmp2);
//			nTmp2 = strbp.indexOf(" ");
//			strbp = strbp.substring(nTmp2 + 1, nTmp2 + 2);
//
//			PrintWriter pr = (PrintWriter) clientMap.get(strbp);
//			pr.println(name + "님에 의해 너 차단당함");
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
//					System.out.println("예외" + e);
//				}
//			}
//		}
//
//		// 새로운 방 만들기(공개방), (비공개방)
//		public void Room(String name) {
//
//			String pr = "";
//			String num = "";
//			
//			out.println("공개(open)/비공개 설정(password)");
//			try {
//				pr = in.readLine();
//				if (pr.equals(name + "=>" + "password")) {
//					PasswordRoom(name);
//				}
//				try {
//					
//					out.println("방제목을 입력하세요.");
//					pr = in.readLine();
//					
//					out.println("방번호를 입력하세요.");
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
//					clientMap2.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
//
//					try {
//						con = DriverManager.getConnection(
//								"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe",
//								"scott", "tiger");
//
//						System.out.println("방 만들어졌음!!!!");
//						out.println(pr + "방을 만들었습니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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
//							// 입력스트림이 null이 아니면 반복.
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
//							System.out.println("예외:" + e);
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
//					System.out.println("예외:" + e);
//				}
//			} catch (Exception e) {
//				System.out.println("예외:" + e);
//			}
//		}
//
//		// 방 나가기
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
//			System.out.println(name + "님이 방에서 나가셨습니다.");
//			sendSomeMsg(name + "님이 퇴장하셨습니다.");
//			System.out.println("현재 접속자 수는 " + clientMap2.size() + "명 입니다.");
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
//		// 비공개방
//		public void PasswordRoom(String name) {
//
//			out.println("비밀번호를 입력하시오.");
//			String pw = "";
//			try {
//				pw = in.readLine();
//
//				Connection con = null;
//				PreparedStatement pstmt = null;
//				ResultSet rs = null;
//
//				clientMap.remove(name);
//				clientMap2.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
//
//				try {
//					con = DriverManager.getConnection(
//							"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe",
//							"scott", "tiger");
//
//					// 테이블 생성
//					String sql = "create table Room(id varchar2(10)" + "password varchar2(10))";
//
//					// DB에 업데이트하기 위한 코드
//					pstmt = con.prepareStatement(sql);
//					int updateCount = pstmt.executeUpdate();
//					System.out.println("방 만들어졌음!!!!");
//					out.println("방 만들어졌음!!!!");
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
//						// 입력스트림이 null이 아니면 반복.
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
//						System.out.println("예외:" + e);
//					} finally {
//						System.out.println("8888888888888");
//						// 예외가 발생할때 퇴장 해쉬맵에서 해당 데이터 제거.
//						// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
//						clientMap.put(name, out); // 대기실 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
//						clientMap2.remove(name);
//						sendSomeMsg(name + "님이 퇴장하셨습니다.");
//						System.out.println("현재 접속자 수는 " + clientMap2.size() + "명 입니다.");
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
//		// 방에 접속해서~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		public void JoinRoom(String name) {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			clientMap.remove(name);
//
//			clientMap2.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
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
//						it_out.println(name + "님이 방에 들어왔습니다.");
//
//					} catch (Exception e) {
//						System.out.println("예외" + e);
//					}
//				}
//
//				System.out.println("현재 방의 접속자 수는 " + clientMap2.size() + "명 입니다.");
//
//				String s = "";
//
//				try {
//					// 입력스트림이 null이 아니면 반복.
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
//					System.out.println("예외:" + e);
//				} finally {
//					System.out.println("8888888888888");
//					// 예외가 발생할때 퇴장 해쉬맵에서 해당 데이터 제거.
//					// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
//					clientMap.put(name, out); // 대기실 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
//					clientMap2.remove(name);
//					sendSomeMsg(name + "님이 퇴장하셨습니다.");
//					System.out.println("현재 접속자 수는 " + clientMap2.size() + "명 입니다.");
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
//		// 쓰레드를 사용하기 위해서 run()메서드 재정의
//		@Override
//		public void run() {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			String name = "";
//
//			try {
//				// 클라이언트에서 처음으로 보내는 메시지는
//				// 클라이언트가 사용할 이름이다.
//				name = in.readLine();
//
//				// BanPerson(name); // 블랙리스트 체크
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
////							out.println("아이디 중복이니 다시 입력하세요.");
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
//				clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
//
//				sendAllMsg(name + "님이 입장하셨습니다."); // 현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
//
//				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
//
//				// 입력스트림이 null이 아니면 반복.
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
//				System.out.println("예외:" + e);
//			} finally {
//				System.out.println("7777777777777");
//				// 예외가 발생할때 퇴장 해쉬맵에서 해당 데이터 제거.
//				// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
//				clientMap.remove(name);
//				sendAllMsg(name + "님이 퇴장하셨습니다.");
//				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
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