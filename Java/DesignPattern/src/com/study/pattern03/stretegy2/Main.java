package com.study.pattern03.stretegy2;

public class Main {

	public static void main(String[] args) {
		GameCharacter character = new GameCharacter();
		character.fire();
		
		// 선택상황에 따라 전략적으로 무기를 선택한다.
		character.setWeapon(new Arrow());
		character.fire();
		
		character.setWeapon(new Bullet());
		character.fire();
		
		character.setWeapon(new Bomb());
		character.fire();
	}
}
