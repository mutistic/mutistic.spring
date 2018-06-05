package com.mutistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * @program Spring Boot Application 应用启动类
 * @description 标准的应用程序的启动引导类（bootstrap class），也是主要的Spring配置类
 * @author mutisitic
 * @date 2018年5月31日
 */
@SpringBootApplication
//@ServletComponentScan
public class Application extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
//		System.out.println(context.getBean(BookEntity.class));
	}
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addRedirectViewController("/", "/bookList");
    }
    
}
