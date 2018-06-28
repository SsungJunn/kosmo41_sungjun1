public class C2_BuildString {

	public static void main(String[] args) {
		StringBuilder stbuf = new StringBuilder("123");
		
		stbuf.append(5678); // 문자열 덧붙이기
		System.out.println(stbuf.toString());
		
		stbuf.delete(0, 2); // 문자열 일부 삭제
		System.out.println(stbuf.toString());
		
		stbuf.replace(0, 3, "AB"); // 문자열 일부 교체
		System.out.println(stbuf.toString());
		
		stbuf.reverse(); // 문자열 내용 뒤집기
		System.out.println(stbuf.toString());
		
		String sub = stbuf.substring(2, 4); // 일부만 문자열로 반환
		System.out.println(sub);
	}

}
