package com.chap01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/resources/config/mytest.xml")
public class TestContextConfiguration extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private BraveKnight b;
	
	@Test
	public void tetaaaa() {
		System.out.println(b);
		System.out.println(this.applicationContext.getBean("knight"));
	}
	
}
