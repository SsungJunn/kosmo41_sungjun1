//
// Ŭ���� ���� ������ ��
//


class AccessWay {
	static int num = 0;
	
	AccessWay() {incrCnt();}
	void incrCnt() {
		// Ŭ���� ���ο��� �̸��� ���� ����
		System.out.println(num);
		num++;
		
	}
}

class A2_ClassVarAccess {

	public static void main(String[] args) {

		// �ܺο��� �ν��Ͻ��� �̸��� ���� ����
		AccessWay way = new AccessWay();
		System.out.println(way.num);
		way.num++;
		System.out.println("num = " + way.num);
		
		// �ܺο��� Ŭ������ �̸��� ���� ����
		AccessWay.num++;
		System.out.println("num = " + AccessWay.num);
	}

}