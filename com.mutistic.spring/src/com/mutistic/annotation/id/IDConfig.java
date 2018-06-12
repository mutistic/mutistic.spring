package com.mutistic.annotation.id;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program initial AND destroy 配置类
 * @description
 * @author mutisitic
 * @date 2018年6月11日
 */
@Configuration
public class IDConfig {

	@Bean
	public IDByInterface idByImplements() {
		return new IDByInterface();
	}

	@Bean(initMethod = "initial", destroyMethod = "destroy") // 声明bean 指定其 init 和 destroy方法
	public IDByBean idByBean() {
		return new IDByBean();
	}
	
	@Bean
	public IDByJSR250 idByJSR250() {
		return new IDByJSR250();
	}

}
