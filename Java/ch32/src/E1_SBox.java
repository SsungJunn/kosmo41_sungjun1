/*
 * 인스턴스 직렬화를 위한 기본 조건인 Serializable 인터페이스 구현
 */
public class E1_SBox implements java.io.Serializable {
	String s;
	
	public E1_SBox(String s) {
		this.s = s;
	}
	
	public String get() {
		return s;
	}
}