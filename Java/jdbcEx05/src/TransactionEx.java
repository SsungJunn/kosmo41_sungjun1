import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionEx {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;		
		
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			
//			con.setAutoCommit(false);
			
			//----------------------------------------------------
			String sql = "insert into test3 values('홍길동', '1111')";
			
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			System.out.println("11111");
			
			sql = "insert into test3 values('전우치', '2222')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			System.out.println("22222");
			
			sql = "insert into test3 values('손오공', '3333'";
			//에러유도
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			System.out.println("33333");
			
			success = true;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if(success) {
					System.out.println("44444");
					con.commit();
				} else {
					System.out.println("55555");
					con.rollback();
				}
				
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException sqle) {}
		}
	}
}
