package com.mutistic.annotation.register;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mutistic.utils.CommonConstant;

/**
 * @program AnnotationConfigApplicationContext Main类
 * @description 使用 独立的应用程序上下文 实现bean的注册和获取 ：演示 @Component，@Service，@Controller 等方式
 * @author mutisitic
 * @date 2018年6月11日
 */
public class AnnotationMainByRegister {

	public static void main(String[] args) {
		CommonConstant.PRINTLN();
		getBeanByAnnotationClass();
	}
	
	
	private static void getBeanByAnnotationClass() {
		CommonConstant.PRINTLINE();
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TestComponentBean.class);
		context.refresh();
		
		System.out.println(CommonConstant.PRINT_PREF +"使用 @Component注解的bean：class获取"+ context.getBean(TestComponentBean.class));
		System.out.println(CommonConstant.PRINT_PREF +"使用 @Component注解的bean：name获取"+ context.getBean("testComponentBean", TestComponentBean.class));
		context.getBean(TestComponentBean.class).show();
		
		context.close();
	}
	
}
