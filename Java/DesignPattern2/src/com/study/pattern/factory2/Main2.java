package com.study.pattern.factory2;

public class Main2 {

	public static void main(String[] args) {
		Unit2 unit1 = UnitFatory2.createUnit(UnitType.Marine2);
		Unit2 unit2 = UnitFatory2.createUnit(UnitType.Firebat2);
		Unit2 unit3 = UnitFatory2.createUnit(UnitType.Medic2);
		
		unit1.move();
		unit2.move();
		unit3.move();
	}
	
	

}
