/*
 * ������ ��ĥ����??? : Local Ŭ����
 * LocalDate�� �ð� ������ ������ '��¥����'�� ǥ���ϱ� ���� Ŭ����
 */

import java.time.LocalDate;

public class A2_LocalDateDemo1 {

	public static void main(String[] args) {
		// ����
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today);
		
		// �� ���� ũ��������
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas: " + xmas);
		
		// �� ���� ũ�������� �̺�
		//LocalDate eve = xmas.minusDays(1);
		LocalDate eve = xmas.minusWeeks(1);
		System.out.println("Xmas Eve: " + eve);
		
	}

}
