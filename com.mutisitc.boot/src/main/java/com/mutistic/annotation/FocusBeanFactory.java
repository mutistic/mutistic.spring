package com.mutistic.annotation;

/**
 * @program Focus 简单工厂类
 * @description 工厂类实现创建具体bean方法，config使用 @Bean 注解实现工厂类bean的创建方法，confgi使用 @Bean 注解实现具体bean的创建方法，入参为 工厂类（会自动搜索工厂类bean）。
 * @author mutisitic
 * @date 2018年6月5日
 */
public class FocusBeanFactory {

	public Focus createrFocus() {
		return new Focus();
	}
	
}
