package com.study.pattern04.factory_method2.database;

/// B 'ConcreteProduct' class

public class Oracle extends Database {

	public Oracle() {
		name = "Oracle";
		rows = 20;
	}
	
	@Override
	public void connectDatabase() {
		System.out.println(name + "�� �����߽��ϴ�.");
	}
}