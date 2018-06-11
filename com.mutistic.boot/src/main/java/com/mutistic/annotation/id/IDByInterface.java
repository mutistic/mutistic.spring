package com.mutistic.annotation.id;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.mutistic.utils.CommonConstant;

/**
 * @program 使用实现接口方式实现 BeanFactory 的初始化 和销毁 动作
 * @description InitializingBean.afterPropertiesSet 指定初始化方法。DisposableBean.destroy 指定销毁方法
 * @author mutisitic
 * @date 2018年6月11日
 */
public class IDByInterface implements InitializingBean, DisposableBean {

	/**
	 * 
	 * @description 在它设置了所有bean属性之后，由BeanFactory调用（并满足了BeanFactoryAware和applicationcontext）。这个方法允许bean实例只执行初始化
	 * @author mutisitic
	 * @date 2018年6月11日
	 * @throws Exception
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(CommonConstant.PRINTLN_PREF + "IDByImplements implements InitializingBean.afterPropertiesSet"+ CommonConstant.PRINT_PREF);
	}

	/**
	 * 
	 * @description 由一个BeanFactory调用的销毁单例对象（context.close();资源释放后调用bean消费方法）
	 * @author mutisitic
	 * @date 2018年6月11日
	 * @throws Exception
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println(CommonConstant.PRINTLN_PREF + "IDByImplements implements DisposableBean.destroy"+ CommonConstant.PRINT_PREF);		
	}
	
}
