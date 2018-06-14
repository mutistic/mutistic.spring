package com.mutistic.beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mutistic.utils.CommonConstant;

/**
 * @program 演示 SpringApplication.run() 返回 ConfigurableApplicationContext，然后通过Context获取容器中的bean
 * @description 
 * @author mutisitic
 * @date 2018年6月14日
 */
@SpringBootApplication
public class MainBySpringApplication {
	
	@Bean
	public Runnable craterRunnable() {
		return () -> {};
	}
	
	public static void main(String[] args) {
		CommonConstant.printOne("@SpringBootApplication Demo启动类：");
		
		ConfigurableApplicationContext context = SpringApplication.run(MainBySpringApplication.class, args);
		CommonConstant.printTwo("ConfigurableApplicationContext 获取bean：Runnable.class", context.getBean(Runnable.class));
		
		CommonConstant.println();
	}
}
