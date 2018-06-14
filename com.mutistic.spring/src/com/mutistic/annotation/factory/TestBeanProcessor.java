package com.mutistic.annotation.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonConstant;

/**
 * @program 实现 Bean的后置处理器  BeanFactoryPostProcessor 接口
 * @description BeanPostProcessor 在每个bean初始化的时候调用一次
 * @author mutisitic
 * @date 2018年6月13日
 */
@Component
public class TestBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		CommonConstant.printTwo("TestBeanPostProcessor 重写  BeanPostProcessor.postProcessBeforeInitialization", bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		CommonConstant.printTwo("TestBeanPostProcessor 重写  BeanPostProcessor.postProcessAfterInitialization", bean);
		return bean;
	}

}
