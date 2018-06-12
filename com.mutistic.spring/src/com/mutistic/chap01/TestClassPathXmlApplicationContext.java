package com.mutistic.chap01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestClassPathXmlApplicationContext {
	
	@Test
	public void tetaaaa() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/resources/config/mytest.xml");
		System.out.println(context.getBean("knight"));
		
	}
	
}
