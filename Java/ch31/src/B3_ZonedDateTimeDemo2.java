/*
 * �ð��븦 �ݿ��� ����
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class B3_ZonedDateTimeDemo2 {

	public static void main(String[] args) {
		// �ѱ� ��� 2018-07-09 16:00
		ZonedDateTime departure = ZonedDateTime.of(
				LocalDateTime.of(2018, 7, 9, 16, 00), ZoneId.of("Asia/Seoul"));
		System.out.println("Departure : " + departure);
		
		// �ĸ� ���� 2017-07-09 19:00
		ZonedDateTime arrival = ZonedDateTime.of(
				LocalDateTime.of(2018, 7, 9, 19, 00), ZoneId.of("Europe/Paris"));
		System.out.println("Arrival : " + arrival);
		
		// ���� �ð�
		System.out.println(Duration.between(departure, arrival));
	}

}
