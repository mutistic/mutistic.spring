package com.mutistic.annotation.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.mutistic.utils.CommonConstant;

/**
 * @program BeanPostProcessor 演示bean
 * @description bean加载方法执行顺序： 属性设置 > BeanPostProcessor.postProcessBeforeInitialization > initial > BeanPostProcessor.postProcessAfterInitialization
 * @author mutisitic
 * @date 2018年6月12日
 */
public class TestBean {

	
	private ApplicationContext applicationContext;
	
	@Autowired // @Autowired 不仅可以设置在属性上，也可以设置在方法方实现bean的自动注入
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		CommonConstant.printPref("TestBean 属性设置(自动注入 ApplicationContext)", this.applicationContext);
	}


	/**
	 * @description 声明initial方法
	 * @author mutisitic
	 * @date 2018年6月121日
	 */
	public void initial() {
		CommonConstant.printPref("TestBean initial", TestBean.class);
	}
	
}
