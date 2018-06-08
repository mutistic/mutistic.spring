package com.mutistic.annotation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @program bean组件扫描 引导@Configuration类
 * @description 开启组件扫描
 * @author mutisitic
 * @date 2018年6月5日
 */
@Configuration
public class AnnotationConfig {
	
	/**
	 * 1、@Configuration：不仅可以使用组件扫描进行引导，还可以使用注释配置组件扫描@ComponentScan
		https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html
		
	 * 2、@Bean：声明为一个bean，不指定 name属性值的话默认为bean name为方法名
			https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html
			
	 * 3、@Scope：指定用于注释的组件/ bean的作用域的名称
		value：作用域范围：默认为空，单例模式： ConfigurableBeanFactory.SCOPE_PROTOTYPE（非单例）， ConfigurableBeanFactory.SCOPE_SINGLETON（单例）， WebApplicationContext.SCOPE_REQUEST， WebApplicationContext.SCOPE_SESSION， value()
		https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Scope.html
	 */

	/**
	 * @description 使用 @Bean 直接创建Bean对象
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return AnnotationTestBean Bean
	 */
	@Bean(name = "annotationTestBean")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public AnnotationTestBean createrAnnotationTestBean() {
		return new AnnotationTestBean();
	}
	
	/**
	 * @description 创建 RunnableFactory 工厂bean 
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return RunnableFactory Bean
	 */
	@Bean
	public RunnableFactory createrRunnableFactory() {
		return new RunnableFactory();
	}
	
	/**
	 * @description 创建 JeepBeanFactory 工厂bean 
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return JeepBeanFactory Bean 
	 */
	@Bean
	public JeepBeanFactory jeeptBeanFactory() {
		return new JeepBeanFactory();
	}
	
	
	/**
	 * @description 创建 FocusBeanFactory 工厂bean 
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return FocusBeanFactory Bean 
	 */
	@Bean
	public FocusBeanFactory focusBeanFactory() {
		return new FocusBeanFactory();
	}
	
	/**
	 * @description 创建 FocusBeanFactory 工厂bean 
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return FocusBeanFactory Bean 
	 */
	@Bean
	public Focus focus(FocusBeanFactory focusBeanFactory) {
		return focusBeanFactory.createrFocus();
	}
}
