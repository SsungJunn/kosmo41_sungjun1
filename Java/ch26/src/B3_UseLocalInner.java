//
// ���� Ŭ����
// ���� Ŭ������ ���Ŭ������ ��� �κ� �����ϴ�.
// ���� ���� ���ǵȴٴ� �������� ���̸� ����
// 

interface Printable2 { void print(); }

class Papers2 {
	private String con;
	public Papers2(String s) { con = s; }
	
	public Printable2 getPrinter() {
		class Printer implements Printable2 {
			public void print() {
				System.out.println(con);
			}
		}	// �޼ҵ� ������ ���� �� ���� ����!
		return new Printer();
	}
}

public class B3_UseLocalInner {

	public static void main(String[] args) {
		Papers2 p = new Papers2("��������: �ູ�մϴ�.");
		Printable2 prn = p.getPrinter();
		prn.print();
	}
}