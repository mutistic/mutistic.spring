# Spring Boot
此项目基于Craig Walls的《Spring Boot实战》一书，进行Spring Bott的练习项目。使用的是Eclipse 集成的 STS插件自动创建的Spring Boot项目。



## 目录结构说明：
1、.gradle、gradle、build.gradle、gradlew、gradlew.bat、settings.gradle：<br/>
Eclipse集成STS插件或Spring Boot CLI初始化应用程序，创建Spring Boot项目，采用Gradle打包发布软件时会生成这些与Gradle相关文件。<br/>
2、.mvn、mvnw、mvnw.cmd、pom.xml、.target：<br/>
Eclipse集成STS插件，创建Spring Boot项目，采用Maven打包发布软件时会生成这些与Maven相关文件。<br/>
3、application.properties：用于配置应用程序和Spring Boot的属性。<br/>
4、DemoApplication.java：模板类：应用程序的启动引导类（bootstrap class），也是主要的Spring配置类。<br/>
5、DemoApplicationTests.java：模板测试类：一个基本的集成测试类。<br/>
6、src/main/resources：项目文件资源主目录。<br/>
6.1、src/main/resources/static：静态文件资源目录，如css、js。<br/>
6.2、src/main/resources/templates：模板文件资源目录，如vm、excel。<br/>

## 注解及代码说明：
### 一、DemoApplication.java<br/>
```
package com.mutistic.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
```
1.1、@SpringBootApplication：开启(Spring)组件扫描和(Spring Boot)自动配置：<br/>
```
  实际上，@SpringBootApplication将三个有用的注解组合在了一起，早期版本1.2.0之前还是需要同时标注这三个注解。
  1、Spring的 @Configuration：标明该类使用Spring基于Java的配置。作为Java开发者会更倾向于使用基于Java而不是XML的配置。
  2、Spring的 @ComponentScan：启用组件扫描，这样Web控制器类和其他组件才能被自动发现并注册为Spring应用程序上下文里的Bean。
  3、Spring Boot的 @EnableAutoConfiguration：这个注解也可以称为 @Abracadabra，就是这一行配置开启了SpringBoot自动配置的功能，避免再写成篇的配置。
```
1.2、SpringApplication.run(DemoApplication.class,args)：负责启动引导应用程序：<br/>
```
  DemoApplication 本身还是一个启动引导类，提供main()方法。要运行Spring Boot应用程序有几种方式，其中包含传统的WAR文件部署。
  但这里的 main() 方法让你可以在命令行里把该应用程序当作一个可执行JAR文件来运行。
  这里向 SpringApplication.run() 传递了一个DemoApplication 类的引用，还有命令行参数，通过这些东西启动应用程序。
```
### 二、DemoApplicationTests.java<br/>
```
package com.mutistic.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles(profiles = "test")
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Demo Application Spring Boot Tests!");
	}

}
```
2.1、@RunWith(SpringRunner.class)：RunWith：运行器。SpringRunner.class：运行Spring测试环境<br/>
2.2、@SpringBootTest：SpringBoot自1.4.0版本开始引入的一个用于测试的注解。<br/>
```
  classes：属性指定具体的启动类。
  SpringBootTest.WebEnvironment.RANDOM_PORT 经常和测试类中 @LocalServerPort 一起在注入属性时使用。会随机生成一个端口号。
```
2.3、@ActiveProfiles(profiles = "test")：在测试类上面指定profiles，可以改变当前spring 的profile，来达到多环境的测试<br/>
