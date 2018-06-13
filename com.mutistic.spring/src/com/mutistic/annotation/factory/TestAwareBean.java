package com.mutistic.annotation.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mutistic.utils.CommonConstant;

/**
 * @program 配合演示 BeanFactoryPostProcessor 自定义实现 执行顺序 的普通类
 * @description 
 * @author mutisitic
 * @date 2018年6月13日
 */
public class TestAwareBean implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	public void initail() {
		CommonConstant.printTwo("声明TestProcBean 的初始化方法initail", "实现bean的初始化");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		CommonConstant.printTwo("声明TestProcBean 的依赖配置", "自动注入ApplicationContext");
	}
	
}
