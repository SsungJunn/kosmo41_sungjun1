import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String a = "파이팅";
		String name = "성준";
		int num2 = 1;
		try {
			con = ConnectionPool.getConnection();
//			String sql = "create table test2(id varchar(10), " + 
//					     "			   password varchar(10))";
//
//			pstmt = con.prepareStatement(sql);
//			int updateCount = pstmt.executeUpdate();
//			System.out.println("createCount : " + updateCount);

			// ---------------------------------------------------
			String sql = "insert into MakeRoom values('" + a + "', '" + name + "', " + num2 + ")";
			// String sql = "insert into MakeRoom values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			// pstmt.setString(1, pr);
			// pstmt.setString(2, name);
			// pstmt.setInt(3, num2);
			int updateCount = pstmt.executeUpdate();

			sql = "insert into RoomList values(?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a);
			updateCount = pstmt.executeUpdate();

			// ---------------------------------------------------
//			String s = "야호";
//			String sql = "select * from MakeRoom";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				if(s.equals(rs.getString(2)))
//				{
//					sql = "insert into MakeRoom values(?, ?, ?)";
//					pstmt = con.prepareStatement(sql);
//					pstmt.setString(1, "야호");
//					pstmt.setString(2, "성준");
//					pstmt.setString(3, null);
//					
//					
////					int updateCount = pstmt.executeUpdate();
//				}
//			}

			// ----------------------------------------------------
//			sql = "drop table test2";
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
}