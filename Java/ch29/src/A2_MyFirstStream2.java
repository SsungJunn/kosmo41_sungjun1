/*
 * ��Ʈ���� ù ��° ������ ����
 * ������ ������ ��Ʈ���� �̿��� �����ϰ� ������.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

class A2_MyFirstStream2 {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5 };
		int sum =Arrays.stream(ar)	// ��Ʈ�� ����
					   .filter(n -> n%2 == 1)	// filter ���,
					   .sum();	// sum ��� ��� ��ȯ
		System.out.println(sum);
	}
}