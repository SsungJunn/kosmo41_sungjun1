public class Quiz14 {

	public static void main(String[] args) {
		int x;
		
		for(x = 0; x < 100; x++)
		{
			  if(x + (x/10 + x%10*10) == 99)
			  System.out.println("A = " + x/10 + " Z = " + x%10 + " = " + 99);
		}
		/*
		for(x = 0; x < 10; x++)
		{
			for(y = 9; y > 0; y--)
			{
				System.out.println("   " + ((x*10)+y));
				System.out.println(" + " + ((y*10)+x));
				System.out.println("--------");
				System.out.println(" = " + 99);
				System.out.println("--------");
			}
		}*/
	}
}

/*
 * for(i = 0; i < 100; i++)
 * if(i/10 + i%10*10 == 99)
 * System.out.println("A = " + i/10 + " Z = + " + i%10);  
 */
