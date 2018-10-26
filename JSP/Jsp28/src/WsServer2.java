import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * sessions가 각 호출 시 마다 생성되므로 static으로 정해 줘야 한다.
 * 브라우져가 websocket을 지원 해야 한다.
 * 웹 소켓 연결 후 별도 close 동작 없이 브라우져를 닫을 경우 자동으로 OnClose가 호출 된다.
 */

@ServerEndpoint("/websocketendpoint2")
public class WsServer2 {
	
	private static final java.util.Set<Session> sessions =
			java.util.Collections.synchronizedSet(new java.util.HashSet<Session>());

	private static final java.util.Map<String, Session> clientMap =
			java.util.Collections.synchronizedMap(new java.util.HashMap<String, Session>());
	
	private static final java.util.Map<Session, String> chatMap =
			java.util.Collections.synchronizedMap(new java.util.HashMap<Session, String>());

	String toname = "";
	int namecount = 0;
	
	/**
	 * @OnOpen allows us to intercept the creation of a new session.
	 * The session class allows us to send data to the user.
	 * In the method onOpen, we'll let the user know that the handshake was
	 * successful.
	 */
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Open session id : " + session.getId());
		
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("채팅방에 입장하셨습니다.");
			
			
			} catch (IOException e) {
				e.printStackTrace();
		}
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		
		sessions.add(session);
	}
	
	private static WsServer2 instance = new WsServer2();
	
	DataSource dataSource = null;
	
	public static WsServer2 getInstance() {
		return instance;
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() +" has ended");
		sessions.remove(session);
		clientMap.remove(session);
		AllList(session);
		
	}
	
	/**
	 * When a user sends a message to the server,
	 * this method will intercept the message and allow us to react to it.
	 * For now the message is read as a String. 
	 */
	
	@OnMessage
	public void onMessage(String message, Session session) {
		StringTokenizer t1 = new StringTokenizer(message);
		
		String roomnum = t1.nextToken();
		StringTokenizer t2 = new StringTokenizer(message);
		t2.nextToken();
		String strTmp = t2.nextToken();
		
		boolean containsKey = clientMap.containsKey(strTmp);
//			try {
//				basic.sendText(message);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			System.out.println("11111");
//			sendAllSessionToMessage(session, message);
//		} 
		int count = 0;
		if(containsKey == false) {
			// 클라이언트맵에 저장
			clientMap.put(strTmp, session);
			chatMap.put(session, roomnum);
			AllList(session);
			count++;
			sendAllSessionToMessage(session, message, roomnum, count);
		} else if (message.indexOf("/tap") >= 0) {
			StringTokenizer t3 = new StringTokenizer(message);

			t3.nextToken();
			t3.nextToken();
			t3.nextToken();
			t3.nextToken();
			
			toname = t3.nextToken();
			
			for (int i = 0; i < message.length(); i++) {
				if (message.substring(i, i + 1).equals(" ")) {
					count++;
				}
			}

			if(count >= 5) {
				ShowTalk(message);
			} else if (count == 4){
				namecount++;
			}
		} else if (namecount % 2 == 1) {
			
			if(message.indexOf("/bye") >= 0)
			{
				Session pr = (Session) clientMap.get(toname);
				try {
					pr.getBasicRemote().sendText("상대방이 귓속말을 끊었습니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
				namecount--;	
			} else {
				ShowOnlyTalk(message, toname);
			}
		} else if (message.indexOf("/ban") >= 0) {
			BlockMessage(message);
		} else {
			sendAllSessionToMessage( session, message, strTmp, count );
		}
	}
	
	private void AllList(Session session) {
		String names = "";
		String key = ""; 
		try {
			Iterator <String>it = clientMap.keySet().iterator();
			
			while(it.hasNext()) {
				names += (String)it.next()+"\n";
			}
			Iterator <String>it2 = clientMap.keySet().iterator();
			
			while(it2.hasNext()) {
				key = (String)it2.next();
				session = clientMap.get(key);
				session.getBasicRemote().sendText("/Alllist" + ":" + names);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 모든 사용자에게 메시지를 전달한다. 
	 */
	private void sendAllSessionToMessage(Session self, String message, String roomnum, int count) {

		if (count == 1) {
			StringTokenizer t1 = new StringTokenizer(message);
			t1.nextToken();
			String user = t1.nextToken();

			try {
				for (Session session : WsServer2.sessions) {
					if (chatMap.get(session).equals(roomnum)) {
						if (!self.getId().equals(session.getId()))
							session.getBasicRemote().sendText(user + "님이 입장하셨습니다.");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			count--;
		} else {

			StringTokenizer t1 = new StringTokenizer(message);
			t1.nextToken();
			String user = t1.nextToken();

			StringTokenizer t2 = new StringTokenizer(message);
		
			String nRoom = t2.nextToken();

			int nTmp = message.indexOf(" ");
			String msg = message.substring(nTmp + 1);
			nTmp = msg.indexOf(" ");
			msg = msg.substring(nTmp + 1);

			nTmp = msg.indexOf(" ");
			msg = msg.substring(nTmp + 1);

			if (msg.contains("빵꾸똥꾸") || msg.contains("바보") || msg.contains("김현승")) {
				System.out.println("금칙어사용!!");
				return;

			} else {
//				String Ban = "";
//				Connection con = null;
//				PreparedStatement pstmt = null;
//				ResultSet resultSet = null;

//				try {
//					con = dataSource.getConnection();
//					String query = "select * from Banword";
//					pstmt = con.prepareStatement(query);
//					resultSet = pstmt.executeQuery();
//
//					while (resultSet.next()) {
//						Ban = resultSet.getString("BAN");
//						System.out.println(Ban);
//					}
//					if (msg.contains(Ban)) {
//						System.out.println("개인금칙어 사용");
//					} else {
//						
						try {
							for (Session session : WsServer2.sessions) {
								if (chatMap.get(session).equals(nRoom)) {
									if (!self.getId().equals(session.getId()))
										session.getBasicRemote().sendText(user + " : " + msg);
								}
							}
						} catch (IOException e) {
							e.printStackTrace();

						}
//
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					try {
//						if (pstmt != null)
//							pstmt.close();
//						if (con != null)
//							con.close();
//					} catch (Exception e2) {
//						e2.printStackTrace();
//					}
//				}
			}
		}
	}

	@OnError
	public void onError(Throwable e, Session session) {
		e.printStackTrace();
	}
	
	// 귓속말
	public void ShowTalk(String message) {
		
		System.out.println("귓속말시작!!!!!!");

		StringTokenizer t1 = new StringTokenizer(message);
		t1.nextToken();
		String strTmp = t1.nextToken();
				
		StringTokenizer t2 = new StringTokenizer(message);

		t2.nextToken();
		t2.nextToken();
		t2.nextToken();
		t2.nextToken();
		
		String strTmp2 = t2.nextToken();

		int nTmp = message.indexOf(" ");
		String msg = message.substring(nTmp + 1);
		nTmp = msg.indexOf(" ");
		msg = msg.substring(nTmp + 1);
		nTmp = msg.indexOf(" ");
		msg = msg.substring(nTmp + 1);
		nTmp = msg.indexOf(" ");
		msg = msg.substring(nTmp + 1);
		nTmp = msg.indexOf(" ");
		msg = msg.substring(nTmp + 1);
		nTmp = msg.indexOf(" ");

		Session pr = (Session) clientMap.get(strTmp2);
		try {
			pr.getBasicRemote().sendText("[" + strTmp + "]" + "님의 귓속말 : " + msg);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	// 귓속말 고정
	public void ShowOnlyTalk(String message, String toname) {
		System.out.println("귓속말 고정임!");
		
		StringTokenizer t1 = new StringTokenizer(message);
		t1.nextToken();
		String user1 = t1.nextToken();

		int nTmp = message.indexOf(" ");
		String msg = message.substring(nTmp + 1);
		nTmp = msg.indexOf(" ");
		msg = msg.substring(nTmp + 1);
		nTmp = msg.indexOf(" ");
		msg = msg.substring(nTmp + 1);
		nTmp = msg.indexOf(" ");

		Session pr = (Session) clientMap.get(toname);

		try {
			pr.getBasicRemote().sendText("[" + user1 + "]" + "님의 귓속말 : " + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 개인 추가 금칙어
	public void BlockMessage(String message) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		String RBoss = "";
		
		StringTokenizer t1 = new StringTokenizer(message);
		String rnum = t1.nextToken();
		
		StringTokenizer t2 = new StringTokenizer(message);
		t2.nextToken();
		String rid = t2.nextToken();
		
		StringTokenizer t3 = new StringTokenizer(message);
		t3.nextToken();
		t3.nextToken();
		t3.nextToken();
		t3.nextToken();
		String msg = t3.nextToken();

		try {
			con = dataSource.getConnection();
			
			String query = "select * from roomboard where RNum = ? and RBoss = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rnum);
			pstmt.setString(2, rid);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				String Rnum = resultSet.getString("RNum");
				RBoss = resultSet.getString("RBoss");
			}
			if(rid.equals(RBoss)) {
				String sql = "insert into Banword values(?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, msg);
				int updateCount = pstmt.executeUpdate();
				System.out.println("금지어 등록");
			} else {
				System.out.println("방장이 아닙니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
	


