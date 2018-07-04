class E1_Change {

	public static void main(String[] args) {
		String a = "34";
		int b = 50;
		int c = Integer.parseInt(a);
		//문자열을 형변환 시켜줘야 연산이 가능하다.
		int d = c + b;
		System.out.println(a + " + " + b + " = " + d);
	}

}
