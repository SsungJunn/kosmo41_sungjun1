public class Test {

	public static void main(String[] args) {
		String str = "/to È«±æµ¿ ¾È³çdjbhfldk sjhfladshfls";
		
		if(str.indexOf("/to") >= 0) {
			int nTmp1 =str.indexOf(" ");
			String strTmp = str.substring(nTmp1, nTmp1+4);
//			String strTmp2 = str.substring(nTmp1, nTmp1+1);
			
			nTmp1 = strTmp.indexOf(" ");
			strTmp = strTmp.substring(nTmp1+1);
			System.out.println(strTmp);
//			System.out.println(strTmp2);
		}
	}

}
