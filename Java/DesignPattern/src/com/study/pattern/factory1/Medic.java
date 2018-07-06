package com.study.pattern.factory1;

public class Medic implements Unit {

	public Medic() {
		System.out.println("¸Þµñ »ý¼º !!!");
	}
	
	@Override
	public void move() {
		System.out.println("¸Þµñ ÀÌµ¿ !!!");

	}

}
