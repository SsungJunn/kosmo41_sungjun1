package com.study.pattern04.factory_method2.database;

/// The 'Product' abstract class

public abstract class Database {

	public String name;
	public double rows;
	
	// �����ͺ��̽����� ���ӹ���� �ٸ���.
	public abstract void connectDatabase();
	
	// ǥ�� SQL���� ����Ѵ�. (����ó�� ����� ����.)
	public void insertData()
	{
		System.out.println(name + "�� �����Ϳ� �߰��߽��ϴ�.");
	}
	
	public void selectData()
	{
		System.out.println(name + "���� �����͸� " + rows + "�� ��ȸ�߽��ϴ�.");
	}
}
