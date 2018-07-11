package com.study.pattern01.singleton;

public class ClassOne {

	public ClassOne() {
		MySingletonClass single = MySingletonClass.getInstance();
		System.out.println("ClassOne");
		// 메모리에 생긴 MySingletonClass를 부른다 공유공유
		
		int num = single.getI();
		System.out.println("i = " + num);
		single.setI(200);
		System.out.println("i = " + single.getI());
	}
}