/*
 *  날짜의 차를 표현하기 위한 Period클래스
 */

import java.time.LocalDate;
import java.time.Period;

public class A3_LocalDateDemo2 {

	public static void main(String[] args) {
		// 오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today);
		
		// 올 해의 크리스 마스
		LocalDate xmas = LocalDate.of(today.getDayOfYear(), 12, 25);
		System.out.println("Xmas: " + xmas);
		
		// 크리스마스까지 앞으로 며칠?
		Period left = Period.between(today, xmas);
		System.out.println("Xmas까지 앞으로 " + 
		left.getMonths() + "개월 " + left.getDays() + "일");
	}
}