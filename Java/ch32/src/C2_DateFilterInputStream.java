import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class C2_DateFilterInputStream {

	public static void main(String[] args) {
		try (DataInputStream in = 
				new DataInputStream(new FileInputStream("data.dat"))) {
			int num1 = in.readInt();		// int�� ������ ����
			double num2 = in.readDouble();	// double�� ������ ����
			System.out.println(num1);
			System.out.println(num2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}