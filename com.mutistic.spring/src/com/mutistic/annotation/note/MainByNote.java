package com.mutistic.annotation.note;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Controller;

import com.mutistic.annotation.processor.TestApplicationContextAware;
import com.mutistic.utils.CommonUtil;

/**
 * @program 通过 注解 的方式注册bean
 * @description 通过 @Component，@Repository，@Service，@Controller，@Aspect 等方式注册bean
 * @author mutisitic
 * @date 2018年6月11日
 */
public class MainByNote {

	public static void main(String[] args) {
		CommonUtil.println();
		getBeanByClass();
		getBeanByPackages();
		getBeanByScanClass();
	}
	
	/**
	 * @description 从给定的带注释的类中，自动刷新上下文
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	private static void getBeanByClass() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RegisterConfig.class, TestComponentBean.class, 
				TestRepositoryDao.class, TestService.class, TestController.class, TestAspect.class);

//		CommonConstant.printline("@Indexed注解");
//		System.out.println(CommonConstant.PRINT_PREF +"使用 @Indexed注解的bean：class获取"+ context.getBean(TestIndexed.class));
		
		CommonUtil.printOne("@Component注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Component注解的bean：class获取"+ context.getBean(TestComponentBean.class));
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Component注解的bean：name获取"+ context.getBean("testComponentBean", TestComponentBean.class));
		context.getBean(TestComponentBean.class).show();
		
		CommonUtil.printOne("@Repository注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Repository注解的(dao)bean：class获取"+ context.getBeansOfType(TestRepositoryDao.class));
		
		CommonUtil.printOne("@Service注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Service注解的(service)bean：class获取"+ context.getBean(TestService.class));
		
		CommonUtil.printOne("@Controller注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Controller注解的(controller)bean：class获取"+ context.getBean(TestController.class));
		
		CommonUtil.printOne("@Aspect注解"); 
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Aspect注解的bean：class获取"+ context.getBean(TestAspect.class));
		
		CommonUtil.println();
		context.close();
	}
	
	/**
	 * @description 在给定的包中，并自动刷新上下文
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	private static void getBeanByPackages() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.mutistic.annotation.register");
		
		CommonUtil.printOne("@Repository注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Repository注解的(dao)bean：class获取"+ context.getBeansOfType(TestRepositoryDao.class));
		
		CommonUtil.printOne("@Service注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Service注解的(service)bean：class获取"+ context.getBean(TestService.class));
		
		CommonUtil.printOne("@Controller注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Controller注解的(controller)bean：class获取"+ context.getBean(TestController.class));
		
		CommonUtil.println();
		context.close();
	}
	
	/**
	 * @description 在给定的扫描配置类中，并自动刷新上下文
	 * @author mutisitic
	 * @date 2018年6月11日
	 */
	private static void getBeanByScanClass() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RegisterScan.class);
		
		CommonUtil.printOne("@Repository注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Repository注解的(dao)bean：class获取"+ context.getBeansOfType(TestRepositoryDao.class));
		
		CommonUtil.printOne("@Service注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Service注解的(service)bean：class获取"+ context.getBean(TestService.class));
		
		CommonUtil.printOne("@Controller注解");
		System.out.println(CommonUtil.LINE_SHORT +"使用 @Controller注解的(controller)bean：class获取"+ context.getBean(TestController.class));
		
		CommonUtil.println();
		context.close();
	}
	
}
