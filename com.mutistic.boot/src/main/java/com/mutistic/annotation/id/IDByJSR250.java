package com.mutistic.annotation.id;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.mutistic.utils.CommonConstant;

/**
 * @program 使用JSR-250@PostConstruct和@PreDestroy方式指定
 * @description @PostConstruct 指定 初始化方法。@PreDestroy 指定 销毁方法
 * @author mutisitic
 * @date 2018年6月11日
 */
public class IDByJSR250 {

	/**
	 * @description 声明initial方法-对指定bean生效
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	@PostConstruct
	public void initial() {
		System.out.println(CommonConstant.PRINTLN_PREF + "IDByJSR25 @PostConstruct 指定initial"+ CommonConstant.PRINT_PREF);
	}

	/**
	 * @description 声明destroy方法-对指定bean生效
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	@PreDestroy
	public void destroy() {
		System.out.println(CommonConstant.PRINTLN_PREF + "IDByJSR250 @PreDestroy 指定 destroy"+ CommonConstant.PRINT_PREF);		
	}
}
