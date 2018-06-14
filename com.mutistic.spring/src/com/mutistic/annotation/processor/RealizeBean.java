package com.mutistic.annotation.processor;

import org.springframework.context.ApplicationContext;

import com.mutistic.utils.CommonUtil;

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
		CommonUtil.printTwo("RealizeApplicationContextAware.setApplicationContext", applicationContext);
		this.applicationContext = applicationContext;
	}

	public void show() {
		CommonUtil.printTwo("RealizeApplicationContextAware > RealizeBean", applicationContext);
	}

}
