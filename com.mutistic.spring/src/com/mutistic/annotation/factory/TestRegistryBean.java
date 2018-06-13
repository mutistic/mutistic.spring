package com.mutistic.annotation.factory;

/**
 * @program 配合演示 BeanDefinitionRegistryPostProcessor 动态注入bean 的普通类
 * @description 
 * @author mutisitic
 * @date 2018年6月13日
 */
public class TestRegistryBean {

	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "TestRegistryBean [property=" + property + "]";
	}
	
}
