package com.study.pattern03.simple_.factory;

public class Marine implements Unit {

	public Marine() {
		System.out.println("���� ���� !!!");
	}
	@Override
	public void move() {
		System.out.println("���� �̵� !!!");

	}

}
