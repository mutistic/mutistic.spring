# [Spring Boot](https://spring.io/projects/spring-boot)
此项目基于Craig Walls的《Spring Boot实战》一书。<br/>
使用的是Eclipse 集成的 STS插件自动创建的Spring Boot项目。<br/>
Spring Boot 是伴随着[Spring4.0](https://github.com/mutistic/mutistic.spring/blob/master/com.mutisitc.boot/src/main/java/com/mutistic/annotation/README.md)诞生的。<br/>

1、Spring Boot 是什么
```
1、Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。
2、该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。
3、通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者
```

2、Spring Boot 有什么用
```
1、Spring Boot的目的在于创建和启动新的基于Spring框架的项目。
2、Spring Boot会选择最适合的Spring子项目和第三方开源库进行整合。
3、大部分Spring Boot应用只需要非常少的配置就可以快速运行起来
4、Spring Boot是伴随着Spring4.0诞生的
5、Spring Boot提供了一种快速使用Spring的方式
```

3、Spring Boot 特点
```
1、为基于spring的开发提供更决的入门体验
2、创建可以独立运行的spring应用
3、直接嵌入Tomcat或Jetty服务器，不需要打包成WAR文件
4、提供推荐的基础POM文件（starter）来简化Apache Maven配置
5、尽可能的根据工页目依赖来自动配置spring框架
6、提供可以直接在生产环境中使用的功能，如性能指标、应用信息和应用亻建康检查
7、开箱即用，没有代码生成，也无需XML配置。同时也可以修改默认值来满足特定的需求
8、其他大量的项目都是基于spring Boot之上的，如Sping Cloud
```


4、Spring Boot 优点
```
1、Spring Bott 使编码变得简单
2、Spring Bott 使配置变得简单
3、Spring Bott 使部署变得简单
4、Spring Bott 使监控变得简单
```

5、Spring Boot 缺点
```
1、依赖太多，随便一个Spring Boot应用都有几十M到几百M（继承至spring-boot-starter-parent）。
2、缺少服务的注册和发现等解决方案
3、缺少监控集成方案、安全管理方案
4、中文的文档和资料太少且不够深入（有英文API）
```

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
### 一、DemoApplication.java：启动类<br/>
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
### 二、DemoApplicationTests.java：测试类<br/>
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

### 三、pom.xml：POM文件<br/>
3.1、配置项目基本信息：<br/>

```
<!-- 1、项目基本信息 -->
<groupId>com.mutistic</groupId>
<arrtifactId>com.mutistic.boot</artifactId>
<version>0.0.1-SNAPSHOT</version>
<packaging>jar</packaging>
<name>com.mutisitc.boot</name>
<description>此项目基于Craig Walls的《Spring Boot实战》一书。使用的是Eclipse 集成的 STS插件自动创建的Spring Boot项目</description>
```

```
name：项目名称。
groupId：项目组名。
arrtifactId：模板代码所在包名。
version：项目版本号：默认 0.0.1-SNAPASHOT。
packaging：打包方式：Jar / War。
description：项目描述信息。
Eclipse使用STS创建spring boot项目其他信息：
Service URL: https://start.spring.io  ： 默认Service URL。
Use default location / Location：项目所在路径。默认即可。
Type：构建方式：Maven / Gradel。
Language：开发语言：Java / Kotlin / Groovy。。
Java Version：Java版本号。
Package：项目包名。
Woring sets / Add project to workong sets：是否需要引入其他工作项目。
```

3.2：将spring-boot-starter-parent作为上一级，这样一来就能利用Maven的依赖管理功能，继承很多常用库的依赖版本，在声明依赖时就不用再去指定版本号了。<br/>

```
<!-- 2、从 spring-boot-starter-parent 继承版本号 -->
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.0.2.RELEASE</version>
	<relativePath/> <!-- lookup parent from repository -->
</parent>
```

3.3：起步依赖本质上是一个Maven项目对象模型（Project Object Model，POM），定义了对其他库的传递依赖，这些东西加在一起即支持某项功能。很多起步依赖的命名都暗示了它们提供的某种或某类功能 。<br/>

```
<!-- 3、起步依赖-->
<dependencies>
	<!-- Web：web项目 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<!-- Test：Junit测试 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
	<!-- JPA：在关系型数据库里持久化数据：application.propertions未配置DB和JPA信息的话，引入此包会报错 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-jpa</artifactId>
	</dependency>
	<!-- Thymeleaf：作为Web视图 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
	<!-- H2：h2数据库 -->
	<!-- <dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
	</dependency> -->
	<!-- Mysql：Mysql数据库 -->
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
	</dependency>
</dependencies>
```

3.4：配置文件和构建等编码格式和JDK版本信息等 。<br/>

```
<!-- 4、配置文件和构建等编码格式和JDK版本信息 -->
<properties>
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
	<java.version>1.8</java.version>
</properties>
```

3.5、配置构建信息：构建插件的主要功能是把项目打包成一个可执行的超级JAR（uber-JAR），包括把应用程序的所有依赖打入JAR文件内，并为JAR添加一个描述文件，其中的内容能让你用 java -jar 来运行应用程序。<br/>

```	
<!-- 5、配置spring boot 构建信息： maven -->
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```

### 四、application.properties：配置文件<br/>
```
#设置server信息
#设置Tomcat的监听端口
server.port=8888
#设置servlet上下文路径
server.servlet.context-path=/boot

#设置DB信息
#设置Mysql驱动类
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
#设置Mysql url地址
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/study
#设置Mysql username
spring.datasource.username=root
#设置Mysql password（无则为空）
spring.datasource.password=root


#设置JPA信息
#设置JPA hibernate.ddl-auto 配置信息
#ddl-auto:create----每次运行该程序，没有表格会新建表格，表内有数据会清空
#ddl-auto:create-drop----每次程序结束的时候会清空表
#ddl-auto:update----每次运行程序，没有表格会新建表格，表内有数据不会清空，只会更新
#ddl-auto:validate----运行程序会校验数据与数据库的字段类型是否相同，不同会报错
spring.jpa.hibernate.ddl-auto=create
#设置JPA 是否显示sql ： true显示，false不显示
spring.jpa.show-sql=true
```


## [spring boot 入坑总结](https://github.com/mutistic/mutistic.spring/tree/master/com.mutisitc.boot/notes/pit)<br/>
[pit1、spring boot之 maven install 报错[Maven]](https://github.com/mutistic/mutistic.spring/blob/master/com.mutisitc.boot/notes/pit/pit1_spring%20boot%E4%B9%8B%20maven%20install%20%E6%8A%A5%E9%94%99%5BMaven%5D.docx)<br/>
[pit2、pom.xml无法找到[Maven]](https://github.com/mutistic/mutistic.spring/blob/master/com.mutisitc.boot/notes/pit/pit2_pom.xml%E6%97%A0%E6%B3%95%E6%89%BE%E5%88%B0%5BMaven%5D.docx)<br/>
[pit3、引入spring-boot-starter-data-jpa 后启动项目报错[JPA]](https://github.com/mutistic/mutistic.spring/blob/master/com.mutisitc.boot/notes/pit/pit3_%E5%BC%95%E5%85%A5spring-boot-starter-data-jpa%20%E5%90%8E%E5%90%AF%E5%8A%A8%E9%A1%B9%E7%9B%AE%E6%8A%A5%E9%94%99%5BJPA%5D.docx)<br/>
[pit4、继承JpaRepository时报错[JPA]](https://github.com/mutistic/mutistic.spring/blob/master/com.mutisitc.boot/notes/pit/pit4_%E7%BB%A7%E6%89%BFJpaRepository%E6%97%B6%E6%8A%A5%E9%94%99%5BJPA%5D.docx)<br/>

## [sql](https://github.com/mutistic/mutistic.spring/tree/master/com.mutisitc.boot/notes/sql)
[ddl_creater_database_study](https://github.com/mutistic/mutistic.spring/blob/master/com.mutisitc.boot/notes/sql/ddl_creater_database_study.sql)



