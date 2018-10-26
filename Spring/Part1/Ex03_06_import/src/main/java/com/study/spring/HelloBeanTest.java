package com.study.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] agrs) {
		String configLocation = "classpath:beans.xml";
		
		// A. IoC 컨테이너 생성
		AbstractApplicationContext context =
				new GenericXmlApplicationContext(configLocation);
		
		// B. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		hello.print();
		
//		context.close();
	}
}
