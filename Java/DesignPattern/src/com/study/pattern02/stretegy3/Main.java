package com.study.pattern02.stretegy3;

public class Main {

	public static void main(String[] args) {
		// �����ͺ��̽��� ���������� �����Ͽ� ����Ѵ�.
		DatabaseUse myDB = new DatabaseUse();
		myDB.connect();
		
		myDB.setDatebase(new MySQL());
		myDB.connect();
		
		myDB.setDatebase(new Oracle());
		myDB.connect();
		
		myDB.setDatebase(new Informix());
		myDB.connect();
	}

}
