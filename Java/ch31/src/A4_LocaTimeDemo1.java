/*
 * 2�ð� 10�� �� �? : LocalTime Ŭ����
 * LocalDate�� ��¥ ����, LocalTime�� �ð� ������ ��Ÿ���� Ŭ����������
 */

import java.time.LocalTime;

public class A4_LocaTimeDemo1 {

	public static void main(String[] args) {
		// ���� �ð�
		LocalTime now = LocalTime.now();
		System.out.println("���� �ð�: " + now);
		
		//  2�ð� 10�� �� ȭ�� ���� ����
		LocalTime mt = now.plusHours(2);
		mt = mt.plusMinutes(10);
		
		// ȭ�� ���� �ð�
		System.out.println("ȭ�� ���� �ð�: " + mt);
	}
}