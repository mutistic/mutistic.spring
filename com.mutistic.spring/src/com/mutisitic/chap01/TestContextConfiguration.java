package com.mutisitic.chap01;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program 
 * @description 
 * </p>
 * - v1.0 - YC.Yin-20170507
 *  问题描述：在 Java8 中 RunWith注解在使用  SpringJUnit4ClassRunner.class 时 pachage引用会报错，但是 JUnit测试能够正常运行
 *  解决方案：暂未解决，临时解决方案1：注释 RunWith注解, 临时解决方案2：切换低版本JDK
 * @author YC.Yin 
 * @date 2017-5-7
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/resources/config/mytest.xml")
public class TestContextConfiguration extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private BraveKnight braveKnight;
	
	@Test
	public void tetaaaa() {
		System.out.println(braveKnight);
		System.out.println(this.applicationContext.getBean("knight"));
	}
	
}
