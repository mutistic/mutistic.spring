package com.mutistic.start.enable;

import org.springframework.context.annotation.Bean;

public class TestImportConfiguration {

	@Bean
	public TestBeanByImport createrTestBeanByImport() {
		return new TestBeanByImport();
	}
	
	
	@Bean
	public TestBeanByImport createrTestBeanByImport2() {
		return new TestBeanByImport();
	}
	
}
