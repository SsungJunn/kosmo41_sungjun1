class Circle {
	double rad = 0;	// 원의 반지름
	final double PI = 3.14;
	
	public Circle(double r) {
		setRad(r);
	}
	public void setRad(double r) {
		if(r < 0) {
			rad = 0;
			return;
			}
		rad = r;
	}
	
	public double getArea() {
		return (rad * rad) * PI;
	}
}
public class A_UnsafeCircle {
	public static void main(String[] args) {
		Circle c = new Circle(1.5);
		System.out.println(c.getArea());
		
		c.setRad(2.5);
		System.out.println(c.getArea());
		c.setRad(-3.3);
		System.out.println(c.getArea());
		c.rad = -4.5;	// 컴파일 오류 발생안함, 직접 수정 가능(위험)
		System.out.println(c.getArea());
	}
}