package com.study.pattern01.singleton;

public class ClassTwo {
	
	public ClassTwo() {
		MySingletonClass single = MySingletonClass.getInstance();
		// �޸𸮿� ���� MySingletonClass�� �θ��� ��������
		System.out.println("ClassTwe");
		System.out.println("i = " + single.getI());
	}
	

}
