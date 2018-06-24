public class Quiz9 {

	public static void main(String[] args) {
		
		int i;
		int sum = 0;
		
		do {
			for(i = 1; i <= 100; i++)
				if(i % 2 == 0)
					
				sum = sum + i;	
			
		}while(i < 100);
		System.out.println("sum = " + sum);
	}
}