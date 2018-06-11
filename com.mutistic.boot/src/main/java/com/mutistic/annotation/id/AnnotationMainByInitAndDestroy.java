package com.mutistic.annotation.id;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mutistic.utils.CommonConstant;

/**
 * @program AnnotationConfigApplicationContext Main 演示 initial(初始化) 和 destroy(销毁)方法
 * @description 1、通过InitializingBean和DisposableBean接口方式实现。2、使用@Bean initMethod和destroyMethod 指定具体的方法。3、使用JSR-250@PostConstruct和@PreDestroy方式指定
 * @author mutisitic
 * @date 2018年6月11日
 */
public class AnnotationMainByInitAndDestroy {

	public static void main(String[] args) {
		CommonConstant.println();
		getBeanByConfig();
	}
	
	
	private static void getBeanByConfig() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(IDConfig.class);
		context.refresh();
		
		CommonConstant.printline("使用AnnotationConfigApplicationContext演示 init 和 destroy方法：");
		System.out.println(CommonConstant.PRINTLN_PREF +"通过InitializingBean和DisposableBean接口方式实现："+ context.getBean(IDByInterface.class));
		System.out.println(CommonConstant.PRINTLN_PREF +"@Bean initMethod和destroyMethod 指定具体的方法："+ context.getBean(IDByBean.class));
		System.out.println(CommonConstant.PRINTLN_PREF +"使用JSR-250@PostConstruct和@PreDestroy方式指定："+ context.getBean(IDByJSR250.class));
		
		context.close(); // 资源关闭后调用 DisposableBean.destroty(); bean销毁方法
	}
	
}
