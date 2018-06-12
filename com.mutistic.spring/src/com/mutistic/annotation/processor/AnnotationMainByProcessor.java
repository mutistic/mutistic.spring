package com.mutistic.annotation.processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mutistic.utils.CommonConstant;

/**
 * @program 演示 BeanPostProcessor 处理器
 * @description 
 * @author mutisitic
 * @date 2018年6月12日
 */
public class AnnotationMainByProcessor {

	public static void main(String[] args) {
		showBeanPostProcessor();
		showApplicationContextAware();
		showApplicationContextAwareBySelf();
	}
	
	/**
	 * @description 演示 BeanPostProcessor 处理器
	 * @author mutisitic
	 * @date 2018年6月12日
	 */
	private static void showBeanPostProcessor() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestProcessorScan.class);
		
		CommonConstant.printPref("TestBean bean", context.getBean(TestBean.class));
		CommonConstant.printPref("TestBean的代理对象 TestBeanExtend bean", context.getBean("testBean"));
		CommonConstant.printPref("TestProcessorScan bean", context.getBean(TestProcessorScan.class));
		CommonConstant.printPref("TestBeanPostProcessor bean", context.getBean(TestBeanPostProcessor.class));
		
		context.close();
	}
	
	/**
	 * @description 展示 ApplicationContext 的注入 
	 * @author mutisitic
	 * @date 2018年6月12日
	 */
	private static void showApplicationContextAware() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationContextAware.class);
		
		CommonConstant.printLine("实现 ApplicationContext 的注入");
		context.getBean(TestApplicationContextAware.class).show();
		
		CommonConstant.println();
		context.close();
	}
	
	
	/**
	 * @description 模拟 ApplicationContextAware的接口功能
	 * @author mutisitic
	 * @date 2018年6月12日
	 */
	private static void showApplicationContextAwareBySelf() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RealizeBeanPostProcessor.class ,RealizeBean.class);
		
		CommonConstant.printLine("模拟 ApplicationContextAware的接口功能 ");
		context.getBean(RealizeBean.class).show();
		
		CommonConstant.println();
		context.close();
	}
}
