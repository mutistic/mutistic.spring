package com.mutistic.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program bean组件扫描 引导@Configuration类
 * @description 开启组件扫描
 * @author mutisitic
 * @date 2018年6月5日
 */
@Configuration
public class AnnotationConfig {
	
	@Bean
	public Runnable createrRunnable() {
		return () -> {};
	}
	
}
