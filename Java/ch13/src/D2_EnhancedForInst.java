//
// 인스턴스 배열 대상 for-each문의 예
//

class Box3 {
	private String contents;
	private int boxNum;
	
	Box3(int num, String cont) {
		boxNum = num;
		contents = cont;
	}
	
	public int getBoxNum() {
		return boxNum;
	}
	public String toString() {
		return contents;
	}
}


public class D2_EnhancedForInst 
{
	public static void main(String[] args)
	{
		Box3[] ar = new Box3[5];
		ar[0] = new Box3(101, "Coffee");
		ar[1] = new Box3(202, "Computer");
		ar[2] = new Box3(303, "Apple");
		ar[3] = new Box3(404, "Dress");
		ar[4] = new Box3(505, "Faire-tale book");
		
		for(Box3 e: ar) 
		{
			if(e.getBoxNum() == 505)
				System.out.println(e);
		}
	}
}
