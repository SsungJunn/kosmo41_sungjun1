package com.study.pattern.singleton;

public class ClassTwo {
	
	public ClassTwo() {
		MySingletonClass single = MySingletonClass.getInstance();
		// �޸𸮿� ���� MySingletonClass�� �θ��� ��������
		System.out.println("ClassTwe");
		System.out.println("i = " + single.getI());
	}
	

}
