package com.study.pattern03.stretegy2;

public class Main {

	public static void main(String[] args) {
		GameCharacter character = new GameCharacter();
		character.fire();
		
		// ���û�Ȳ�� ���� ���������� ���⸦ �����Ѵ�.
		character.setWeapon(new Arrow());
		character.fire();
		
		character.setWeapon(new Bullet());
		character.fire();
		
		character.setWeapon(new Bomb());
		character.fire();
	}
}
