class Circle2 {
	private double rad = 0;	// 원의 반지름
	final double PI = 3.14;
	
	public Circle2(double r) {
		setRad(r);
	}
	public void setRad(double r) {	// Setter
		if(r < 0) {
			rad = 0;
			return;
			}
		rad = r;
	}
	public double getRad() {	// Getter
		return rad;
	}
	
	public double getArea() {
		return (rad * rad) * PI;
	}
}
public class B_InfoHideCircle {
		
	public static void main(String[] args) {
		Circle2 c = new Circle2(1.5);
		System.out.println(c.getArea());
		
		c.setRad(2.5);
		System.out.println(c.getArea());
		c.setRad(-3.3);
		System.out.println(c.getArea());
	//	c.rad = -4.5;	// 컴파일 오류로 이어짐
		System.out.println(c.getArea());
	}
}
