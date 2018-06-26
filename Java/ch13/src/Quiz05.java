import java.util.Scanner;

public class Quiz05 {

public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("단어를 입력해주세요");
		String word = s.next();

		String[] array_word = new String[word.length()]; // 스트링을 담을 배열

		for(int i=0;i<array_word.length;i++){ //스트링을 한글자씩 끊어 배열에 저장
			array_word[i] = Character.toString(word.charAt(i));
			{
				if (array_word[i].equals(array_word[2]) )
			    {
					System.out.println("회문입니다.");
			    }
				
			}
		}		
	}
}
/*
 * if (str1.equals(str2) )
    {
        System.out.println("...");
    } 
*/
//출력 테스트용… 실제 사용시 안써도 됨.
		//for(int i=0;i<array_word.length;i++){
		//	System.out.println(array_word[i]);