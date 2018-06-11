package com.mutistic.annotation.register;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @program Register 配置类
 * @description 
 * @author mutisitic
 * @date 2018年6月11日
 */
@Configuration
public class RegisterConfig {

	/**
	 * @description 创建多个TestRepositoryDao bean 实现 @Qualifier 注解具体指定bean
	 * @author mutisitic
	 * @date 2018年6月11日
	 * @return
	 */
	@Bean
	@Primary // 存在多个同类型的bean是，声明为主bean
	public TestRepositoryDao createrTestRepositoryDao() {
		return new TestRepositoryDao();
	}
	
}
