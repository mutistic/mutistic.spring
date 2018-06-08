package com.mutistic.annotation;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program Runnable FactotyBean 简单工厂类
 * @description 使用工厂类实现 org.springframework.beans.factory.FactoryBean<T> 创建bean实例，重写 getObject(); getObjectType(); isSingleton();
 * @author mutisitic
 * @date 2018年6月5日
 */
public class RunnableFactory implements FactoryBean<Runnable> {

	/**
	 * @description 获取 FactoryBean 创建的bean实例
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return Runnable 实例bean
	 * @throws Exception
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public Runnable getObject() throws Exception {
		return () -> {};
	}

	/**
	 * @description 获取创建实例的类型
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return Runnable.class
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		return Runnable.class;
	}

	/**
	 * @description 是否是单例模式(true：单例)(false：非单例)
	 * @author mutisitic
	 * @date 2018年6月5日
	 * @return 是否是单例模式
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
