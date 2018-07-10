/*
 * ������ �Է� �� ����� ��(����Ʈ ����)
 * ���� open, close ���� ����
 * ������ ���� �� �迭�� �غ��� �� �ʿ䰡 ����
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class A4_SimpleBinWriteRead {

	public static void main(String[] args) throws IOException {
		Path fp = Paths.get("D:\\sky794373\\study\\simple.bin");
		
		// ���� ����, ������ �����ϸ� ���� �߻�
		fp = Files.createFile(fp);
		
		byte buf1[] = {0x13, 0x14, 0x15};	// ���Ͽ� �� ������
		for(byte b : buf1)	// ������ �������� ����� ���� �ݺ���
			System.out.print(b + "\t");
		System.out.println();
		
		//���Ͽ� ������ ����
		Files.write(fp, buf1, StandardOpenOption.APPEND);
		
		// ���Ϸκ��� ������ �б�
		byte buf2[] = Files.readAllBytes(fp);
		
		for(byte b : buf2)	// �̾� ���� �������� ����� ���� �ݺ���
			System.out.print(b + "\t");
		System.out.println();
	}

}
