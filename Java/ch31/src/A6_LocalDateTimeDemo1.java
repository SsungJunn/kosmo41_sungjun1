/*
 * �������κ��� 22�ð� 35�� ���� �ð��� ��¥��?
 * LocalDateTime Ŭ����
 */

import java.time.LocalDateTime;

public class A6_LocalDateTimeDemo1 {

	public static void main(String[] args) {
		// ���� ��¥�� �ð�
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		// ���� ���̾�� 22�ð� 35�� �� ȭ�� ���� ����
		LocalDateTime mt = dt.plusHours(22);
		mt= mt.plusMinutes(35);
		
		// ���� ���̾�� ȭ�� ���� ��¥�� �ð�
		System.out.println(mt);

	}

}
