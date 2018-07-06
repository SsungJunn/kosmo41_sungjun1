package com.study.pattern.factory2;

public class Medic2 implements Unit2 {
	
	public Medic2() {
		System.out.println("¸Þµñ »ý»ê~");
	}
	@Override
	public void move() {
		System.out.println("¸Þµñ ÀÌµ¿~");
	}
}