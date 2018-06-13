package com.mutistic.annotation.processor;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonConstant;

/**
 * @program 实现 ApplicationContext 的注入
 * @description 1、通过@Autowired或@Resource注解自动注入。2、通过 ApplicationContextAware.setApplicationContext()接口方法注入。3、通过spring4.3的新特性 构造函数 自动注入。
 * @author mutisitic
 * @date 2018年6月12日
 */
@Component
public class TestApplicationContextAware implements ApplicationContextAware {

	/**
	 * 1、通过@Autowired或@Resource注解自动注入
	 */
	@Autowired // 使用 spring  @Autowired 自动注入bean
//	@Resource  // 使用 JSR-250 @Resource:javax.annotation.Resource 自动注入bean
	private ApplicationContext applicationContextByAuto;

	/**
	 * 2、通过 ApplicationContextAware.setApplicationContext()接口方法注入 
	 */
	private ApplicationContext applicationContextByImpl;
	
	/**
	 * 3、通过spring4.3的新特性 构造函数 自动注入
	 */
	private ApplicationContext applicationContextByCtor;
	
	/**
	 * @description 2、通过 ApplicationContextAware.setApplicationContext()接口方法注入 
	 * @author mutisitic
	 * @date 2018年6月12日
	 * @param applicationContext
	 * @throws BeansException
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		/**
		 * spring在bean初始化之后判断是否是 实现了ApplicationContextAware接口，如是则通过 setApplicationContext 方法将 ApplicationContext 注入到bean中。
		 */
		this.applicationContextByImpl = applicationContext;
	}

	
	/**
	 * @description 3、通过spring4.3的新特性 构造函数 自动注入
	 * @author mutisitic
	 * @date 2018年6月12日
	 * @return
	 */
	public TestApplicationContextAware(ApplicationContext applicationContextByCtor) {
	// public TestRegisterContext(ApplicationContext applicationContextByCtor, TestController testController) {
		/**
		 * 通过构造函数自动注入的局限性：
		 * 1、本类只能有一个构造函数，存在多个的话则会调去默认构造函数，则会导致 ApplicationContext无法实现自动注入。
		 * 2、构造函数参数个数无要求，但是参数要求spring容器中有对应bean，bean的可以是一个或多个。
		 */
		this.applicationContextByCtor = applicationContextByCtor;
	}


	public void show() {
		CommonConstant.printPref("1、通过@Autowired或@Resource注解自动注入", applicationContextByAuto);
		CommonConstant.printPref("2、通过 ApplicationContextAware.setApplicationContext()接口方法注入", applicationContextByImpl);
		CommonConstant.printPref("3、通过通过spring4.3的新特性 构造函数 自动注入", applicationContextByCtor);
		boolean isSingleton = (applicationContextByAuto == applicationContextByImpl) == (applicationContextByImpl == applicationContextByCtor);
		CommonConstant.printPref("ApplicationContext 是否是单例模式", isSingleton);
	}
}
