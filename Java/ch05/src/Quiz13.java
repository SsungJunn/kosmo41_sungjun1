 public class Quiz13 {

	public static void main(String[] args) {
		
		System.out.println("����");
		for(int j = 1; j < 10; j++) {
			System.out.print("");
			for(int i = 2; i < 10; i++) 
			{
				System.out.print(i + "x" + j + "=" + (i*j) + '\t');
			}
			System.out.print('\n');
		}
		System.out.print('\n');
		
		System.out.println("����");
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) 
			{
				System.out.print(i + "x" + j + "=" + (i*j) + '\t');
			}
			System.out.print('\n');
		}
	}
}