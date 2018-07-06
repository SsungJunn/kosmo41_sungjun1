package com.study.pattern.factory2;

public class Firebat2 implements Unit2 {

	public Firebat2() {
		System.out.println("파이어뱃 생성~");
	}
	@Override
	public void move() {
		System.out.println("파이어뱃 이동~");

	}

}
