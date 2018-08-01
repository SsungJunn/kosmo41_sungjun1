//
///*
// * 콘솔 멀티채팅 클라이언트 프로그램
// */
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class testclient {
//
//	static {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) throws UnknownHostException, IOException {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		PrintWriter out = null;
//
//		Scanner s = new Scanner(System.in);
//
//		try {
//			con = DriverManager.getConnection(
//					"jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
//					"tiger");
//
//			int a = 1;
//
//			String s_name = "";
//			System.out.println("이름을 입력해 주세요.");
//			s_name = s.nextLine();
//
//			try {
//				String ServerIP = "192.168.0.105";
//				// String ServerIP = args[0];
//				Socket socket = new Socket(ServerIP, 9999); // 소켓 객체 생성
//				System.out.println("서버와 연결이 되었습니다.......");
//
//				while (a == 1) {
//
//					try {
//						String sql = "select * from chat";
//						pstmt = con.prepareStatement(sql);
//						rs = pstmt.executeQuery();
//						while (rs.next()) {
//							String plyer = rs.getString("id");
//							if (s_name.equals(plyer)) {
//								System.out.println("아이디 중복이니 다시 입력하세요.");
//								a = 1;
//							} else {
//								a = 2;
//								break;
//							}
//						}
//						if (a == 2) {
//							break;
//						}
//						// 서버에서 보내는 메시지를 사용자의 콘솔에 출력하는 쓰레드.
//						Thread receiver = new ChatReceiver(socket);
//						receiver.start();
//
//						Thread sender = new ChatSender(socket, s_name);
//						sender.start();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			} catch (Exception e) {
//				System.out.println("예외[MultiClient class]:" + e);
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} finally {
//			try {
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//				if (rs != null)
//					rs.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//}