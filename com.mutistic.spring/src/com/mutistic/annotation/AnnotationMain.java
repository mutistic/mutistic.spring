package com.mutistic.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mutistic.annotation.beans.TestBeansConfig;
import com.mutistic.annotation.beans.TestAnnotationBean;
import com.mutistic.annotation.id.IDConfig;
import com.mutistic.annotation.note.TestAspect;
import com.mutistic.annotation.note.TestController;
import com.mutistic.annotation.note.TestRepositoryDao;
import com.mutistic.annotation.note.TestService;
import com.mutistic.utils.CommonConstant;

/**
 * @program AnnotationConfigApplicationContext 几种注册与发现 bean
 * @description 1、通过加载 @Configuration 注解类（配置类）实现bean的注册。2、通过加载 Class 实现bean的注册。3、通过加载 @ComponentScan 注解 Class（扫描类） 实现bean的注册
 * @author mutisitic
 * @date 2018年6月11日
 */
public class AnnotationMain {

	public static void main(String[] args) {
		CommonConstant.println();
		getBeanByConfigClass();
		getBeanByClass();
		getBeanByScanClass();
	}

	/**
	 * @description 通过加载 @Configuration 注解类（配置类）实现bean的注册
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	private static void getBeanByConfigClass() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);

		CommonConstant.printLine("通过加载 @Configuration 配置类实现bean的注册");
		CommonConstant.printPref("@Configuration 配置类 注册的bean", ctx.getBean(Runnable.class));

		CommonConstant.printLine("通过加载 @Configuration 配置类实现bean的注册-end");
		ctx.close();
	}

	/**
	 * @description 通过加载 Class 实现bean的注册
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	private static void getBeanByClass() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class,
				TestController.class, TestService.class, TestRepositoryDao.class, TestAspect.class, TestAnnotationBean.class);

		CommonConstant.printLine("通过加载 Class 实现bean的注册");
		CommonConstant.printPref("@Configuration bean",ctx.getBean(AnnotationConfig.class));
		CommonConstant.printPref("@Controller bean", ctx.getBean(TestController.class));
		CommonConstant.printPref("@Service bean", ctx.getBean(TestService.class));
		CommonConstant.printPref("@Repository bean",ctx.getBean(TestRepositoryDao.class));
		CommonConstant.printPref("@TestAspect bean",ctx.getBean(TestAspect.class));
		CommonConstant.printPref("无任何注解 bean", ctx.getBean(TestAnnotationBean.class));

		CommonConstant.printLine("通过加载 Class 实现bean的注册-end");
		ctx.close();
	}
	
	/**
	 * @description 通过加载 @ComponentScan 注解 Class（扫描类） 实现bean的注册
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	private static void getBeanByScanClass() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationScan.class);

		CommonConstant.printLine("通过加载 @ComponentScan Class 实现bean的注册");
		CommonConstant.printPref("无任何注解 bean", ctx.getBean(TestAnnotationBean.class));
		CommonConstant.printPref("@Configuration 注解 bean", ctx.getBean(IDConfig.class));
		CommonConstant.printPref("@Repository 注解 bean", ctx.getBean(TestRepositoryDao.class));
		CommonConstant.printPref("@Aspect 注解 bean", ctx.getBean(TestAspect.class));
		CommonConstant.printLine("通过加载 Class 实现bean的注册-end");
		ctx.close();
	}
	
	
}
