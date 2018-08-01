import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class test2 {
   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException cnfe) {
         cnfe.printStackTrace();
      }
   }

   public static void main(String[] args) {

      Scanner s = new Scanner(System.in);
      String a = "";

      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         con = DriverManager.getConnection(
               "jdbc:oracle:thin:@ec2-13-125-189-105.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
               "tiger");
         // String sql = "create table "+a+" (id varchar(10), " +
         // " password varchar(10))";
         // pstmt = con.prepareStatement(sql);
         // int updateCount = pstmt.executeUpdate();
         //// System.out.println("createCount : " + updateCount);
         //

         // ------------------------------------------------------

         // sql = "insert into test2 values(?,?)";
         // pstmt = con.prepareStatement(sql);
         // pstmt.setString(1, "홍길동");
         // pstmt.setString(2, "1111");
         // updateCount = pstmt.executeUpdate();
         // System.out.println("inser tCount: " + updateCount);
         // //--------------------------------------------------------
         String sql = "select id from CHAT";
         pstmt = con.prepareStatement(sql);
         rs = pstmt.executeQuery();
         int count = 0;
         
         a = s.nextLine();

         while(true) {
            while (rs.next()) {
               System.out.println("2222222");
               if (a.equals(rs.getString("id"))) {
                  System.out.println("333333333");
                  count = 1;
                  do {
                     System.out.println("이름을 다시입력하세요");
                     System.out.println(rs.getString("id"));
                     a = s.nextLine();
                  } while (a.equals(rs.getString("id")));
               }else {
                  count = 2;
               }
            }
            if(count == 2) {
               break;
            }
            System.out.println(count);
            rs = pstmt.executeQuery();
            System.out.println("1111111");
         }

         // System.out.println("1111111111"+rs.getString(1));

         // //---------------------------------------------------
         //
         // sql = "drop table test2";
         // pstmt = con.prepareStatement(sql);
         // updateCount = pstmt.executeUpdate();
         // System.out.println("dropCount : " + updateCount);

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
         } catch (SQLException sqle) {
         }
      }

   }

}