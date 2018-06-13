package com.mutistic.annotation.processor;

import org.springframework.context.ApplicationContext;

import com.mutistic.utils.CommonConstant;

/**
 * @program 配合模拟 ApplicationContextAware的接口功能 之 Bean实现类
 * @description 
 * @author mutisitic
 * @date 2018年6月12日
 */
public class RealizeBean implements RealizeApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		CommonConstant.printTwo("RealizeApplicationContextAware.setApplicationContext", applicationContext);
		this.applicationContext = applicationContext;
	}

	public void show() {
		CommonConstant.printTwo("RealizeApplicationContextAware > RealizeBean", applicationContext);
	}

}
