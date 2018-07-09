/*
 * 2시간 10분 뒤 어때? : LocalTime 클래스
 * LocalDate는 날짜 정보, LocalTime은 시각 정보를 나타내는 클래슨ㄴㄴㄴ
 */

import java.time.LocalTime;

public class A4_LocaTimeDemo1 {

	public static void main(String[] args) {
		// 현재 시각
		LocalTime now = LocalTime.now();
		System.out.println("지금 시각: " + now);
		
		//  2시간 10분 뒤 화상 미팅 예정
		LocalTime mt = now.plusHours(2);
		mt = mt.plusMinutes(10);
		
		// 화상 미팅 시각
		System.out.println("화상 미팅 시각: " + mt);
	}
}