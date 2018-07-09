/*
 * 시간이 얼마나 걸린지 알 수 있는 Instant 클래스
 * 시각 : 시간의 어느 한 시점
 * 시간 : 어떤 시각에서 어떤 시각까지의 사이
 */

import java.time.Duration;
import java.time.Instant;

public class A1_InstantDemo {

	public static void main(String[] args) {
		Instant start = Instant.now();	// 현재 시각 정보를 담음
		System.out.println("시작: " + start.getEpochSecond());
		// 반환 값은 '1970-01-01 00:00:00'을 기준으로 지나온 시간을 초 단위로 계산한 결과
		
		System.out.println("Time files like an arrow.");

		Instant end = Instant.now();	// 현재 시각 정보를 담음
		System.out.println("끝: " + end.getEpochSecond());
		
		Duration between = Duration.between(start, end);	
		// 두 시각의 차 계산
		// Duration은 시각 차를 표현하기 위한 클래스
		
		System.out.println("밀리 초 단위 차: " + between.toMillis());
	}
}