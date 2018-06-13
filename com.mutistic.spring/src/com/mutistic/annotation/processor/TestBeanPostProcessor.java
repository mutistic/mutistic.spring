package com.mutistic.annotation.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonConstant;

/**
 * @program BeanPostProcessor在每个bean初始化的时候调用一次
 * @description Bean的后置处理器
 * @author mutisitic
 * @date 2018年6月12日
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

	/**
	 * 允许自定义修改新bean实例的工厂挂钩，例如检查标记接口或用代理包装它们。
	 * ApplicationContexts可以在其bean定义中自动检测BeanPostProcessor bean，并将它们应用于随后创建的任何bean。工厂允许对后处理程序进行程序注册，适用于通过该工厂创建的所有bean。
	 * 通常，通过标记接口等来填充bean的后置处理器将实现postProcessBeforeInitialization(java.lang.Object, java.lang.String)，
	 * 而用代理来包装bean的后置处理器通常将实现postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */

	/**
	 * @description 在所有bean初始化之前回调，在bean 属性设置（依赖配置）之后，init方法之前执行（init也是在属性设置之后执行）
	 * @author mutisitic
	 * @date 2018年6月12日
	 * @param bean 新的bean实例
	 * @param beanName 这个bean的名字
	 * @return 要使用的bean实例，无论是原始的还是包装的; 如果null，将不会调用后续的BeanPostProcessors
	 * @throws BeansException
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		/**
		 * 1、在任何bean初始化回调（如InitializingBean's afterPropertiesSet 或自定义init方法）之前，  将此BeanPostProcessor应用于给定的新bean实例。
		 * 2、这个bean已经被填充了属性值。返回的bean实例可能是原始包装，或代理对象。	
		 * 3、默认实现返回给定的bean原样
		 */
		CommonConstant.printPref("BeanPostProcessor.postProcessBeforeInitialization", bean);
		
		if(bean instanceof TestBean) {
			CommonConstant.printPref("postProcessBeforeInitialization可以对bean做一些处理：例如返回的bean实例可能是原始包装，或代理对象", bean);
			return new TestBeanExtend();
		}
		
		return bean; // BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	/**
	 * @description 在bean初始化之后回调，在bean init方法之后执行
	 * @author mutisitic
	 * @date 2018年6月12日
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		/**
		 * 1、在 Bean初始化回调（如InitializingBean's afterPropertiesSet 或自定义init方法）之后，将此BeanPostProcessor应用于给定的新bean实例。
		 * 2、这个bean已经被填充了属性值。返回的bean实例可能是原始包装。
		 * 3、在FactoryBean的情况下，FactoryBean实例和由FactoryBean创建的对象（从Spring 2.0开始）都将调用此回调函数。
		 * 4、后处理器可以通过相应的bean instanceof FactoryBean检查决定是应用于FactoryBean还是应用于已创建的对象或两者。
		 * 5、InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation(java.lang.Class<?>, java.lang.String)与所有其他BeanPostProcessor回调相比，
		 * 	此回调也将在由方法触发的短路之后 调用。
		 * 6、默认实现返回给定的bean原样
		 */
		CommonConstant.printPref("BeanPostProcessor.postProcessAfterInitialization", bean);
		return bean; // BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
}
