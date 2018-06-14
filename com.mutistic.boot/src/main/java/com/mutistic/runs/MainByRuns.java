package com.mutistic.runs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mutistic.utils.CommonConstant;

/**
 * @program 通过@SpringBootApplication和SpringApplication 来启动spring boot
 * @description 1、 通过SpringApplication.run() 来启动spring boot。2、通过  new SpringApplication()，来启动spring boot
 * @author mutisitic
 * @date 2018年6月14日
 */
@SpringBootApplication
public class MainByRuns {

	public static void main(String[] args) {
		showSpringApplicationByStatic(args);
		showSpringApplicationByNew(args);
	}
	
	/**
	 * @description 用于测试的bean，能够直接装配bean，取决于 @SpringBootApplication 本身实现了 @SpringBootConfiguration注解，而@SpringBootConfiguration 实现  @Configuration
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @return
	 */
	@Bean
	public Runnable craterRunnable() {
		return () -> {
		};
	}

	/**
	 * @description 1、通过 SpringApplication.run() 来启动spring boot 
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showSpringApplicationByStatic(String[] args) {
		CommonConstant.printOne("1、通过  SpringApplication.run() 来启动spring boot，run()本身返回 ConfigurableApplicationContext，然后通过Context获取容器中的bean：");

		ConfigurableApplicationContext context = SpringApplication.run(MainByRuns.class, args);
		CommonConstant.printTwo("ConfigurableApplicationContext 获取bean：Runnable.class",
				context.getBean(Runnable.class));
		context.close();
		CommonConstant.println();
	}
	
	/**
	 * @description 2、通过 new SpringApplication()，来启动spring boot
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showSpringApplicationByNew(String[] args) {
		CommonConstant.printOne("2、通过 new SpringApplication()，来启动spring boot：");

		SpringApplication app = new SpringApplication(MainByRuns.class);
		ConfigurableApplicationContext context = app.run(args);
		CommonConstant.printTwo("ConfigurableApplicationContext 获取bean：Runnable.class",
				context.getBean(Runnable.class));
		context.close();
		CommonConstant.println();
	}

}
