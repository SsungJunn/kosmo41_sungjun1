//
// clone 메소드 호출의 Ex
// 접근 수준 지시자를 protected에서 public으로 바꾸기 위해 메소드 오버라이딩
//

class Point implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
		System.out.println();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 접근지시자를 public으로 바꿈으로써 다른 클래스에서도 접근이 가능
		return super.clone();	// Object 클래스의 clone 메소드 호출
	}
}

class B1_InstenceCloning {

	public static void main(String[] args) {
		Point org = new Point(3, 5);
		Point cpy;
		
		try {
			cpy = (Point)org.clone();
			org.showPosition();
			cpy.showPosition();
			
			if(org.equals(cpy))
				System.out.println("aaaa.");
			else
				System.out.println("bbbb.");
			// org와 cpy의 참조값이 다르다는 것을 알 수 있다.
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
			
		}
	}
}