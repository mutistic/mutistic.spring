package com.mutistic.annotation.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonConstant;

/**
 * @program 演示 BeanDefinitionRegistryPostProcessor 的自定义实现类 的动态注册bean
 * @description BeanDefinitionRegistryPostProcessor 继承至 BeanFactoryPostProcessor
 * @author mutisitic
 * @date 2018年6月13日
 */
@Component
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	
	/**
	 * 扩展到标准BeanFactoryPostProcessor SPI，允许在正常的BeanFactoryPostProcessor检测开始之前注册更多的bean定义。
	 * 特别是，BeanDefinitionRegistryPostProcessor可以注册更多的bean定义，然后定义BeanFactoryPostProcessor实例
	 * 
	 * BeanDefinitionRegistryPostProcessor 可以拿到ConfigurableListableBeanFactory，BeanDefinitionRegistry对象。
	 * BeanDefinitionRegistry 可以动态注册bean
	 * BeanDefinitionBuilder 获取Bean的引用(class)，注入属性，后用于BeanDefinitionRegistry
	 */
	
	/**
	 * @description bean初始化后，修改应用程序上下文的内部bean工厂
	 * @author mutisitic
	 * @date 2018年6月13日
	 * @param beanFactory
	 * @throws BeansException
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		CommonConstant.printTwo("自定义实现类重写 BeanDefinitionRegistryPostProcessor.postProcessBeanFactory", beanFactory);
		
		CommonConstant.printThree("自定义实现类 从 ConfigurableListableBeanFactory 中获取Spring bean的数量", beanFactory.getBeanDefinitionCount());
		for(String name : beanFactory.getBeanDefinitionNames()) {
			CommonConstant.printThree("自定义实现类 从 ConfigurableListableBeanFactory 中获取Spring bean的name", name);
		}
	}

	/**
	 * @description 标准初始化后，修改应用程序上下文的内部bean定义注册表
	 * @author mutisitic
	 * @date 2018年6月13日
	 * @param registry
	 * @throws BeansException
	 * @see org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(org.springframework.beans.factory.support.BeanDefinitionRegistry)
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		CommonConstant.printTwo("自定义实现类重写 BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry", registry);
		
		for (int i = 0; i < 10; i++) {
			// 通过 BeanDefinitionBuilder 实现 bean类型的构建和属性的注入
			BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(TestRegistryBean.class);
			bdb.addPropertyValue("property", "注入属性值："+i);
			registry.registerBeanDefinition("beanName"+i, bdb.getBeanDefinition());
			
			CommonConstant.printThree("通过 BeanDefinitionRegistry和BeanDefinitionBuilder实现动态注册bean", registry);
		}
		
	}

}
