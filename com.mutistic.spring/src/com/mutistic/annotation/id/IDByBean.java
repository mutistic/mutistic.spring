package com.mutistic.annotation.id;

import org.springframework.context.annotation.Bean;

import com.mutistic.utils.CommonConstant;

/**
 * @program 使用@Bean initMethod和destroyMethod 指定具体的方法
 * @description @Bean#initMethod 指定初始化方法。 @Bean#destroyMethod 指定销毁方法
 * @author mutisitic
 * @date 2018年6月11日
 */
public class IDByBean {

	/**
	 * @description 声明initial方法-对指定bean生效
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	public void initial() {
		System.out.println(CommonConstant.LINE_SHORT + "IDByBean： @Bean initMethod 指定initial"+ CommonConstant.LINE_SHORT);
	}

	/**
	 * @description 声明destroy方法-对指定bean生效
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	public void destroy() {
		System.out.println(CommonConstant.LINE_SHORT + "IDByBean： @Bean destroyMethod 指定destroy"+ CommonConstant.LINE_SHORT);		
	}
	
}
