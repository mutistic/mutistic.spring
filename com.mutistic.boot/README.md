# <a id="a_top">[Spring Boot](https://spring.io/projects/spring-boot)</a>
此项目基于Craig Walls的《Spring Boot实战》一书。<br/>
使用的是Eclipse 集成的 STS插件自动创建的Spring Boot项目。<br/>
Spring Boot 是伴随着[Spring4.0](https://github.com/mutistic/mutistic.spring/blob/master/com.mutistic.spring/README.md)诞生的。<br/>

[spring Boot API](https://docs.spring.io/spring-boot/docs/current/api)<br/>
[spring Boot API-无框架](https://docs.spring.io/spring-boot/docs/current/api/overview-summary.html)<br/>
[Spring Boot Actuator Web API.PDF](https://docs.spring.io/spring-boot/docs/current/actuator-api/pdf/spring-boot-actuator-web-api.pdf)<br/>
[Spring Boot 参考指南](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html)<br/>

---
### <a id="a_catalogue">目录</a>：
1. <a href="#a_springBoot">Spring Boot概述</a>
2. <a href="#a_info">Spring Boot目录结构说明：</a>
3. <a href="#a_springBootApplication">@SpringBootApplication启动类 ：开启(Spring)组件扫描和(Spring Boot)自动配置</a>
4. <a href="#a_demoApplicationTests">DemoApplicationTests.java：测试类</a>
5. <a href="#a_pom">pom.xml：POM配置文件</a>
6. <a href="#a_applicationProperties">application.properties：配置文件</a>
7. <a href="#a_getproperties">获取默认配置文件或其他配置文件声明的属性值</a>
8. <a href="#a_profile">设置需要激活配置文件</a>
9. <a href="#a_condition">使用 @Conditional 和 Condition 组合实现基于条件的自动装配bean</a>
10. <a href="#a_enable">使用 @Eable启用特性</a>
97. <a href="#a_pit">spring boot 入坑总结</a>
98. <a href="#a_sql">sql</a>
99. <a href="#a_down">down</a>

---
## <a id="a_springBoot">Spring Boot概述：</a>

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

## <a id="a_info">Spring Boot目录结构说明：</a>
1、.gradle、gradle、build.gradle、gradlew、gradlew.bat、settings.gradle：<br/>
Eclipse集成STS插件或Spring Boot CLI初始化应用程序，创建Spring Boot项目，采用Gradle打包发布软件时会生成这些与Gradle相关文件。<br/>
2、.mvn、mvnw、mvnw.cmd、pom.xml、.target：<br/>
Eclipse集成STS插件，创建Spring Boot项目，采用Maven打包发布软件时会生成这些与Maven相关文件。<br/>
3、application.properties：用于配置应用程序和Spring Boot的属性。<br/>
4、DemoApplication.java：模板类启动类：应用程序的启动引导类（bootstrap class），也是Spring配置类。<br/>
5、DemoApplicationTests.java：模板测试类：一个基本的集成测试类。<br/>
6、src/main/resources：项目文件资源主目录。<br/>
6.1、src/main/resources/static：静态文件资源目录，如css、js。<br/>
6.2、src/main/resources/templates：模板文件资源目录，如vm、excel。<br/>

### <a id="a_springBootApplication">一、@SpringBootApplication启动类 ：开启(Spring)组件扫描和(Spring Boot)自动配置：</a>
@SpringBootApplication：[org.springframework.boot.autoconfigure.SpringBootApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html)

@SpringBootConfiguration：[org.springframework.boot.SpringBootConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringBootConfiguration.html)

@ComponentScan：[org.springframework.context.annotation.ComponentScan](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html)

@EnableAutoConfiguration：[org.springframework.boot.autoconfigure.EnableAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/EnableAutoConfiguration.html)

SpringApplication：[org.springframework.boot.SpringApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html)

ConfigurableApplicationContext：[org.springframework.context.ConfigurableApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/ConfigurableApplicationContext.html)

1.1、@SpringBootApplication：开启(Spring)组件扫描和(Spring Boot)自动配置：

```
1、指示configuration声明一个或多个@Bean方法以及触发器auto-configuration和类的类 component scanning。
2、这是一个便利的注释，则等于声明@Configuration， @EnableAutoConfiguration和@ComponentScan
    2.1、实际上，@SpringBootApplication将三个有用的注解组合在了一起，早期版本1.2.0之前还是需要同时标注这三个注解。
    2.2、Spring的 @Configuration：标明该类使用Spring基于Java的配置。作为Java开发者会更倾向于使用基于Java而不是XML的配置。
    2.3、Spring的 @ComponentScan：启用组件扫描，这样Web控制器类和其他组件才能被自动发现并注册为Spring应用程序上下文里的Bean。    
    2.4、Spring Boot的 @EnableAutoConfiguration：这个注解也可以称为@Abracadabra，就是这一行配置开启了SpringBoot自动配置的功能，避免再写成篇的配置。
```

MainBySpringApplication.java

```Java
package com.mutistic.beans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.mutistic.utils.CommonConstant;
// 通过@SpringBootApplication和SpringApplication 来启动spring boot
// 通过SpringApplication.run() 来启动spring boot。2、通过  new SpringApplication()，来启动spring boot
@SpringBootApplication
public class MainBySpringApplication {
	public static void main(String[] args) {
		showSpringApplicationByStatic(args);
		showSpringApplicationByNew(args);
	}

	// 用于测试的bean，能够直接装配bean，取决于 @SpringBootApplication 本身实现了 @SpringBootConfiguration注解，而@SpringBootConfiguration 实现  @Configuration
	@Bean
	public Runnable craterRunnable() { return () -> {}; }

	// 1、演示 SpringApplication.run() 来启动spring boot 
	private static void showSpringApplicationByStatic(String[] args) {
		CommonConstant.printOne("1、通过  SpringApplication.run() 来启动spring boot，run()本身返回 ConfigurableApplicationContext，然后通过Context获取容器中的bean：");
		ConfigurableApplicationContext context = SpringApplication.run(MainBySpringApplication.class, args);
		CommonConstant.printTwo("ConfigurableApplicationContext 获取bean：Runnable.class",
				context.getBean(Runnable.class));
		context.close();
	}
	
	// 2、通过 new SpringApplication()，来启动spring boot
	private static void showSpringApplicationByNew(String[] args) {
		CommonConstant.printOne("2、通过 new SpringApplication()，来启动spring boot：");

		SpringApplication app = new SpringApplication(MainBySpringApplication.class);
		ConfigurableApplicationContext context = app.run(args);
		CommonConstant.printTwo("ConfigurableApplicationContext 获取bean：Runnable.class",
				context.getBean(Runnable.class));
		context.close();
	}
}

```

SpringBooApplication.java：

```Java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = {
		@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication { }
```

1.2、方法说明：

1.2.1、public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args)<br/>
静态方法可以使用默认设置和用户提供的参数从指定的数据源运行SpringApplication。（args 通常从Java mian方法传递）



---
### <a id="a_demoApplicationTests">二、DemoApplicationTests.java：测试类：</a>
@SpringBootTest [org.springframework.boot.test.context.SpringBootTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html)

@ActiveProfiles [org.springframework.test.context.ActiveProfiles](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/context/ActiveProfiles.html)

@SpringRunner [org.springframework.test.context.junit4.SpringRunner](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/context/junit4/SpringRunner.html)

DemoApplicationTests.java：

```Java
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

---
### <a id="a_pom">三、pom.xml：POM配置文件</a>
3.1、配置项目基本信息：<br/>

```xml
<!-- 1、项目基本信息 -->
<groupId>com.mutistic</groupId>
<arrtifactId>com.mutistic.boot</artifactId>
<version>0.0.1-SNAPSHOT</version>
<packaging>jar</packaging>
<name>com.mutistic.boot</name>
<description>此项目基于Craig Walls的《Spring Boot实战》一书。使用的是Eclipse 集成的 STS插件自动创建的Spring Boot项目</description>
```

属性说明：

```
name：项目名称。
groupId：项目组名。
arrtifactId：模板代码所在包名。
version：项目版本号：默认 0.0.1-SNAPASHOT。
packaging：打包方式：Jar / War。
description：项目描述信息。
```

Eclipse使用STS创建spring boot项目其他信息：

```
Service URL: https://start.spring.io  ： 默认Service URL。
Use default location / Location：项目所在路径。默认即可。
Type：构建方式：Maven / Gradel。
Language：开发语言：Java / Kotlin / Groovy。
Java Version：Java版本号。
Package：项目包名。
Woring sets / Add project to workong sets：是否需要引入其他工作项目。
```

3.2：配置文件和构建等编码格式和JDK版本信息等 。<br/>
properties标签：

```xml
<properties>
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
	<java.version>1.8</java.version>
</properties>
```

3.3、配置构建信息：构建插件的主要功能是把项目打包成一个可执行的超级JAR（uber-JAR），包括把应用程序的所有依赖打入JAR文件内，并为JAR添加一个描述文件，其中的内容能让你用 java -jar 来运行应用程序。<br/>
build标签：

```xml
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```

3.4、将spring-boot-starter-parent作为上一级，这样一来就能利用Maven的依赖管理功能，继承很多常用库的依赖版本，在声明依赖时就不用再去指定版本号了。<br/>
parent标签：

```xml
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.0.2.RELEASE</version>
	<relativePath/> <!-- lookup parent from repository -->
</parent>
```

3.4.2、可以通过导入 spring-boot-dependencies 替代 spring-boot-starter-parent。<br/>
dependencyManagement标签：

```xml
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-dependencies</artifactId>
			<version>2.0.2.RELEASE</version>
			<scope>import</scope>
			<type>pom</type>
		</dependency>
	</dependencies>
</dependencyManagement>
```

3.5、起步依赖本质上是一个Maven项目对象模型（Project Object Model，POM），定义了对其他库的传递依赖，这些东西加在一起即支持某项功能。很多起步依赖的命名都暗示了它们提供的某种或某类功能 。<br/>
dependency依赖注入包说明：

```
org.springframework.boot > spring-boot-starter：spring boot java启动
org.springframework.boot > spring-boot-starter-web：spring boot web启动
org.springframework.boot > spring-boot-starter-test > test：spring boot test：Junit测试启动
org.springframework.boot > spring-boot-starter-data-jpa：JPA：在关系型数据库里持久化数据：application.propertions未配置DB和JPA信息的话，引入此包会报错
org.hibernate > hibernate-ehcache：
org.hibernate > hibernate-entitymanager：
org.hibernate.validator > hibernate-validator：
org.springframework.boot > spring-boot-starter-thymeleaf：Web视图
com.h2database > h2：h2数据库
mysql > mysql-connector-java：Mysql：Mysql数据库
javax.inject > javax.inject > 1 ：
```

dependencies标签：

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-jpa</artifactId>
	</dependency>
	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-ehcache</artifactId>
	</dependency>
	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-entitymanager</artifactId>
	</dependency>
	<dependency>
		<groupId>org.hibernate.validator</groupId>
		<artifactId>hibernate-validator</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
	<dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
	</dependency>
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
	</dependency>
	<dependency>
		<groupId>javax.inject</groupId>
		<artifactId>javax.inject</artifactId>
		<version>1</version>
	</dependency>
</dependencies>
```

---
### <a id="a_applicationProperties">四、application.properties：配置文件</a>
4.1、设置server信息

```properties
#设置Tomcat的监听端口
server.port=8888
#设置servlet上下文路径
server.servlet.context-path=/boot
```

4.2、设置数据库信息

```properties
#设置Mysql驱动类
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
#设置Mysql url地址
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/study
#设置Mysql username
spring.datasource.username=root
#设置Mysql password（无则为空）
spring.datasource.password=root
```

4.3、设置JPA信息

```properties
#设置JPA hibernate.ddl-auto 配置信息
#ddl-auto:create----每次运行该程序，没有表格会新建表格，表内有数据会清空
#ddl-auto:create-drop----每次程序结束的时候会清空表
#ddl-auto:update----每次运行程序，没有表格会新建表格，表内有数据不会清空，只会更新
#ddl-auto:validate----运行程序会校验数据与数据库的字段类型是否相同，不同会报错
spring.jpa.hibernate.ddl-auto=create
#设置JPA 是否显示sql ： true显示，false不显示
spring.jpa.show-sql=true
```

### <a id="a_getproperties">五、获取默认配置文件或其他配置文件声明的属性值</a>

application.properties：

```properties
# 配合 MainByProperties 获取 application.properties属性值
local.ip=127.0.0.1
local.port=8888
name=spring boot
project.name=\u6F14\u793A\u5C5E\u6027\u503C${name}

#配合 TestPropertiesByPropertySource 获取 指定前缀属性值
test.jdbcUrl=jdbc:mysql://test/study
test.driverClassName=com.mysql.jdbc.Driver
test.jdbcUsername=test
test.jdbcPassword=test123
```

application.yml：

```properties
#配合 MainByProperties 获取 application.yml属性值
locale: 
  name:application.yml
```


test-jdbc.properties：

```properties
#配合 TestPropertiesByPropertySource 获取 自定义资源 test-jdbc.properties 属性值
jdbcUrl=jdbc:mysql://127.0.0.1:3306/study
driverClassName=com.mysql.jdbc.Driver

#配合 TestPropertiesByPrefix 获取 指定前缀属性值属性值
dev.jdbcUrl=jdbc:mysql://localhost:3306/study
dev.driverClassName=com.mysql.jdbc.Driver
dev.jdbcUsername=root
dev.jdbcPassword=root
dev.jdbcHostList[0]=localhost
dev.jdbcHostList[1]=127.0.0.1
dev.jdbcProtArray[0]=8080
dev.jdbcProtArray[1]=8181
dev.jdbcProtArray[2]=9088
```


MainByProperties.java：演示入口类

```Java
package com.mutistic.properties;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import com.mutistic.utils.CommonUtil;
// 获取默认配置文件或其他配置文件声明的属性值
@SpringBootApplication
public class MainByProperties {
	public static void main(String[] args) {
		showPropertiesByConfigurableEnvironment(args);
		showPropertiesBySystemEnvironment(args);
		showPropertiesByEnvironment(args);
		showPropertiesByValue(args);
		showPropertiesByPropertySource(args);
		showPropertiesByPrifex(args);
		showPropertiesByEnvironmentPostProcessor(args);
	}

	// 1.1、通过ConfigurableApplicationContext.getEnvironment().getProperty()获取具体属性值
	private static void showPropertiesByConfigurableEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		
		CommonUtil.printOne("1.1、通过ConfigurableApplicationContext.getEnvironment().getProperty()获取指定属性值：");
		CommonUtil.printThree("获取 application.properties声明的属性：local.ip", env.getProperty("local.ip"));
		CommonUtil.printThree("获取 application.yml声明的属性：local.name", env.getProperty("local.name"));
		
		context.close();
	}
	
	// 1.2、通过ConfigurableApplicationContext.getSystemEnvironment()获取指定系统环境中的属性值
	private static void showPropertiesBySystemEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		
		ConfigurableEnvironment env = context.getEnvironment();
		CommonUtil.printOne("1.2、通过ConfigurableApplicationContext.getSystemEnvironment()获取指定系统环境中的属性值：");
		Map<String, Object> systemMap = env.getSystemEnvironment();
		for (String key : systemMap.keySet()) {
			CommonUtil.printThree("获取系统环境中的属性："+key, systemMap.get(key));
		}
		
		context.close();
	}
	
	// 2、通过 自动注入 Environment 获取属性值
	private static void showPropertiesByEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		
		CommonUtil.printOne("2、通过 自动注入 Environment 的 getProperty() 获取属性值：");
		context.getBean(TestPropertiesByEnvironment.class).show();
		
		context.close();
	}
	
	// 3、通过 @Value 自动注入 application.properties声明的属性
	private static void showPropertiesByValue(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);

		CommonUtil.printOne("3、通过 @Value 自动注入 application.properties声明的属性：");
		context.getBean(TestPropertiesByValue.class).show();
		
		context.close();
	}
	
	// 4、通过 @PropertySource 加载指定资源文件
	private static void showPropertiesByPropertySource(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		
		CommonUtil.printOne("4、通过 @PropertySource 加载指定资源文件：");
		context.getBean(TestPropertiesByPropertySource.class).show();
		ConfigurableEnvironment env = context.getEnvironment();
		CommonUtil.printThree("通过 env.getProperty() 获取 test-jdbc.properties声明的属性：jdbcUrl", env.getProperty("jdbcUrl"));
		CommonUtil.printThree("通过 env.getProperty() 获取 test-jdbc.properties声明的属性：driverClassName", env.getProperty("driverClassName"));
		
		context.close();
	}
	
	// 5、通过 @ConfigurationProperties 加载指定前缀属性
	private static void showPropertiesByPrifex(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		
		CommonUtil.printOne("5、通过 @ConfigurationProperties 加载指定前缀属性：");
		context.getBean(TestPropertiesByPrefix.class).show();
		
		context.close();
	}
	
	// 6、通过实现 EnvironmentPostProcessor 动态注入自定义配置文件： 
	private static void showPropertiesByEnvironmentPostProcessor(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		CommonUtil.printOne("6、通过实现 EnvironmentPostProcessor 动态注入自定义配置文件：");
		CommonUtil.printThree("TestEnvironmentPostProcessor 实现 EnvironmentPostProcessor bean：", context.getBean(TestEnvironmentPostProcessor.class));
		CommonUtil.printThree("获取 自定义配置文件 test-processor.properties 的属性值 project：", env.getProperty("project"));
		CommonUtil.printThree("获取 自定义配置文件 test-processor.properties 的属性值 author：", env.getProperty("author"));
		CommonUtil.printThree("获取 自定义配置文件 test-processor.properties 的属性值 time：", env.getProperty("time"));
	}
}
```


5.1.1、通过ConfigurableApplicationContext.getEnvironment().getProperty()获取application.properties的属性值<br/>
ConfigurableEnvironment：[org.springframework.core.env.ConfigurableEnvironment](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/core/env/ConfigurableEnvironment.html)


```
1、参考：MainByProperties.showPropertiesByConfigurableEnvironment();
2、配置接口，如果不是所有的 Environment 类型都可以实现。提供设置活动和默认概要文件和操纵底层属性的工具。允许客户端设置和验证所需的属性，定制转换服务，并通过可配置的 ConfigurablePropertyResolver 超级接口进行更多的定制。
3、当一个  Environment 被  ApplicationContext 使用时，重要的是在调用上下文的refresh（）方法之前执行任何此类PropertySource操作。这确保了在容器引导过程中所有的属性源都可用，包括属性占位符配置者的使用。
```

5.1.2、通过ConfigurableEnvironment.getSystemEnvironment()获取指定系统环境中的属性值：<br/>

```
1、演示结果参考：MainByProperties.showPropertiesBySystemEnvironment();
2、java.util.Map<java.lang.String,java.lang.Object> getSystemEnvironment()：
2.1、如果由当前SecurityManager允许的话，返回system.getenv() 的值，否则返回一个map实现，它将尝试通过调用system.getenv(String)来访问单个键。
2.2、请注意，大多数Environment实现将把这个系统环境映射包含为要搜索的默认PropertySource。因此，建议不直接使用该方法，除非明确指定绕过其他属性源
```

5.2、通过 自动注入 Environment 获取属性值：<br/>
Environment：[org.springframework.core.env.Environment](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/core/env/Environment.html)

PropertyResolver：[org.springframework.core.env.PropertyResolver](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/core/env/PropertyResolver.html)

```
1、演示结果参考：MainByProperties.showPropertiesByEnvironment();
2、ConfigurableEnvironment 继承 Environment，Environment 继承 PropertyResolver。
3、Environment：接口表示当前应用程序正在运行的环境。模型的两个关键方面：概要文件和属性。与资源访问相关的方法通过PropertyResolver 超级接口公开。
4、属性在几乎所有的应用程序中都扮演着重要的角色，可能来自各种来源：属性文件，JVM系统属性，系统环境变量，JNDI，servlet上下文参数，ad-hoc属性对象，Map等等。环境对象与属性相关的角色是为用户提供一个方便的服务接口，用于配置属性源并解析属性
5、PropertyResolver：java.lang.String getProperty(java.lang.String key)：返回与给定键相关联的属性值，如果键不能被解析，则返回null。
```
TestPropertiesByEnvironment.java：

```Java
package com.mutistic.properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.mutistic.utils.CommonUtil;
// 2、通过 自动注入 Environment 获取属性值
@Component
public class TestPropertiesByEnvironment {
	// 自动注入 Environment：ConfigurableEnvironment 是 Environment 其中的一个子类
	@Autowired
	private Environment evn;
	
	public void show() {
		CommonUtil.printThree("通过 Environment 获取 application.properties声明的属性：local.ip", evn.getProperty("local.ip"));
		CommonUtil.printThree("通过 Environment 获取 application.properties声明的属性：local.prot，可以指定其类型", evn.getProperty("local.port", Integer.class));
		CommonUtil.printThree("通过 Environment 获取 application.properties声明的属性：tomcat.port", evn.getProperty("tomcat.port", "101010"));
	}
}
```

5.3、通过 @Value 自动注入 application.properties声明的属性：<br/>
@Value：[org.springframework.beans.factory.annotation.Value](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Value.html)

```
1、演示结果参考：MainByProperties.showPropertiesByValue();<br/>
2、在字段或方法/构造器参数级别上的注释，表示受影响参数的默认值表达式。
3、通常用于表达驱动的依赖注入。还支持处理handler方法参数的动态解析，例如在Spring MVC中。 一个常见的用例是使用"systemProperties"分配默认字段值。myProp }"风格表达式。
4、注意，@value标注的实际处理是由BeanPostProcessor执行的，这意味着您不能在BeanPostProcessor或BeanFactoryPostProcessor类型中使用@value。请参考AutowiredAnnotationBeanPostProcessor类的javadoc（默认情况下，它检查这个注释的存在）。
```

@Value属性说明：<br/>
java.lang.String value：实际的值表达式：例如"#{systemProperties.myProp}"。

TestPropertiesByValue.java：

```Java
package com.mutistic.properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.mutistic.utils.CommonUtil;
// 3、通过 @Value 自动注入 application.properties声明的属性
@Component
public class TestPropertiesByValue {
	@Value("${local.ip}")
//	@Value(value = "${local.ip}")
	private String localIP;
	
	@Value("${name}")
	private String name;
	
	// 通过  @Value 注解自动注入时 会根据字段类型进行转换
	@Value("${local.port}")
	private Integer localPort;
	
	// 在application.properties 可以用 ${key}引用声明的属性
	@Value("${project.name}")
	private String projectName;
	
	// 通过  @Value 注解，可以用 ${key:value}对字段给定默认值
	@Value("${tomcat.prot:9090}")
	private String tomcatPort;
	
	public void show() {
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性：local.ip", localIP);
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性(会根据字段类型进行转换)：local.prot:", localPort);
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性：name", name);
		CommonUtil.printThree("通过  @Value 注解自动注入 在application.properties 可以用 ${key}引用声明的属性：project.name 引用 name", projectName);
		CommonUtil.printThree("通过  @Value 注解，可以用 ${key:value}对字段给定默认值，优先取application.properties的值", tomcatPort);
	}
}
```

5.4、通过 @PropertySource 加载指定资源文件：<br/>
@PropertySource：[org.springframework.context.annotation.PropertySource](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html)

@PropertySources：[org.springframework.context.annotation.PropertySources](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/PropertySources.html)

```
1、演示结果参考：MainByProperties.showPropertiesByPropertySource();<br/>
2、@PropertySource：注释提供了一种方便的声明机制，可以将PropertySource添加到Spring的环境中。与@configuration类一起使用。
3、@PropertySources：集合了多个PropertySource注释的容器注释。可以原生使用，声明几个嵌套的PropertySource注释。也可以与Java 8对可重复注释的支持结合使用，其中PropertySource可以简单地在同一类型上多次声明，从而隐式生成此容器注释
```

@PropertySource属性说明：

```
1、java.lang.String[] value
	指示要加载的属性文件的资源位置。传统和基于XML的属性文件格式均受支持 - 例如"classpath:/com/myco/app.properties" 或"file:/path/to/file.xml"。资源位置通配符（例如** / *。properties）是不允许的; 
	每个位置都必须评估一个.properties资源。
	${...}占位符将针对已注册的任何/所有属性源进行解析Environment。
	每个位置都将Environment作为其自己的属性来源添加到附件中，并按声明顺序添加
2、java.lang.String name
	指明此属性来源的名称。如果省略，将根据底层资源的描述生成名称。
3、boolean ignoreResourceNotFound
	公共抽象布尔ignoreResourceNotFound
	指示是否property resource应该忽略找不到的答案。
	true如果属性文件是完全可选的，则是合适的。默认是false。
4、java.lang.String encoding
	公共抽象java.lang.String编码，给定资源的特定字符编码，例如"UTF-8"
5、java.lang.Class<? extends PropertySourceFactory> factory
	public abstract java.lang.Class<? extends PropertySourceFactory> factory
	指定一个自定义PropertySourceFactory，如果有的话。默认情况下，将使用标准资源文件的默认工厂。
```

test-jdbc2.properties：

```properties
#配合 TestPropertiesByPropertySource 获取 自定义的多资源 test-jdbc2.properties 属性值
jdbc2.username=root
jdbc2.password=root
```

TestPropertiesByPropertySource.java：

```Java
package com.mutistic.properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import com.mutistic.utils.CommonUtil;
// 4、通过 @PropertySource 加载指定资源文件
// 通过其 value 属性指定资源文件路径： classpath 默认去查找根路径下的文件。file 可以指定绝对路径
@Component
@PropertySource(value = "test-jdbc.properties")
@PropertySource(value = "file:C:/Work/Study/GitProduct/mutistic.spring/com.mutistic.boot/notes/test-jdbc2.properties") // 可以加载多个配置文件
//@PropertySource( name="test-jdbc.properties", value= {"classpath:test-jdbc.properties"}, ignoreResourceNotFound=false, encoding="UTF-8")
//@PropertySource(value = {"clapatch:test-jdbc.properties", "file:C:/Work/Study/GitProduct/mutistic.spring/com.mutistic.boot/notes/test-jdbc2.properties"}) // 可以用使用 value 加载多个配置文件
//@PropertySources({@PropertySource(value = "test-jdbc.properties"), @PropertySource(value = "file:C:/Work/Study/GitProduct/mutistic.spring/com.mutistic.boot/notes/test-jdbc2.properties")}) // 可以使用 @PropertiesSources 加载多个配置为文件
public class TestPropertiesByPropertySource {
	@Value("${test.jdbcUrl}")
	private String jdbcUrl;

	@Value("${test.driverClassName}")
	private String driverClassName;

	@Value("${jdbc2.jdbcUsername}") // test-jdbc2.properties
	private String jdbcUsername;
	
	@Value("${jdbc2.jdbcPassword}") // test-jdbc2.properties
	private String jdbcPassword;
	
	public void show() {
		CommonUtil.printTwo("通过 @Value 自动注入 test-jdbc.properties声明的属性：test.jdbcUrl", jdbcUrl);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性：test.driverClassName", driverClassName);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc2.properties声明的属性：jdbc2.jdbcUsername", jdbcUsername);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc2.properties声明的属性：jdbc2.jdbcPassword", jdbcPassword);
	}
}
```

5.5、通过 @ConfigurationProperties 加载指定前缀属性：<br/>
@ConfigurationProperties：[org.springframework.boot.context.properties.ConfigurationProperties](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/ConfigurationProperties.html)

```
1、演示结果参考：MainByProperties.showPropertiesByPrifex();
2、注释外部化配置。如果要绑定和验证某些外部属性（例如，从.Properties文件），请将其添加到类中的类定义或 @Bean方法中@Configuration。
3、请注意@Value，与之相反，由于属性值是外部化的，因此不会评估SpEL表达式。
```

@ConfigurationProperties属性说明：

```
1、java.lang.String value
	有效绑定到此对象的属性的名称前缀。prefix()的同义词
2、java.lang.String prefix
	有效绑定到此对象的属性的名称前缀。value()的同义词
3、boolean ignoreUnknownFields
	标记以指示绑定到此对象时应忽略未知字段。未知字段可能是属性中的错误的标志。
4、boolean ignoreInvalidFields
	标志表明绑定到这个对象时应该忽略无效的字段。根据使用的联编程序，无效意味着无效，通常这意味着错误类型的字段（或不能被强制转换为正确类型）
5、locations: 指定资源路径。已删除
```

TestPropertiesByValue.java：

```Java
package com.mutistic.properties;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import com.mutistic.utils.CommonUtil;
// 5、通过 @ConfigurationProperties 加载指定前缀属性
// 通过prefix属性会从默认加载指定前缀的属性（加载后，则不会再次加载。默认配置文件查找不到，会匹配整个上下文资源文件中的前缀），通过字段的set方法注入。
@Component
@PropertySource(value = "test-jdbc.properties") // 默认配置文件查找不到，会匹配整个上下文资源文件中的前缀
@ConfigurationProperties(prefix = "test") // prefix指定属性前缀。其中locations指定资源路径属性已删除
public class TestPropertiesByPrefix {
	private String jdbcUrl;
	private String driverClassName;
	private String jdbcUsername;
	private String jdbcPassword;
	// 声明格式 key[index]=value
	private List<String> jdbcHostList;// = new ArrayList<String>();
	// 声明格式 key[index]=value
	private Integer[] jdbcProtArray;

	public void show() {
		CommonUtil.printTwo("通过 @Value 自动注入 test-jdbc.properties声明的属性：jdbcUrl", jdbcUrl);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性：driverClassName", driverClassName);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性：jdbcUsername", jdbcUsername);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性：jdbcPassword", jdbcPassword);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性(集合)：jdbcHostList", jdbcHostList);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性(数组)：jdbcProtArray", Arrays.asList(jdbcProtArray));
	}

	public String getJdbcUrl() { return jdbcUrl; }
	public void setJdbcUrl(String jdbcUrl) { this.jdbcUrl = jdbcUrl; }
	public String getDriverClassName() { return driverClassName; }
	public void setDriverClassName(String driverClassName) { this.driverClassName = driverClassName; }
	public String getJdbcUsername() { return jdbcUsername; }
	public void setJdbcUsername(String jdbcUsername) { this.jdbcUsername = jdbcUsername; }
	public String getJdbcPassword() { return jdbcPassword; }
	public void setJdbcPassword(String jdbcPassword) { this.jdbcPassword = jdbcPassword; }
	public List<String> getJdbcHostList() { return jdbcHostList; }
	public void setJdbcHostList(List<String> jdbcHostList) { this.jdbcHostList = jdbcHostList; }
	public Integer[] getJdbcProtArray() { return jdbcProtArray; }
	public void setJdbcProtArray(Integer[] jdbcProtArray) { this.jdbcProtArray = jdbcProtArray; }
}
```

5.6、通过实现 EnvironmentPostProcessor  自定义注入配置文件：<br/>
EnvironmentPostProcessor：[org.springframework.boot.env.EnvironmentPostProcessor](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/env/EnvironmentPostProcessor.html)

Properties：[java.util.Properties](https://docs.oracle.com/javase/10/docs/api/java/util/Properties.html)

PropertiesPropertySource：[org.springframework.core.env.PropertiesPropertySource](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/core/env/PropertiesPropertySource.html)

MutablePropertySources：[org.springframework.core.env.MutablePropertySources](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/core/env/MutablePropertySources.html)

```
1、演示结果参考：MainByProperties.showPropertiesByEnvironmentPostProcessor();
2、EnvironmentPostProcessor：
	允许Environment在刷新应用程序上下文之前自定义应用程序。
	EnvironmentPostProcessor实现必须META-INF/spring.factories使用此类的完全限定名称作为注册进行注册 。
	EnvironmentPostProcessor我们鼓励处理器检测Spring的 Ordered接口是否已经实现，或者是否存在@Order注释，并且如果在调用之前进行了相应的排序实例。
3、Properties：
	是代表一个持久的一套详细属性，属性可以被保存到一个流或从流中加载的类。以下是关于属性的要点：
	属性列表中每个键及其对应值是一个字符串。
	一个属性列表可包含另一个属性列表作为它的"默认"，第二个属性可在列表中搜索，如果没有在原有的属性列表中找到的属性键。
	这个类是线程安全的;多个线程可以共享一个Properties对象，而不需要外部同步
4、PropertiesPropertySource：PropertySource从Properties对象中提取属性的实现
5、MutablePropertySources：
	PropertySources接口的默认实现。
	允许对内含的属性源进行操作，并提供复制现有PropertySources实例的构造器。
	在其的方法中提到了优先级，这是关于在用PropertyResolver解决给定属性时，将搜索属性源的顺序。
```

resources/META-INF/spring.factories：

```factories
#配合 TestEnvironmentPostProcessor 
org.springframework.boot.env.EnvironmentPostProcessor=com.mutistic.start.properties.TestEnvironmentPostProcessor
```

TestEnvironmentPostProcessor.java：

```Java
package com.mutistic.start.properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;
import com.mutistic.utils.CommonUtil;
// 6、通过实现 EnvironmentPostProcessor  自定义注入配置文件
@Component
public class TestEnvironmentPostProcessor implements EnvironmentPostProcessor {
	/**
	 * @description 给定的环境的后置处理器
	 * @param environment
	 * @param application
	 * @see org.springframework.boot.env.EnvironmentPostProcessor#postProcessEnvironment(org.springframework.core.env.ConfigurableEnvironment, org.springframework.boot.SpringApplication)
	 */
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		String fileName = "C:/Work/Study/GitProduct/mutistic.spring/com.mutistic.boot/notes/test/test-processor.properties";
		try {
			InputStream input = new FileInputStream(fileName);
			Properties source = new Properties();
			source.load(input); // 从输入字节流中读取属性列表（键和元素对） 
			
			PropertiesPropertySource propertySource = new PropertiesPropertySource("testInput", source);
			environment.getPropertySources().addLast(propertySource); // 添加具有最低优先级的给定属性源对象
		} catch (IOException e) {
			CommonUtil.printErr("TestEnvironmentPostProcessor 无法加载到指定资源fileName："+fileName);
			e.printStackTrace();
		}
	}
}
```

### <a id="a_profile">六、设置需要激活配置文件</a>
SpringApplication：[org.springframework.boot.SpringApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html)

```
1、可用于从Java主方法引导和启动Spring应用程序的类。默认情况下，类将执行以下步骤来引导应用程序
    1.1、创建一个合适的ApplicationContext实例（取决于你的类路径）
    1.2、注册一个CommandLinePropertySource将命令行参数作为Spring属性公开
    1.3、刷新应用程序上下文，加载所有单例bean
    1.4、触发任何CommandLineRunner beans
2、在大多数情况下，run(Class, String[])可以直接从主方法调用静态方法来引导应用程序
3、SpringApplications可以从各种不同的来源读取bean。通常建议使用单个@Configuration类来引导应用程序。
4、也可以sources从以下位置进行设置：
    4.1、要加载的完全限定类名 AnnotatedBeanDefinitionReader
    4.2、要加载的XML资源的位置XmlBeanDefinitionReader，或要加载的常规脚本GroovyBeanDefinitionReader
    4.3、要扫描的包的名称 ClassPathBeanDefinitionScanner
5、配置属性也绑定到SpringApplication。这使得SpringApplication动态设置属性成为可能，
	如其他来源（"spring.main.sources" - 一个CSV列表）的标志来指示Web环境（"spring.main.web-application-type = none"）
	或标志关闭横幅（"spring.main.banner-mode = off"）。
```

6.1、通过 SpringApplication.setAdditionalProfiles() 设置需要激活文件 <br/>
public void setAdditionalProfiles(String... profiles)：设置要使用的其他配置文件值（在系统或命令行属性中设置的值之上:--spring.profiles.active=test,uat）

application.properties：

```properties
#配合MainByAdditionalProfiles
jdbc.url=jdbc:mysql://127.0.0.1:3306/study
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.username=root
jdbc.password=
```

application-dev.properties：

```properties
#配合MainByAdditionalProfiles
jdbc.url=jdbc:mysql://dev/study
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.username=dev
jdbc.password=dev123
```

application-aut.properties：

```properties
#配合MainByAdditionalProfiles
jdbc.url=jdbc:mysql://uat/study
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.username=uat
jdbc.password=uat123
```

MainByAdditionalProfiles.java：

```Java
package com.mutistic.start.additional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import com.mutistic.utils.CommonUtil;
// 设置需要激活配置文件
// 默认的配置文件是自动激活生效的。可以激活多个配置文件。也可以使用启动参数来激活生效的配置文件： --spring.profiles.active=test,uat
@SpringBootApplication
public class MainByAdditionalProfiles {
	public static void main(String[] args) {
		showPropertiesByAdditionalProfiles(args, null);
		showPropertiesByAdditionalProfiles(args, "dev");
		showPropertiesByAdditionalProfiles(args, "test");
		showPropertiesByAdditionalProfiles(args, "uat");
	}

	/**
	 * 通过指定的 profiles 激活配置文件
	 * @param profiles
	 */
	private static void showPropertiesByAdditionalProfiles(String[] args, String profiles) {
		SpringApplication app = new SpringApplication(MainByAdditionalProfiles.class);
		String fileName = "application.properties";
		if (profiles != null && !profiles.isEmpty()) {
			app.setAdditionalProfiles(profiles, "dev"); // 设置生效文件，可以设置多个。
			fileName = "application-" + profiles + ".properties或包含"+ fileName +"前缀的属性";
		}
		ConfigurableApplicationContext context = app.run(args);
		ConfigurableEnvironment env = context.getEnvironment();

		CommonUtil.printOne("通过SpringApplication.setAdditionalProfiles()激活文件：" + fileName);
		if("test".equals(profiles)) {
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：test.jdbcUrl", env.getProperty("test.jdbcUrl"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：test.driverClassName", env.getProperty("test.driverClassName"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：test.jdbcUsername", env.getProperty("test.jdbcUsername"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：test.jdbcPassword", env.getProperty("test.jdbcPassword"));
		} else {
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：jdbc.url", env.getProperty("jdbc.url"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：jdbc.driverClassName", env.getProperty("jdbc.driverClassName"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：jdbc.username", env.getProperty("jdbc.username"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：jdbc.password", env.getProperty("jdbc.password"));
		}
		
		context.close();
	}
}
```

6.2、通过 @Profile 当激活对应配置文件或包含指定前缀的属性，组件可以注册 <br/>
@Profile：[org.springframework.context.annotation.Profile](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html)

```
1、表示当一个或多个指定的配置文件处于活动状态时，组件可以注册。
2、@Profile是可通过编程来激活一个命名逻辑分组ConfigurableEnvironment.setActiveProfiles(java.lang.String...)
      或声明通过设置spring.profiles.active属性作为JVM系统属性，作为环境变量，
      或者作为在Servlet上下文参数web.xml 为web应用程序。
      配置文件也可以在集成测试中通过@ActiveProfiles注释以声明方式激活。
3、@Profile注释可以在以下任一方式使用：
    3.1、作为任何直接或间接注解的类的类型级注释 @Component，包括@Configuration类
    3.2、作为元注释，用于组成自定义构造型注释
    3.3、作为任何@Bean方法的方法级别注释
4、如果一个@Configuration类标记了@Profile，除非一个或多个指定的配置文件处于活动状态，否则与该类关联的所有 @Bean方法和@Import注释都将被绕过。
     这与Spring XML中的行为类似：如果提供profile了beans元素的属性，
     例如，除非至少激活了配置文件'p1'或'p2'，否则<beans profile="p1,p2">该beans元素将不会被解析。
     同样，如果一个@Component或一个@Configuration类标记了@Profile({"p1","p2"})，
     除非至少激活了配置文件"p1"或"p2"，否则该类将不会被注册或处理。
5、如果给定的配置文件以NOT运算符（!）为前缀，则如果配置文件未处于活动状态，注释的组件将被注册
    例如，@Profile({"p1", "!p2"})如果配置文件"p1"处于活动状态或配置文件"p2" 未处于活动状态。
6、如果@Profile省略注释，则无论哪个（如果有）配置文件处于活动状态，都将进行注册。
7、注意：
    7.1、使用@Profileon @Bean方法时，可能需要一个特殊的场景：
	对于具有@Bean相同Java方法名称的重载方法（类似于构造函数重载），@Profile需要在所有重载方法上一致地声明一个条件。
	如果条件不一致，那么只有重载方法中的第一个声明的条件很重要。 @Profile因此不能用于选择具有特定参数签名而不是另一个的重载方法; 
    7.2、对于同一bean的所有工厂方法之间的解析遵循Spring的构造器解析算法。
 	如果想要定义具有不同配置文件条件的备用bean，请使用指向相同的Java方法名称bean name;请参阅到ProfileDatabaseConfig在@Configurationjavadoc中。
    7.3、当通过XML定义Spring bean时，可以使用元素的"profile"属性 <beans>。有关详细信息，请参阅spring-beans XSD中的文档 （版本3.1或更高版本）
8、演示结果参考 MainByAdditionalProfiles.main();
```

@Profile属性说明：<br/>
java.lang.String[] value：注释组件应注册的配置文件集合。不可以声明为null和空字符串。

TestBeanByProfile.java

```Java
package com.mutistic.start.additional;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import com.mutistic.utils.CommonUtil;
// 通过 @Profile 当激活对应配置文件或包含指定前缀的属性，组件可以注册
// 1、@Profile 不支持null和空字符串。2、@Profile可以作用在类和方法上或方法参数上。
// 3、支持NOT运算符(!)作为前缀，当某个配置文件处于非激活状态，组件才可以注册
@SpringBootConfiguration
//@Profile("dev") // @Profile(dev)：当SpringApplication.setAdditionalProfiles()激活dev配置文件时，TestBeanByProfile组件才被注册 
public class TestBeanByProfile {
	@Bean
	public Runnable runnable() {
		CommonUtil.printTwo("未声明@Profile：默认配置文件(如application.properties)是激活的。直接注册runnable bean：", "runnable");
		return () -> {};
	}
	
	@Bean
	@Profile("dev")
	public Runnable devRunnable() {
		CommonUtil.printTwo("@Profile(dev)：当SpringApplication.setAdditionalProfiles()激活dev配置文件时，注册devRunnable bean：", "devRunnable");
		return () -> {};
	}
	
	@Bean
	@Profile("test")
	public Runnable testRunnable() {
		CommonUtil.printTwo("@Profile(test)：当SpringApplication.setAdditionalProfiles()激活test配置文件时，注册testRunnable bean：", "testRunnable");
		return () -> {};
	}
	
	@Bean
	@Profile("uat")
	public Runnable uatRunnable() {
		CommonUtil.printThree("@Profile(uat)：当SpringApplication.setAdditionalProfiles()激活uat配置文件时，注册uatRunnable bean：", "uatRunnable");
		return () -> {};
	}
}
```

### <a id="a_condition">七、使用 @Conditional 和 Condition 组合实现基于条件的自动装配bean</a>
MainByCondition.java：

```Java
package com.mutistic.start.condition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.mutistic.utils.CommonUtil;
// 使用 @Conditional 和 Condition 组合实现基于条件的自动装配bean
@SpringBootApplication
public class MainByCondition {
	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext context = SpringApplication.run(MainByCondition.class, args);
			
			showBeanbyCustom(context);
			showBeanByConditional(context);
			context.close();
		} catch (Exception e) {
			e.printStackTrace();
//			CommonUtil.printErr(e.getMessage());
		}
	}

	// 1、使用 @Conditional 和 Condition 组合自定义实现根据条件自动装配bean
	private static void showBeanbyCustom(ConfigurableApplicationContext context) {
		CommonUtil.printOne("1、使用 @Conditional 和 Condition 组合自定义实现根据条件自动装配bean");
		CommonUtil.printThree("系统启动参数：file.encoding", System.getProperty("file.encoding"));
		CommonUtil.printThree("系统启动自定义参数：test.encoding", System.getProperty("test.encoding")); // 可以自定义配置VM启动时参数 -Dtest.encoding=ISO-8859-1
		CommonUtil.printThree("根据 System.getProperty(\"file.encoding\") 条件自动装配bean", context.getBeansOfType(TestEncodingConvert.class));
	}

	// 2、使用常用的Conditional类实现自动装配bean
	private static void showBeanByConditional(ConfigurableApplicationContext context) {
		CommonUtil.printOne("2、使用org.springframework.boot.autoconfigure.condition包下常用的Conditional类实现自动装配bean");
		CommonUtil.printThree("根据常用的Conditional类实现自动装配bean", context.getBeansOfType(Runnable.class));
		CommonUtil.printThree("@ConditionalOnProperty：当某个配置符合条件是才装配", context.getBean("createrByConditionalOnProperty"));
		CommonUtil.printThree("@ConditionalOnClass：当classpatch存在某个类才装配", context.getBean("createrByConditionalOnClass"));
		CommonUtil.printThree("@ConditionalOnMissingBean：当context不存在某个bean才装配", context.getBean("createrByConditionalOnMisisingBean"));
	}
}
```

7.1、使用 @Conditional 和 Condition 组合自定义实现根据条件自动装配bean：<br/>
@Conditional：[org.springframework.context.annotation.Conditional](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Conditional.html)

```
1、表示当所有指定的条件匹配时，组件可以注册 。
2、一个条件是任何可以在bean定义被注册之前以编程方式确定的状态（详见Condition参考资料）。
3、该@Conditional注释可以在以下任一方式使用：
	3.1、作为任何类的类型级注解，直接或间接地用@component注解，包括@configuration类
	3.2、作为元注释，用于组成自定义构造型注释
	3.3、作为任何@Bean方法的方法级别注释
4、如果某个@Conditional类标记了@Conditional，则与该类相关的所有@Bean方法，@Import注释和 @ComponentScan注释都将受到这些条件的约束。
5、注：不支持@Conditional注释的继承;任何来自超类或覆盖方法的条件都不会被考虑
      为了执行这些语义， @Conditional本身不被声明为 @Inherited; 此外，任何由元注释的自定义组合注释都 @Conditional不得声明为@Inherited。
6、演示结果参考：MainByCondition.showBeanbyCustom();
```

@Conditional 属性说明：<br/>
java.lang.Class<? extends Condition>[]：所有Condition必须匹配 的组件才能被注册

Condition：[org.springframework.context.annotation.Condition](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Condition.html)

```
1、为了使组件被注册，必须匹配的单个条件。
2、在bean-定义被注册之前，条件会立即被检查，并且可以根据在这一点上可以确定的任何标准自由地否决注册。
3、条件必须遵循与BeanFactoryPostProcessor相同的限制，并注意不要与bean实例交互。
      对于与@configuration bean交互的条件的更细粒度控制，可以考虑ConfigurationCondition接口。
```

Condition 方法说明：<br/>
boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)：确定条件是否匹配、返回true如果条件匹配并且组件可以注册，false否决注释组件的注册

TestConditionConfiguration.java：

```Java
package com.mutistic.start.condition;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
// 基于条件的自动配置，一般要配合 Condition接口使用
// 1、@Conditional可以作用在方法和类上（方法优先级高于类）。 2、Condition.matches()返回 true在装配，返回false不装配。
// 3、@Conditional参数 Condition 参数可以是多个，当都返回true时在装配。
@SpringBootConfiguration
// @Conditional({TestUTF8Condition.class, TestGBKCondition.class, TestISOCondition.class}) // 作用在类上对其所有的方法生效
public class TestConditionConfiguration {
	// 当@Conditional(TestUTF8Condition.class)条件为true时装配
	@Bean
	@Conditional(TestUTF8Condition.class)
	public TestEncodingConvert createrTestUTF8EncodingConvert() { return new TestUTF8EncodingConvert(); }

	// 当@Conditional(TestGBKCondition.class)条件为true时装配
	@Bean
	@Conditional(TestGBKCondition.class)
	public TestEncodingConvert createrTestGBKEncodingConvert() { return new TestGBKEncodingConvert(); }

	// 当@Conditional(TestISOCondition.class)条件为true时装配
	@Bean
	@Conditional(TestISOCondition.class)
	public TestEncodingConvert createrTestISOEncodingConvert() { return new TestISOEncodingConvert(); }
}
```

TestUTF8Condition.java：

```Java
package com.mutistic.start.condition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
// Condition实现类：配合 @Conditional 基于条件自动装配
public class TestUTF8Condition implements Condition {
	/**
	 * @description 判断 System.getProperty("file.encoding") 是否为 UTF-8
	 * @param context
	 * @param metadata
	 * @return
	 * @see org.springframework.context.annotation.Condition#matches(org.springframework.context.annotation.ConditionContext, org.springframework.core.type.AnnotatedTypeMetadata)
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encoding = System.getProperty("file.encoding");
		if(encoding != null && !encoding.isEmpty()) {
			return "UTF-8".equals(encoding.toUpperCase());
		}
		return false;
	}
}
```

7.2、使用常用的Conditional类实现自动装配bean：<br/>
@ConditionalOnProperty：[org.springframework.boot.autoconfigure.condition.ConditionalOnProperty](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnProperty.html)

@ConditionalOnClass：[org.springframework.boot.autoconfigure.condition.ConditionalOnClass](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnClass.html)

@ConditionalOnBean：[org.springframework.boot.autoconfigure.condition.ConditionalOnBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnBean.html)

```
1、演示结果参考：MainByCondition.showBeanByConditional();
2、常用的Conditional类：org.springframework.boot.autoconfigure.condition包下
      ConditionalOnBean/ConditionalOnMissingBean：当context存在或不存在某个bean才自动装配
      ConditionalOnClass/ConditionalOnMissingClass：当classpatch下存在或不存在某个class才自动装配
      ConditionalOnExpression/ConditionalOnMissingExpression：当匹配或不匹配某个表达才自动装配
      ConditionalOnJava/ConditionalOnMissingJava：当前JVM版本大于等于或小于某个版本才自动装配
      ConditionalOnWebApplication/ConditionalOnNotWebApplication：当前项目是或者不是web项目才自动装配
      ConditionalOnResource：当某个资源存在是才自动装配
      ConditionalOnProperty：当某个配置存在时或配置文件等于某个值存在时才自动装配
```

TestConditionConfiguration.java：

```Java
package com.mutistic.start.condition;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
// 基于条件的自动配置
@SpringBootConfiguration
public class TestConditionConfiguration {
	// @ConditionalOnProperty：当某个配置符合条件是才装配
	@Bean
	@ConditionalOnProperty(name = "local.ip", havingValue = "127.0.0.1") // 存在属性值，且havingValue声明值一致时装配
//	@ConditionalOnProperty(name = "local.ip", havingValue = "localhost", matchIfMissing = true) // matchIfMissing不存在是也装配，存在时属性值与havingValue声明值一致时装配
	public Runnable createrByConditionalOnProperty() { return () -> { }; }

	// @ConditionalOnClass：当classpatch存在某个类才装配
	@Bean
	@ConditionalOnClass(name = "com.mutistic.utils.CommonUtil") { return () -> { }; }
	
	// @ConditionalOnMissingBean：当context不存在某个bean才装配
	@Bean
	@ConditionalOnMissingBean(name = "createrTestISOEncodingConvert")
	public Runnable createrByConditionalOnMisisingBean() { return () -> { }; }
}
```
### <a id="a_enable">八、使用 @Eable启用特性</a>
8.1、使用 @EnableAutoConfiguration 启用一个特性：将配置文件的属性注入到bean中：<br/>
@EnableAutoConfiguration：[org.springframework.boot.autoconfigure.EnableAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/EnableAutoConfiguration.html)

@EnableConfigurationProperties：[org.springframework.boot.context.properties.EnableConfigurationProperties](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/EnableConfigurationProperties.html)

@EnableAutoConfiguration 说明：

```
1、启用S​​pring应用程序上下文的自动配置，试图推测和配置可能需要的bean。自动配置类通常基于您的类路径和您定义的bean应用
2、使用时SpringBootApplication，上下文的自动配置会自动启用，因此添加此注释不会产生其他影响。
	自动配置会尝试尽可能地智能化，并会在定义更多自己的配置时退出。始终可以手动exclude()配置任何不想应用的配置（excludeName()如果您无权访问，请使用该配置）。
2、也可以通过该spring.autoconfigure.exclude属性排除它们 。自动配置总是在用户定义的bean注册后应用。
3、@Enableautoconfiguration注释的类包通常是通过@SpringBootApplication进行注释的，它具有特定的意义，并且经常被用作"默认"。
	通常建议您在根包中放置@Enableautoconfiguration（如果您没有使用@SpringBootApplication），这样就可以搜索所有子包和类。
4、自动配置类是普通的Spring Configuration bean。他们使用SpringFactoriesLoader机制（针对这个class）。
	通常，自动配置bean是@Conditionalbean（最常使用@ConditionalOnClass和 @ConditionalOnMissingBean注释）

@EnableAutoConfiguration属性说明：
Class<?>[] exclude; 排除特定的自动配置类，从而永远不会应用它们
String[] excludeName; 排除特定的自动配置类名称，使它们永远不会被应用
```

@EnableAutoConfiguration 说明：

```
启用对ConfigurationProperties注释Bean的支持。 ConfigurationPropertiesbean可以以标准方式注册（例如使用@Bean方法），或者为了方便起见，可以直接在此注释中指定bean 

@EnableConfigurationProperties属性说明：
Class<?>[] value; ConfigurationProperties使用Spring 快速注册带注释的Bean的便捷方式。
```

MainByEnableAutoConfiguration.java：

```Java
package com.mutistic.start.enable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.mutistic.utils.CommonUtil;
// 使用 @EnableAutoConfiguration 启用一个特性：将配置文件的属性注入到bean中
// 1、实际上起作用的是 @EnableConfigurationProperties 注解。2、@SpringBootApplication 中标注了 @EnableAutoConfiguration注解。
// 3、@Enable 启用特性实际上是使用 @Import 导入类来实现的。
@EnableAutoConfiguration
// @EnableConfigurationProperties
@ComponentScan
public class MainByEnableAutoConfiguration {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByEnableAutoConfiguration.class, args);
		CommonUtil.printOne("使用 @EnableAutoConfiguration 启用一个特性：将配置文件的属性注入到bean中");
		CommonUtil.printThree("使用@ConfigurationProperties 注解通过set方法注入属性", context.getBean(TestEnableAutoProperties.class).toString());
		context.close();
	} 
}
```

TestEnableAutoProperties.java：

```Java
package com.mutistic.start.enable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
// 配合 MainByEnableAutoConfiguration 实现启用属性自动注入特性
@Component
@ConfigurationProperties(prefix="local")
public class TestEnableAutoProperties {
	private String ip;
	private String port;
	
	public String getIp() { return ip; }
	public void setIp(String ip) { this.ip = ip; }
	public String getPort() { return port; }
	public void setPort(String port) { this.port = port; }

	@Override
	public String toString() { return "TestEnableAutoProperties [ip=" + ip + ", port=" + port + "]"; }
}
```

8.2、使用 @EnableAsync 启用异步执行特性：<br/>
@EnableAsync：[org.springframework.scheduling.annotation.EnableAsync](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/annotation/EnableAsync.html)

AdviceMode：[org.springframework.context.annotation.AdviceMode](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/AdviceMode.html)

Ordered：[org.springframework.core.Ordered](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/core/Ordered.html)

@EnableAsync说明：

```
启用Spring的异步方法执行功能，类似于Spring的<task:*>XML命名空间中的功能

@EnableAsync属性说明：
java.lang.Class<? extends java.lang.annotation.Annotation> annotation() default Annotation.class; 指示要在类别或方法级别检测到的'异步'注释类型
boolean proxyTargetClass() default false; 指示是否创建基于子类的（CGLIB）代理，而不是基于标准Java接口的代理。仅适用于mode()设置为AdviceMode.PROXY
org.springframework.context.annotation.AdviceMode mode() default AdviceMode.PROXY; 说明如何应用异步建议。
	默认是AdviceMode.PROXY。请注意，代理模式允许仅通过代理截取调用。同一类的本地调用不能以这种方式被拦截;
	由于Spring的拦截器甚至没有为这样的运行时场景启动，所以在本地调用中对这种方法的Async注释将被忽略。对于更高级的拦截模式，请考虑将其转换为AdviceMode.ASPECTJ。
int order default Ordered.LOWEST_PRECEDENCE; 指出AsyncAnnotationBeanPostProcessor 应该应用的顺序。
	缺省值是Ordered.LOWEST_PRECEDENCE为了在所有其他后处理器之后运行，以便它可以将顾问添加到现有代理而不是双代理
```

MainByEnableAsync.java：

```Java
package com.mutistic.start.enable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import com.mutistic.utils.CommonUtil;
// 使用 @EnableAsync 启用异步执行特性
@SpringBootApplication
@EnableAsync // 启用异步特性
public class MainByEnableAsync {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByEnableAsync.class, args);
		CommonUtil.printOne("使用 @EnableAsync 启用异步执行特性");
		context.getBean("testEnableAsync", Runnable.class).run();
		CommonUtil.printOne("使用 @EnableAsync 启用异步执行特性===END===");
		context.close();
	}
}
```

TestEnableAsync.java：

```Java
package com.mutistic.start.enable;
import java.util.concurrent.TimeUnit;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.mutistic.utils.CommonUtil;
// 配合 MainByEnableAsync 实现启用异步执行特性 
@Component
public class TestEnableAsync implements Runnable {
	@Async // 异步执行注解
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				CommonUtil.printThree("TestEnableAnsyc 执行输出", i);
				TimeUnit.MICROSECONDS.sleep(500); // 线程暂停
			}
		} catch (InterruptedException e) { e.printStackTrace();	}
	}
}
```

8.3、使用 @Import 导入一个或多个类（可以普通类、配置类、ImportSelector接口实现类、ImportBeanDefinitionRegistrar接口实现类）：
@Import：[org.springframework.context.annotation.Import](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Import.html)

@ImportResource：[org.springframework.context.annotation.ImportResource](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ImportResource.html)

@Import说明：

```
1、表示要导入一个或多个@configuration类。
2、提供与Spring XML中的<import/> 元素相对应的功能。允许导入@configuration类、ImportSelector和importbean定义注册器实现，以及常规组件类。
3、在导入的@configuration类中声明的@bean定义应该通过使用@autowired注入来访问。要么bean本身可以自动连接，要么宣布bean的配置类实例可以自动连接。
	后一种方法允许在@configuration类方法之间进行显式的、理想化的导航。
4、可以在类级别或作为元注释声明。
5、如果@Configuration需要导入XML或其他非bean定义资源，请改为使用@ImportResource注释

@Import属性说明：
java.lang.Class<?>[] value：Configuration，ImportSelector，ImportBeanDefinitionRegistrar 或常规组件类导入。
```

MainByImport.java：

```Java
package com.mutistic.start.enable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import com.mutistic.utils.CommonUtil;
// 使用 @Import 导入一个或多个类（可以普通类、配置类、ImportSelector接口实现类、ImportBeanDefinitionRegistrar接口实现类）
@SpringBootApplication
@Import({TestBeanByImport.class, TestImportConfiguration.class})
//@Import(TestImportSelector.class) // 使用ImportSelector.selectImports() 导入返回的class数组。ImportSelector接口实现类本身不会被默认装配成bean
//@TestEnableByImport(name = "mainByImport") // 使用自定义注解实现 @Import：模拟@Enable注解
//@Import(TestImportBeanDefinitionRegistrar.class) // 使用ImportBeanDefinitionRegistrar接口实现类，动态注入bean
public class MainByImport {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByImport.class, args);
		CommonUtil.printOne("使用 @Import 导入一个或多个类：");
		CommonUtil.printThree("获取导入的普通类：", context.getBean("com.mutistic.start.enable.TestBeanByImport"));
		CommonUtil.printThree("获取导入的配置类：", context.getBeansOfType(TestImportConfiguration.class));
		CommonUtil.printThree("获取导入的配置类创建的bean：", context.getBeansOfType(TestBeanByImport.class));
		context.close();
	}
}
```

TestImportConfiguration.java：

```Java
package com.mutistic.start.enable;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
// 配合 MainByImport 使用@Import导入配置类
//@SpringBootConfiguration // @Import导入可以不用声明@SpringBootConfiguration等注解
public class TestImportConfiguration {
	@Bean
	public TestBeanByImport createrTestBeanByImport() { return new TestBeanByImport(); }
	
	@Bean
	public TestBeanByImport createrTestBeanByImport2() { return new TestBeanByImport(); }	
}
```

8.4、模拟实现 @Enable、@Import、ImportBeanDefinitionRegistrar、BeanPostProcessor组合使用：<br/>
MainByRealizeEnable.java：

```Java
package com.mutistic.start.enable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.mutistic.utils.CommonUtil;
// 模拟实现 @Enable、@Import、ImportBeanDefinitionRegistrar、BeanPostProcessor组合使用
@SpringBootApplication
@RealizeEnableRegistrar(beans = {RealizeBeanOne.class, RealizeBeanTwo.class}) // 启用 @RealizeEnableRegistrar 特性
public class MainByRealizeEnable {
	public static void main(String[] args) {
		CommonUtil.printOne(MainByRealizeEnable.class +"：模拟实现 @Enable、@Import、ImportBeanDefinitionRegistrar、BeanPostProcessor组合使用：");
		ConfigurableApplicationContext context = SpringApplication.run(MainByRealizeEnable.class, args);
		CommonUtil.printTwo("Main-通过 @RealizeEnableRegistrar 获取注入spring容器中的RealizeBeanOne bean", context.getBean(RealizeBeanOne.class));
		CommonUtil.printThree("Main-通过 @RealizeEnableRegistrar 获取注入到spring容器中的RealizeBeanTwo bean", context.getBean(RealizeBeanTwo.class));
		context.close();
	}
}
```

RealizeEnableRegistrar.java：

```Java
package com.mutistic.start.enable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
// 模拟@Enable注解：特性：通过@Import 导入RealizeImportBeanDefinitionRegistrar 将传递过来的class参数注入到spring容器中
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RealizeImportBeanDefinitionRegistrar.class)
public @interface RealizeEnableRegistrar {
//	Class[] beans();
	Class<?>[] beans(); 
}
```

RealizeImportBeanDefinitionRegistrar.java：

```Java
package com.mutistic.start.enable;
import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import com.mutistic.utils.CommonUtil;
// 模拟 ImportBeanDefinitionRegistrar 接口 实现动态注入
// 将@RealizeEnableRegistrar 将class参数注入到spring容器和RealizeBeanPostProcessor中。
public class RealizeImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		CommonUtil.printOne(RealizeImportBeanDefinitionRegistrar.class +"：模拟 ImportBeanDefinitionRegistrar 接口 实现动态注入bean");
		Class<?>[] beans = null;

		// 获取 @RealizeEnableRegistrar 注解的属性值
		Map<String, Object> attrMap = importingClassMetadata.getAnnotationAttributes(RealizeEnableRegistrar.class.getName());
		if (attrMap.containsKey("beans")) {
			beans = (Class<?>[]) attrMap.get("beans");
		}
		if(beans == null || beans.length <= 0) {
			return;
		}
		CommonUtil.printThree("Registrar-获取 @RealizeEnableRegistrar 注解的属性值 beans", Arrays.asList(beans));
		
		CommonUtil.printThree("Registrar-将  @RealizeEnableRegistrar 的class参数赋值到 RealizeBeanPostProcessor中，同时RealizeBeanPostProcessor注入到spring容器中", 
				RealizeBeanPostProcessor.class);
		BeanDefinitionBuilder bdb = BeanDefinitionBuilder.genericBeanDefinition(RealizeBeanPostProcessor.class);
		bdb.addPropertyValue("beans", beans); // 属性赋值
		registry.registerBeanDefinition(RealizeBeanPostProcessor.class.getName(), bdb.getBeanDefinition());
		
		for (Class<?> temp : beans) {
			CommonUtil.printThree("Registrar-将  @RealizeEnableRegistrar 的class参数  注入到spring容器中", temp);
			registry.registerBeanDefinition(temp.getName(), BeanDefinitionBuilder.genericBeanDefinition(temp).getBeanDefinition());
		}
	}
}
```

RealizeBeanPostProcessor.java：

```Java
package com.mutistic.start.enable;
import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import com.mutistic.utils.CommonUtil;
// 配合 RealizeImportBeanDefinitionRegistrar 实现 @RealizeEnableRegistrar 参数注入（演示用可以不需要此类）
public class RealizeBeanPostProcessor implements BeanPostProcessor {

	private Class<?>[] beans;
	private boolean isPrint = false;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {		
		if (isPrint || beans == null || beans.length < 0) {
			return bean;
		}
		CommonUtil.printOne(RealizeBeanPostProcessor.class +"：配合 RealizeImportBeanDefinitionRegistrar 实现 @RealizeEnableRegistrar 参数注入");
		CommonUtil.printThree("Processor-获取传入的参数：beans", Arrays.asList(beans));
		isPrint = true;

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException { return bean; }

	public Class<?>[] getBeans() { return beans; }
	public void setBeans(Class<?>[] beans) { this.beans = beans; }
}
```


---
## <a id="a_pit">I、[spring boot 入坑总结](https://github.com/mutistic/mutistic.spring/tree/master/com.mutistic.boot/notes/pit)</a>
[pit1、spring boot之 maven install 报错[Maven]](https://github.com/mutistic/mutistic.spring/blob/master/com.mutistic.boot/notes/pit/pit1_spring%20boot%E4%B9%8B%20maven%20install%20%E6%8A%A5%E9%94%99%5BMaven%5D.docx)<br/>
[pit2、pom.xml无法找到[Maven]](https://github.com/mutistic/mutistic.spring/blob/master/com.mutistic.boot/notes/pit/pit2_pom.xml%E6%97%A0%E6%B3%95%E6%89%BE%E5%88%B0%5BMaven%5D.docx)<br/>
[pit3、引入spring-boot-starter-data-jpa 后启动项目报错[JPA]](https://github.com/mutistic/mutistic.spring/blob/master/com.mutistic.boot/notes/pit/pit3_%E5%BC%95%E5%85%A5spring-boot-starter-data-jpa%20%E5%90%8E%E5%90%AF%E5%8A%A8%E9%A1%B9%E7%9B%AE%E6%8A%A5%E9%94%99%5BJPA%5D.docx)<br/>
[pit4、继承JpaRepository时报错[JPA]](https://github.com/mutistic/mutistic.spring/blob/master/com.mutistic.boot/notes/pit/pit4_%E7%BB%A7%E6%89%BFJpaRepository%E6%97%B6%E6%8A%A5%E9%94%99%5BJPA%5D.docx)<br/>

---
## <a id="a_sql">II、[sql](https://github.com/mutistic/mutistic.spring/tree/master/com.mutistic.boot/notes/sql)</a>
[ddl_creater_database_study](https://github.com/mutistic/mutistic.spring/blob/master/com.mutistic.boot/notes/sql/ddl_creater_database_study.sql)


---
<a id="a_down"></a>  
<a href="#a_top">Top</a> 
<a href="#a_catalogue">Catalogue</a>  


