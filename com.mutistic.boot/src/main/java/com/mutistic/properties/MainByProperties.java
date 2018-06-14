package com.mutistic.properties;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.mutistic.utils.CommonUtil;

/**
 * @program 获取 application.properties 声明的属性值
 * @description 
 * @author mutisitic
 * @date 2018年6月14日
 */
@SpringBootApplication
public class MainByProperties {
	public static void main(String[] args) {
		showPropertiesByConfigurableEnvironment(args);
		showPropertiesByEnvironment(args);
		showPropertiesByValue(args);
	}

	/**
	 * @description 1、通过ConfigurableApplicationContext.getEnvironment().getProperty()获取具体属性值
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesByConfigurableEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		
		CommonUtil.printOne("1.0、通过ConfigurableApplicationContext.getEnvironment().getProperty()获取指定属性值：");
		CommonUtil.printThree("获取 application.properties声明的属性：local.ip", env.getProperty("local.ip"));
		
		CommonUtil.printOne("1.1、通过ConfigurableApplicationContext.getSystemEnvironment()获取指定系统环境中的属性值：");
		Map<String, Object> systemMap = env.getSystemEnvironment();
		for (String key : systemMap.keySet()) {
			CommonUtil.printThree("获取系统环境中的属性："+key, systemMap.get(key));
		}
		
		context.close();
		CommonUtil.println();
	}
	
	/**
	 * @description 2、通过 自动注入 Environment 获取属性值
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesByEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		CommonUtil.printOne("2、通过 自动注入 Environment 的 getProperty() 获取属性值：");
		
		context.getBean(TestProperties.class).showByEvn();
		
		context.close();
		CommonUtil.println();
	}
	
	/**
	 * @description 2、通过 自动注入 Environment 获取属性值
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesByValue(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		CommonUtil.printOne("3、通过 @Value 自动注入 application.properties声明的属性：");
		
		context.getBean(TestProperties.class).showByValue();
		
		context.close();
		CommonUtil.println();
	}
	
}
