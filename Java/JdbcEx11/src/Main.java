import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0; i<200; i++) {
			TestThread test = new TestThread(i);
			test.start();
		}
	}
}	