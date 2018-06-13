package com.mutistic.annotation.factory;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mutistic.utils.CommonConstant;

/**
 * @program 上下文的基础bean BeanFactoryPostProcessor 基础工厂Bean后置处理器
 * @description 1、BeanFactoryPostProcessor的使用。2、BeanFactoryPostProcessor的执行顺序。
 * 	3、使用BeanDefinitionRegistryPostProcessor的动态注册bean。4、通过AnnotationConfigApplicationContext.registerBeanDefinition() 直接动态注册bean
 * @author mutisitic
 * @date 2018年6月13日
 */
public class MainByFactoryProcessor {
	
	public static void main(String[] args) {
		showBeanFactoryPostProcessor();
		showBeanFactoryPostProcessorByIndex();
		showBeanDefinitionRegisteryPostPorcessor();
		showAnnotationRegisteryBean();
	}

	/**
	 * @description 1、演示上下文的基础bean BeanFactoryPostProcessor 自定义实现的使用
	 * @author mutisitic
	 * @date 2018年6月13日
	 */
	private static void showBeanFactoryPostProcessor() {
		CommonConstant.printOne("1、演示上下文的基础bean BeanFactoryPostProcessor 自定义实现的使用");
		new AnnotationConfigApplicationContext(TestBeanFactoryPostProcessor.class).close();
	}
	

	/**
	 * @description 2、演示上下文的基础bean BeanFactoryPostProcessor 自定义实现的执行顺序
	 * @author mutisitic
	 * @date 2018年6月13日
	 */
	private static void showBeanFactoryPostProcessorByIndex() {
		CommonConstant.printOne("2、演示上下文的基础bean BeanFactoryPostProcessor 自定义实现的执行顺序");
		/**
		 * 执行顺序：
		 * 1、BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()
		 * 2、BeanDefinitionRegistryPostProcessor.postProcessBeanFactory()
		 * 3、BeanFactoryPostProcessor.postProcessBeanFactory() 
		 * 4、Bean 依赖配置
		 * 5、BeanPostProcessor.postProcessBeforeInitialization()
		 * 6、Bean 初始化方法 
		 * 7、BeanPostProcessor.postProcessAfterInitialization()
		 */
		new AnnotationConfigApplicationContext(TestFactoryProcessorScan.class).close();
	}
	
	/**
	 * @description 3、演示上下文的基础bean BeanFactoryPostProcessor 的子类 BeanDefinitionRegistryPostProcessor 的自定义实现类的动态注册bean
	 * @author mutisitic
	 * @date 2018年6月13日
	 */
	private static void showBeanDefinitionRegisteryPostPorcessor() {
		CommonConstant.printOne("3、演示上下文的基础bean BeanFactoryPostProcessor 的子类 BeanDefinitionRegistryPostProcessor 的自定义实现类的动态注册bean");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestBeanDefinitionRegistryPostProcessor.class);
		CommonConstant.printTwo("输入动态注入的bean：TestRegistryBean", context.getBeansOfType(TestRegistryBean.class));		
		context.close();
	}
	
	
	/**
	 * @description 4、通过AnnotationConfigApplicationContext.registerBeanDefinition() 直接动态注册bean
	 * @author mutisitic
	 * @date 2018年6月13日
	 */
	private static void showAnnotationRegisteryBean() {
		CommonConstant.printOne("4、通过AnnotationConfigApplicationContext.registerBeanDefinition() 直接动态注册bean：");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestRegistryBean.class);
		for (int i = 0; i < 10; i++) {
			// 通过 BeanDefinitionBuilder 获取Bean的引用(class) (可不注入属性)
			context.registerBeanDefinition("beanName"+i, BeanDefinitionBuilder.rootBeanDefinition(TestRegistryBean.class).getBeanDefinition());
			CommonConstant.printThree("通过 AnnotationConfigApplicationContext.registerBeanDefinition() 和BeanDefinitionBuilder实现动态注册bean：", i);
		}
		CommonConstant.println();
		context.getBeansOfType(TestRegistryBean.class).values().forEach(System.out::println); // java8流模式打印输入
		
		context.close();
	}
	
	
}
