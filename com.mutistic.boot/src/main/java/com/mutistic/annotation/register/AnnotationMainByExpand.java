package com.mutistic.annotation.register;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mutistic.utils.CommonConstant;

/**
 * @program AnnotationConfigApplicationContext Main类
 * @description 使用 独立的应用程序上下文 实现bean的注册和获取 ：演示 @Component，@Service，@Controller 等方式
 * @author mutisitic
 * @date 2018年6月11日
 */
public class AnnotationMainByExpand {

	public static void main(String[] args) {
		CommonConstant.PRINTLN();
		getBeanByAnnotationClass();
	}
	
	
	private static void getBeanByAnnotationClass() {
		CommonConstant.PRINTLINE();
		String pref = "使用AnnotationConfigApplicationContext获注册后，";
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TestComponentBean.class);
		context.refresh();
		
		System.out.println(CommonConstant.PRINTLN_PREF + pref +"使用 @Component注解的bean："+ context.getBean(TestComponentBean.class));
		context.getBean(TestComponentBean.class).show();
		
		context.close();
	}
	
}
