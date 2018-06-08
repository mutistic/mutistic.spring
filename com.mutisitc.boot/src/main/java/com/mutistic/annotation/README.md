# [Spring](https://docs.spring.io/spring/docs/current/javadoc-api)
[Spring Boot](https://github.com/mutistic/mutistic.spring/blob/master/com.mutisitc.boot/README.md)是伴随着Spring4.0诞生的

=
### 一、AnnotationConfigApplicationContext 独立的应用程序上下文：</br>
[org.springframework.context.annotation.AnnotationConfigApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html)

```
1、独立的应用程序上下文，接受注释类作为输入 - 特别是注释类 @Configuration，但也包括普通 @Component类型和使用javax.inject注释的符合JSR-250和JSR-330的类。
2、允许使用逐个注册类register(Class...)以及使用类路径扫描 scan(String...)。
3、在多个@Configuration类的情况下，Bean后面的类中定义的@ 方法将覆盖在之前的类中定义的那些方法。
这可以用来通过一个额外的@Configuration 类故意重写某些bean定义

```
```
AnnotationConfigApplicationContext context_mode1 = new AnnotationConfigApplicationContext();
context_mode1.register(MyConfig.class);
context_mode1.refresh();

AnnotationConfigApplicationContext context_mode2 = new AnnotationConfigApplicationContext(MyConfig.class);
```

=
### 二、@Configuration 注解类<br/>
2.1、引导@Configuration类：</br>
[org.springframework.context.annotation.Configuration](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html)</br>
[org.springframework.web.context.support.AnnotationConfigWebApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/context/support/AnnotationConfigWebApplicationContext.html)</br>
[org.springframework.context.support.ClassPathXmlApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html)</br>

```
从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件（等同于xml文件中的<beans>标签）。
被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类（替代了加载xml配置文件的ClassPathXmlApplicationContext类）进行扫描，并用于构建bean定义，初始化Spring容器。
```

2.2、通过 AnnotationConfigApplicationContext 指定加载</br>

```
1、@Configuration类通常使用任何一个AnnotationConfigApplicationContext或者具有web-capable的变体，来引导 AnnotationConfigWebApplicationContext。
2、@Configuration不可以是final类型：否则会报 org.springframework.beans.factory.parsing.BeanDefinitionParsingException 异常。
3、@Configuration不可以是匿名类（包含匿名内部类）。
4、@configuration不可以是非静态内部类：否则会报错 org.springframework.beans.factory.UnsatisfiedDependencyException 异常。
```
```Java
AnnotationConfigApplicationContext context_mode1 = new AnnotationConfigApplicationContext();
context_mode1.register(MyConfig.class);
context_mode1.refresh();

AnnotationConfigApplicationContext context_mode2 = new AnnotationConfigApplicationContext(MyConfig.class);
```

2.3、通过 Spring <beans> XML 配置</br>
[org.springframework.context.annotation.ConfigurationClassPostProcessor](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ConfigurationClassPostProcessor.html)
  
```
1、作为@Configuration直接针对bean 注册类 的替代方法AnnotationConfigApplicationContext，@Configuration类可以<bean>在Spring XML文件中声明为正常的定义。
2、<context:annotation-config/>：为了启用ConfigurationClassPostProcessor和其他注释相关的后置处理器，需要这些后置处理器便于处理@Configuration类
```
```xml
<beans>
  <context:annotation-config/>
  <bean class="com.mutisitic.MyConfig"/>
</beans>
```

=
### 三、@Bean 注解<br/>
3.1、指示一个方法产生一个由Spring容器管理的bean：</br>
[org.springframework.context.annotation.Bean](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html)</br>
[org.springframework.context.annotation.Profile](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html)</br>
[org.springframework.context.annotation.Scope](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Scope.html)</br>
[org.springframework.context.annotation.Primary](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Primary.html)</br>
[org.springframework.beans.factory.annotation.Qualifier](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Qualifier.html)</br>
```
1、bean名称的默认策略是使用@Bean方法的名称。
2、使用该 name属性（或其别名value）。name接受一个字符串数组，允许为一个bean提供多个名称（即主bean名称加上一个或多个别名）。
3、@Bean注释不提供配置文件，范围，懒惰，依赖或主要的属性。相反，它应与结合使用 @Scope，@Lazy，@DependsOn和 @Primary注解来声明这些语义。
4、@Configuration在这种模式下，bean的类和他们的工厂方法不能被标记为final或private。
```
```Java
@Bean
public MyBean craeterMyBean() { return new MyBean(); }

@Bean({"myBean1", "myBean2"})
public MyBean myBean() { return new MyBean(); }

@Bean(name = "myBean")
@Profile("production")
@Scope("prototype")
public MyBean myBean() { return new MyBean(); }
```
