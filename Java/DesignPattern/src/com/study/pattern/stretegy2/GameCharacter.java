package com.study.pattern.stretegy2;

public class GameCharacter {
	
	// 접근점 - 모든 무기는 게임 캐릭터를 통해서 접근한다.
	// 인터페이스가 각종 무기의 단일 통로가 됨.
	private Weapon weapon;
	
	// 무기 교환이 가능해짐!!
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	// 기능 사용
	public void fire() {
		if(weapon == null) {
			System.out.println("무기 착용!");
		} else {
			weapon.shoot();
			// fire가 shoot한테 기능 위임 이것이 Deligate
		}
	}

}
