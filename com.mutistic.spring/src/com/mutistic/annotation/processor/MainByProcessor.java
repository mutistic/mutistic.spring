package com.mutistic.annotation.processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mutistic.utils.CommonUtil;

/**
 * @program BeanPostProcessor bean处理器
 * @description 1、演示BeanPostProcessor的使用。2、演示ApplicationContext 的几种自动注入方式。3、模拟 ApplicationContext Aware的接口实现ApplicationContext的注入。
 * @author mutisitic
 * @date 2018年6月12日
 */
public class MainByProcessor {
	public static void main(String[] args) {
		showBeanPostProcessor();
		showApplicationContextAware();
		showApplicationContextAwareBySelf();
	}
	
	/**
	 * 加载机制：AnnotationConfigApplicationContext > GenericApplicationContext > AbstractApplicationContext.refresh()
	 */
	
	/**
	 * @description 1、演示BeanPostProcessor的使用
	 * @author mutisitic
	 * @date 2018年6月12日
	 */
	private static void showBeanPostProcessor() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestProcessorScan.class);
		
		CommonUtil.printTwo("TestBean bean", context.getBean(TestBean.class));
		CommonUtil.printTwo("TestBean的代理对象 TestBeanExtend bean", context.getBean("testBean"));
		CommonUtil.printTwo("TestProcessorScan bean", context.getBean(TestProcessorScan.class));
		CommonUtil.printTwo("TestBeanPostProcessor bean", context.getBean(TestBeanPostProcessor.class));
		
		context.close();
	}
	
	/**
	 * @description 2、演示ApplicationContext 的几种自动注入方式
	 * @author mutisitic
	 * @date 2018年6月12日
	 */
	private static void showApplicationContextAware() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationContextAware.class);
		
		CommonUtil.printOne("实现 ApplicationContext 的注入");
		context.getBean(TestApplicationContextAware.class).show();
		
		CommonUtil.println();
		context.close();
	}
	
	
	/**
	 * @description 3、模拟 ApplicationContextAware的接口 实现ApplicationContext的注入
	 * @author mutisitic
	 * @date 2018年6月12日
	 */
	private static void showApplicationContextAwareBySelf() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RealizeBeanPostProcessor.class ,RealizeBean.class);
		
		CommonUtil.printOne("模拟 ApplicationContextAware的接口 实现ApplicationContext的注入");
		context.getBean(RealizeBean.class).show();
		
		CommonUtil.println();
		context.close();
	}
}
