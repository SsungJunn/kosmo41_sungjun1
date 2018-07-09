package com.study.pattern.stretegy2;

public class GameCharacter {
	
	// ������ - ��� ����� ���� ĳ���͸� ���ؼ� �����Ѵ�.
	// �������̽��� ���� ������ ���� ��ΰ� ��.
	private Weapon weapon;
	
	// ���� ��ȯ�� ��������!!
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	// ��� ���
	public void fire() {
		if(weapon == null) {
			System.out.println("���� ����!");
		} else {
			weapon.shoot();
			// fire�� shoot���� ��� ���� �̰��� Deligate
		}
	}

}
