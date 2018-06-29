import java.util.Scanner;

public class MindReader {

	public static void main(String[] args) {
		int nMax = 100;
		int nMin = 0;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("1부터 100사이 숫자를 너가 맞추면되");
		System.out.println("내가 생각한 숫자보다 크면 h");
		System.out.println("내가 생각한 숫자보다 작으면 l");
		System.out.println("내가 생각한 숫자랑 같으면 y");
		
		while(true)
		{
			System.out.println((nMax + nMin)/2 + "가 맞니?");
			String word = s.nextLine();
			//if((nMax+nMin)/2 < nMax || (nMax+nMin)/2 > nMin)
			if(word.equals("y"))
			{
				break;
			}
			if(word.equals("h"))
			{	
				nMin = (nMax+nMin)/2;
			}
			if(word.equals("l"))
			{	
				nMax = (nMax+nMin)/2;
			}
		}
	}	
}
