package com.mutistic.annotation.processor;

import org.springframework.beans.factory.Aware;
import org.springframework.context.ApplicationContext;

/**
 * @program 简单实现 ApplicationContextAware 接口功能
 * @description 使用 BeanPostProcessor 可以实现  ApplicationContextAware 注入 ApplicationContext的功能 
 * @author mutisitic
 * @date 2018年6月12日
 */
public interface RealizeApplicationContextAware {
// public interface RealizeApplicationContextAware extends Aware {

	void setApplicationContext(ApplicationContext applicationContext);
	
}
