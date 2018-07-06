package com.study.pattern.factory2;

enum UnitType {
	Marine2, Firebat2, Medic2
}

public class UnitFatory2 {

	public static Unit2 createUnit(UnitType type) {
		Unit2 unit = null;

		switch (type) {
		case Marine2:
			unit = new Marine2();
			break;
		case Firebat2:
			unit = new Firebat2();
			break;
		case Medic2:
			unit = new Medic2();
			break;

		}return unit;
	}

}
