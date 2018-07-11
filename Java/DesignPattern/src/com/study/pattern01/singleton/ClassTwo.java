package com.study.pattern01.singleton;

public class ClassTwo {
	
	public ClassTwo() {
		MySingletonClass single = MySingletonClass.getInstance();
		// 메모리에 생긴 MySingletonClass를 부른다 공유공유
		System.out.println("ClassTwe");
		System.out.println("i = " + single.getI());
	}
	

}
