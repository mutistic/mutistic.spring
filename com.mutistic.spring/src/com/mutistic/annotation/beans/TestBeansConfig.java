package com.mutistic.annotation.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.mutistic.utils.CommonUtil;

/**
 * @program bean组件扫描 引导@Configuration类
 * @description 开启组件扫描
 * @author mutisitic
 * @date 2018年6月5日
 */
@Configuration
public class TestBeansConfig {
	
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
	 * @description 通过@Bean直接创建 bean
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return AnnotationTestBean Bean
	 */
	@Bean(name = "annotationTestBean") // 指定 bean 的具体名称
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //  指定bean 的作用域范围：单例，非单例，request，session
	public TestAnnotationBean createrAnnotationTestBean() {
		return new TestAnnotationBean();
	}
	
	/**
	 * @description 通过 FactoryBean<T>接口实现类 创建工厂 bean
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return RunnableFactory Bean
	 */
	@Bean({"createrRunnableFactory", "runnableFactory"}) // 指定bean 多个名称
	public RunnableFactory createrRunnableFactory() {
		return new RunnableFactory();
	}
	
	/**
	 * @description 通过 FactoryBean<T>接口实现类 创建工厂 bean
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return JeepBeanFactory Bean 
	 */
	@Bean // 指定 bean 默认为方法名
	public JeepBeanFactory jeeptBeanFactory() {
		return new JeepBeanFactory();
	}
	
	
	/**
	 * @description 通过简单工厂类 创建工厂 bean 
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return FocusBeanFactory Bean 
	 */
	@Bean // 指定一个bean 其name默认为方法名
	@Primary // 声明同类型bean为其主bean
	public FocusBeanFactory focusBeanFactory() {
		return new FocusBeanFactory();
	}
	
	/**
	 * @description 通过简单工厂类 创建工厂 bean 
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return FocusBeanFactory Bean 
	 */
	@Bean
	@Profile("dev") // 指定当一个或多个指定的配置文件处于活动状态时，组件可以注册。
//	@Profile({"dev", "test"}) 
//	@Profile(value = {"dev", "test"})
	public FocusBeanFactory craeterFocusBeanFactory() {
		return new FocusBeanFactory();
	}
	
	/**
	 * @description 通过简单工厂类 创建 实体bean 
	 * @author mutisitic
	 * @date 2018年6月11日
	 * @param focusBeanFactory 自动注入(没有创建：则无法注入。创建多个同类型bean可以使用 @Qualifier 指定具体一个bean)
	 * @return Focus Bean
	 */
	@Bean
	public Focus focus(/*@Qualifier("focusBeanFactory")*/ FocusBeanFactory focusBeanFactory) {
		System.out.println(CommonUtil.LINE_SHORT +"FocusBeanFactory = "+ focusBeanFactory);
		return focusBeanFactory.createrFocus();
	}
}
