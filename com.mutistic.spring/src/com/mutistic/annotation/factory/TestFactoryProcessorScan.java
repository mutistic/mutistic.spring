package com.mutistic.annotation.factory;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program Bean Factory Processor 配置扫描类 
 * @description 
 * @author mutisitic
 * @date 2018年6月13日
 */
@Configuration
@ComponentScan("com.mutistic.annotation.factory")
public class TestFactoryProcessorScan {

	@Bean(initMethod="initail")
	public TestAwareBean testProcBean() {
		return new TestAwareBean();
	}
	
}
