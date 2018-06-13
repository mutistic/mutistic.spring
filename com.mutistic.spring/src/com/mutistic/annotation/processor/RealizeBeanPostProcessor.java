package com.mutistic.annotation.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonConstant;

/**
 * @program 配合模拟 ApplicationContextAware的接口功能 之 BeanPostProcessor实现类
 * @description 实现逻辑参考：AbstractApplicationContext.prepareBeanFactory()  > ConfigurableListableBeanFactory.addBeanPostProcessor() > ApplicationContextAwareProcessor
 * @author mutisitic
 * @date 2018年6月12日
 */
@Component
public class RealizeBeanPostProcessor implements BeanPostProcessor {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		CommonConstant.printTwo("RealizeApplicationContextAware > RealizeBeanPostProcessor.postProcessBeforeInitialization", bean);
		
		if(bean instanceof RealizeApplicationContextAware) {
			RealizeApplicationContextAware aware = (RealizeApplicationContextAware)bean;
			aware.setApplicationContext(applicationContext);
			CommonConstant.printTwo("RealizeApplicationContextAware >  实现ApplicationContext的注入", bean);
		}
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		CommonConstant.printTwo("RealizeApplicationContextAware > RealizeBeanPostProcessor.postProcessAfterInitialization", bean);
		return bean;
	}
	
}
