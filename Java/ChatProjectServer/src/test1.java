import java.io.PrintWriter;
import java.util.StringTokenizer;

public class test1 {
   public static void main(String[] args) {
//      String s= "조=>성 ㅇㅇㅇ";
      String s= "[조성준] : /join 야호";
      
      int nTmp = s.indexOf(" ");
		String msg = s.substring(nTmp+1);
		nTmp = msg.indexOf(" ");
		msg = msg.substring(nTmp+1);
//		nTmp = msg.indexOf(" ");
//		msg = msg.substring(nTmp+1);
		System.out.println(msg);
		
		
		
//		StringTokenizer t1 = new StringTokenizer(s);
//		StringTokenizer t2 = new StringTokenizer(s);
//
//		t1.nextToken();
//		
//		t2.nextToken();
//		t2.nextToken();
//
//		String strTmp = t1.nextToken();
//		String strTmp2 = t2.nextToken();
//
//		System.out.println(strTmp);
//		System.out.println(strTmp2);
		
		
//		PrintWriter pr = (PrintWriter) clientMap.get(strTmp2);
//		pr.println(strTmp);
   }

}