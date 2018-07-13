package com.study.pattern03.simple_.factory;

public class Medic implements Unit {

	public Medic() {
		System.out.println("¸Þµñ »ý¼º !!!");
	}
	
	@Override
	public void move() {
		System.out.println("¸Þµñ ÀÌµ¿ !!!");

	}

}
