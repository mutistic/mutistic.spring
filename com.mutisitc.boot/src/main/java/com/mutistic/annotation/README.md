# [Spring](https://docs.spring.io/spring/docs/current/javadoc-api)
[Spring Boot](https://github.com/mutistic/mutistic.spring/blob/master/com.mutisitc.boot/README.md)是伴随着Spring4.0诞生的

## 独立的应用程序上下文：</br>
[org.springframework.context.annotation.AnnotationConfigApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html)

```
1、独立的应用程序上下文，接受注释类作为输入 - 特别是注释类 @Configuration，
但也包括普通 @Component类型和使用javax.inject注释的符合JSR-250和JSR-330的类。
2、允许使用逐个注册类register(Class...)以及使用类路径扫描 scan(String...)。
3、在多个@Configuration类的情况下，Bean后面的类中定义的@ 方法将覆盖在之前的类中定义的那些方法。
这可以用来通过一个额外的@Configuration 类故意重写某些bean定义
```
```
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
context.close();
```

### 一、使用@Configuration注解类<br/>
1.1、引导@Configuration类：</br>
[org.springframework.context.annotation.Configuration](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html)



