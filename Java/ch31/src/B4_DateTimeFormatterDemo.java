import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class B4_DateTimeFormatterDemo {

	public static void main(String[] args) {
		//ZonedDateTime date = ZonedDateTime.of(
		//LocalDateTime.of(2018, 7, 9, 16, 15), ZoneId.of("Asia/Seoul"));
		ZonedDateTime date = ZonedDateTime.now();
		
		
		// ����� ���� ������ java.time.format.DateTimeFormatter �ν��Ͻ��� ��´�.
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yy-M-d");
		DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("yyyy-MMM-dd, H:m:s");
		DateTimeFormatter fm3 = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:m:ss a VV");
		
		// LocalDate, LocalTime, LocalDateTime, ZonedDateTime�� ��� �����ϴ� format �޼ҵ� ȣ���Ѵ�.
		System.out.println(date.format(fm1));
		System.out.println(date.format(fm2));
		System.out.println(date.format(fm3));
	}

}
