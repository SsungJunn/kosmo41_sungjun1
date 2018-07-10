/*
 * ObjectOutputStream 예제
 * 인스턴스 직렬화를 위한 기본 조건인 Serializable 인터페이스 구현
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class E2_ObjectOutputStream {

	public static void main(String[] args) {
		E1_SBox box1 = new E1_SBox("Robot");
		E1_SBox box2 = new E1_SBox("Strawberry");

		try (ObjectOutputStream oo = 
				new ObjectOutputStream(
						new FileOutputStream("Object.bin"))) {
			oo.writeObject(box1);	// box1이 참조하는 인스턴스 저장
			oo.writeObject(box2);	// box1이 참조하는 인스턴스 저장

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}