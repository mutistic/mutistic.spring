package com.mutistic.annotation.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonConstant;

/**
 * @program 实现 上下文的基础bean BeanFactoryPostProcessor 接口
 * @description 实现 BeanFactoryPostProcessor.postProcessBeanFactory() 方法
 * @author mutisitic
 * @date 2018年6月13日
 */
@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	
	/**
	 * 1、公共接口BeanFactoryPostProcessor。只会执行一次。
	 * 2、允许自定义修改应用程序上下文的bean定义，调整上下文的基础bean工厂的bean属性值。
	 * 3、应用程序上下文可以在其bean定义中自动检测BeanFactoryPostProcessor bean，并在创建任何其他bean之前应用它们。
	 * 4、对于定制配置文件非常有用，这些文件针对系统管理员，覆盖应用程序上下文中配置的bean属性。
	 * 5、请参阅PropertyResourceConfigurer及其具体实现，了解解决此类配置需求的开箱即用解决方案。
	 * 6、BeanFactoryPostProcessor可能与bean定义交互并修改，但永远不会bean实例。这样做可能会导致bean过早实例化，违反容器并导致意想不到的副作用。如果需要bean实例交互，请考虑实现 BeanPostProcessor
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
		CommonConstant.printTwo("自定义实现类重写 BeanFactoryPostProcessor.postProcessBeanFactory", beanFactory);
		
		CommonConstant.printThree("自定义实现类 从 ConfigurableListableBeanFactory 中获取Spring bean的数量", beanFactory.getBeanDefinitionCount());
		for(String name : beanFactory.getBeanDefinitionNames()) {
			CommonConstant.printThree("自定义实现类 从 ConfigurableListableBeanFactory 中获取Spring bean的name", name);
		}
	}

}
