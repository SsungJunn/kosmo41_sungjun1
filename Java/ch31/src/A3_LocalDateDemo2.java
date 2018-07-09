/*
 *  ��¥�� ���� ǥ���ϱ� ���� PeriodŬ����
 */

import java.time.LocalDate;
import java.time.Period;

public class A3_LocalDateDemo2 {

	public static void main(String[] args) {
		// ����
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today);
		
		// �� ���� ũ���� ����
		LocalDate xmas = LocalDate.of(today.getDayOfYear(), 12, 25);
		System.out.println("Xmas: " + xmas);
		
		// ũ������������ ������ ��ĥ?
		Period left = Period.between(today, xmas);
		System.out.println("Xmas���� ������ " + 
		left.getMonths() + "���� " + left.getDays() + "��");
	}
}