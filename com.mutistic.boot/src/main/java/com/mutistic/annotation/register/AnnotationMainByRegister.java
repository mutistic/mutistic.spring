package com.mutistic.annotation.register;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Controller;

import com.mutistic.utils.CommonConstant;

/**
 * @program AnnotationConfigApplicationContext Main类
 * @description 演示 @Component，@Repository，@Service，@Controller，@Aspect 等方式注册bean
 * @author mutisitic
 * @date 2018年6月11日
 */
public class AnnotationMainByRegister {

	public static void main(String[] args) {
		CommonConstant.println();
		getBeanByClass();
	}
	
	
	private static void getBeanByClass() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestComponentBean.class, 
				TestRepositoryDao.class, TestService.class, TestController.class, TestAspect.class);

//		CommonConstant.printline("@Indexed注解");
//		System.out.println(CommonConstant.PRINT_PREF +"使用 @Indexed注解的bean：class获取"+ context.getBean(TestIndexed.class));
		
		CommonConstant.printline("@Component注解");
		System.out.println(CommonConstant.PRINT_PREF +"使用 @Component注解的bean：class获取"+ context.getBean(TestComponentBean.class));
		System.out.println(CommonConstant.PRINT_PREF +"使用 @Component注解的bean：name获取"+ context.getBean("testComponentBean", TestComponentBean.class));
		context.getBean(TestComponentBean.class).show();
		
		CommonConstant.printline("@Repository注解");
		System.out.println(CommonConstant.PRINT_PREF +"使用 @Repository注解的(dao)bean：class获取"+ context.getBean(TestRepositoryDao.class));
		
		CommonConstant.printline("@Service注解");
		System.out.println(CommonConstant.PRINT_PREF +"使用 @Service注解的(service)bean：class获取"+ context.getBean(TestService.class));
		
		CommonConstant.printline("@Controller注解");
		System.out.println(CommonConstant.PRINT_PREF +"使用 @Controller注解的(controller)bean：class获取"+ context.getBean(TestController.class));
		
		CommonConstant.printline("@Aspect注解");
		System.out.println(CommonConstant.PRINT_PREF +"使用 @Aspect注解的bean：class获取"+ context.getBean(TestAspect.class));
		
		CommonConstant.println();
		context.close();
	}
	
}
