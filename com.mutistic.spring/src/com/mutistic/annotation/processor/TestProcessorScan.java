package com.mutistic.annotation.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mutistic.annotation.processor")
public class TestProcessorScan {

	@Bean(initMethod="initial")
	public TestBean testBean() {
		return new TestBean();
	}
	
}
