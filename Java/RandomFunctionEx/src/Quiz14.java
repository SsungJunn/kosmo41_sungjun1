// 결과값
//  AZ
// +ZA
// ---
//  99
// A * 10 + Z ----> 두자릿 수 표현하기
// Z * 10 + A



public class Quiz14 {

	public static void main(String[] args) {
		
		 for(int i=0; i<10; i++)
		 {
			 for(int j=0; j<10; j++)
			 {
				 if(((i * 10 + j) + (j * 10 + i)) == 99)
				 {
					 System.out.println(i + " " + j);
					 System.out.println(j + " " + i);
					 System.out.println("-----------");
				 }
			 }
		 }
	}
}

/*
int x;

for(x = 0; x < 100; x++)
{
	  if(x + (x/10 + x%10*10) == 99)
	  System.out.println("A = " + x/10 + " Z = " + x%10 + " = " + 99);
}

*/
