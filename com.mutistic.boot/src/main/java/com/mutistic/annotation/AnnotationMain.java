package com.mutistic.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mutistic.utils.CommonConstant;

/**
 * @program AnnotationConfigApplicationContext Main类
 * @description 使用 独立的应用程序上下文 实现bean的注入和获取
 * @author mutisitic
 * @date 2018年6月5日
 */
public class AnnotationMain {

	/**
	 * 1、AnnotationConfigApplicationContext：独立的应用程序上下文
	 	https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html
	 * 
	 * 2、Bean的注入方式：
	 	Config类实现 @Configuration 注解  >> Config类中创建方法实现 @Bean 注解  >> context通过构造器加载Config类，然后通过 getBean(); 获取bean
	 	2.1：@Bean name属性可以指定 bean的名称，不指定时默认名称为 方法名
	 	2.2：使用工厂类实现 org.springframework.beans.factory.FactoryBean<T> 创建bean实例，重写 getObject(); getObjectType(); isSingleton();
	 	2.3：使用工厂类实现创建具体bean方法，config使用 @Bean 注解实现工厂类bean的创建方法，confgi使用 @Bean 注解实现具体bean的创建方法，入参为 工厂类（会自动搜索工厂类bean）。
	 */
	
	/**
	 * @description main方法入口
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @param args
	 */
	public static void main(String[] args) {
		String pref = "使用AnnotationConfigApplicationContext根据";
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		CommonConstant.PRINTLN();
		CommonConstant.PRINTLINE();
		// 获取 AnnotationTestBean简单实 bean
		System.out.println(CommonConstant.PRINTLN_PREF + "获取 AnnotationTestBean简单实 bean：");
		System.out.println(CommonConstant.PRINT_PREF + pref +"class获取AnnotationTestBean bean【" + context.getBean(AnnotationTestBean.class)+"】");
//		System.out.println(CommonConstant.PRINT_PREF + pref +"方法名获取（未指定bean name属性时，默认为方法名名。指定后则不能用方法名）AnnotationTestBean Bean【" + context.getBean("createrAnnotationBean")+"】");
		System.out.println(CommonConstant.PRINT_PREF + pref +"指定bean name属性 获取AnnotationTestBean Bean【" + context.getBean("annotationTestBean")+"】");
		System.out.println(CommonConstant.PRINT_PREF +"AnnotationTestBean Bean Scope模式-是否是单例模式【"+ (context.getBean(AnnotationTestBean.class) == context.getBean(AnnotationTestBean.class))+"】");
		CommonConstant.PRINTLINE();
		
		// 获取 RunnableFactory简单工厂bean：& = org.springframework.beans.factory.BeanFactory.FACTORY_BEAN_PREFIX
		System.out.println(CommonConstant.PRINTLN_PREF + "获取 RunnableFactory简单工厂bean：");
		System.out.println(CommonConstant.PRINT_PREF + pref +"class获取RunnableFactory bean【" + context.getBean(RunnableFactory.class) +"】");
		System.out.println(CommonConstant.PRINT_PREF + pref +"&和方法名获取 RunnableFactory bean【" + context.getBean("&createrRunnableFactory")+"】");
		System.out.println(CommonConstant.PRINT_PREF + pref +"class获取Runnable bean：" + context.getBean(Runnable.class)+"】");
		System.out.println(CommonConstant.PRINT_PREF +"RunnableFactory Bean Scope模式-是否是单例模式【"+ (context.getBean(RunnableFactory.class) == context.getBean(RunnableFactory.class))+"】");
		CommonConstant.PRINTLINE();
		
		// 获取 JeepBeanFactory简单工厂bean
		System.out.println(CommonConstant.PRINTLN_PREF + "获取 JeepBeanFactory简单工厂bean：");
		System.out.println(CommonConstant.PRINT_PREF + pref +"class获取JeepBeanFactory bean【" + context.getBean(JeepBeanFactory.class)+"】");
		System.out.println(CommonConstant.PRINT_PREF + pref +"方法名获取 JeepBeanFactory bean【" + context.getBean("jeeptBeanFactory")+"】");
		System.out.println(CommonConstant.PRINT_PREF + pref +"class获取Jeep bean【" + context.getBean(Jeep.class)+"】");
		System.out.println(CommonConstant.PRINT_PREF +"Jeep Bean Scope模式-是否是单例模式【"+ (context.getBean(Jeep.class) == context.getBean(Jeep.class))+"】");
		CommonConstant.PRINTLINE();
		
		// 获取 FocusBeanFactory简单工厂bean
		System.out.println(CommonConstant.PRINTLN_PREF + "获取 JeepBeanFactory简单工厂bean：");
		System.out.println(CommonConstant.PRINT_PREF + pref +"class获取FocusBeanFactory bean【" + context.getBean(FocusBeanFactory.class)+"】");
		System.out.println(CommonConstant.PRINT_PREF + pref +"class获取Focus bean【" + context.getBean(Focus.class)+"】");
		System.out.println(CommonConstant.PRINT_PREF +"Focus Bean Scope模式-是否是单例模式【"+ (context.getBean(Focus.class) == context.getBean(Focus.class))+"】");
		CommonConstant.PRINTLINE();
		
		CommonConstant.PRINTLN();
		context.close();
	}
}
