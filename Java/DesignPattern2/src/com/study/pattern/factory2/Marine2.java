package com.study.pattern.factory2;

public class Marine2 implements Unit2 {
	
	public Marine2() {
		System.out.println("���� ���� ~");
	}

	@Override
	public void move() {
		System.out.println("���� �̵�~");
	}
}