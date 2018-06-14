package com.mutistic.annotation.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mutistic.utils.CommonUtil;

/**
 * @program AnnotationConfigApplicationContext Main类
 * @description 使用 独立的应用程序上下文 实现bean的注册和获取 ：演示 @Configuration + @Bean方式
 * @author mutisitic
 * @date 2018年6月5日
 */
public class MainByBeans {

	/**
	 * 1、AnnotationConfigApplicationContext：独立的应用程序上下文
	 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html
	 * 
	 * 2、Bean的注入方式： Config类实现 @Configuration 注解 >> Config类中创建方法实现 @Bean 注解 >>
	 * context通过构造器加载Config类，然后通过 getBean(); 获取bean 2.1：@Bean name属性可以指定
	 * bean的名称，不指定时默认名称为 方法名 2.2：使用工厂类实现
	 * org.springframework.beans.factory.FactoryBean<T> 接口创建bean实例，重写 getObject();
	 * getObjectType(); isSingleton(); 2.3：使用工厂类实现创建具体bean方法，config使用 @Bean 注解实现工厂类
	 * bean的创建方法，config使用 @Bean 注解实现具体bean的创建方法，入参为 工厂类（会自动搜索工厂类bean）。
	 */

	/**
	 * @description main方法入口
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @param args
	 */
	public static void main(String[] args) {
		CommonUtil.printOne("使用AnnotationConfigApplicationContext获取和注册bean");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestBeansConfig.class);
		getTestBean(context);
		getRunnableByFactoryBean(context);
		getJeepByFactoryBean(context);
		getFocusByFactory2(context);

		CommonUtil.println();
		context.close();
	}

	/**
	 * @description 通过@Bean直接创建 bean
	 * @author mutisitic
	 * @date 2018年6月11日
	 * @param context
	 */
	private static void getTestBean(AnnotationConfigApplicationContext context) {
		CommonUtil.printOne("通过 @Bean直接创建 bean");
		System.out.println(CommonUtil.LINE_SHORT + "通过class获取 Bean【" + context.getBean(TestAnnotationBean.class) + "】");
		// System.out.println(CommonConstant.PRINT_PREF +"方法名获取（未指定bean name属性时，默认为方法名名。指定后则不能用方法名）Bean【" +context.getBean("createrAnnotationBean")+"】");
		System.out.println(CommonUtil.LINE_SHORT + "通过Bean name属性获取 Bean【" + context.getBean("annotationTestBean") + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过 Bean的 @Scope注解-设置是否是单例模式【" + (context.getBean(TestAnnotationBean.class) == context.getBean(TestAnnotationBean.class)) + "】");
	}

	/**
	 * @description 通过 FactoryBean<T>接口实现类 创建 bean。 &：org.springframework.beans.factory.BeanFactory.FACTORY_BEAN_PREFIX
	 * @author mutisitic
	 * @date 2018年6月11日
	 * @param context
	 */
	private static void getRunnableByFactoryBean(AnnotationConfigApplicationContext context) {
		CommonUtil.printOne("通过 FactoryBean<T> 工厂模式创建 bean");
		System.out.println(CommonUtil.LINE_SHORT + "通过class获取 工厂Bean【" + context.getBean(RunnableFactory.class) + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过&和方法名获取 工厂Bean【" + context.getBean("&createrRunnableFactory") + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过class获取 具体Bean：" + context.getBean(Runnable.class) + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过方法名获取 具体Bean：" + context.getBean("createrRunnableFactory") + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过 FactoryBean.isSingleton()-设置是否是单例模式【" + (context.getBean(RunnableFactory.class) == context.getBean(RunnableFactory.class)) + "】");
	}

	/**
	 * @description 通过 FactoryBean<T>接口实现类 创建工厂 bean
	 * @author mutisitic
	 * @date 2018年6月11日
	 * @param context
	 */
	private static void getJeepByFactoryBean(AnnotationConfigApplicationContext context) {
		CommonUtil.printOne("通过 FactoryBean<T>接口实现类 创建 bean");
		System.out.println(CommonUtil.LINE_SHORT + "通过class获取 工厂Bean【" + context.getBean(JeepBeanFactory.class) + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过&和方法名获取 工厂Bean【" + context.getBean(BeanFactory.FACTORY_BEAN_PREFIX +"jeeptBeanFactory") + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过class获取 具体Bean【" + context.getBean(Jeep.class) + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过方法名获取 具体Bean【" + context.getBean("jeeptBeanFactory") + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过 FactoryBean.isSingleton()-设置是否是单例模式【" + (context.getBean(Jeep.class) == context.getBean(Jeep.class)) + "】");

	}

	/**
	 * @description 通过简单工厂类创建工厂bean和实体bean
	 * @author mutisitic
	 * @date 2018年6月11日
	 * @param context
	 */
	private static void getFocusByFactory2(AnnotationConfigApplicationContext context) {
		CommonUtil.printOne("通过简单工厂类创建工厂bean和实体bean");
		System.out.println(CommonUtil.LINE_SHORT + "通过class获取 工厂Bean集合【" + context.getBeansOfType(FocusBeanFactory.class) + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过class获取 具体Bean【" + context.getBean(Focus.class) + "】");
		System.out.println(CommonUtil.LINE_SHORT + "通过 Bean的 @Scope注解-设置是否是单例模式【" + (context.getBean(Focus.class) == context.getBean(Focus.class)) + "】");
	}
}
