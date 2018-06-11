# [Spring](https://docs.spring.io/spring/docs/current/javadoc-api)
[Spring Boot](https://github.com/mutistic/mutistic.spring/blob/master/com.mutistic.boot/README.md)是伴随着Spring4.0诞生的<br/>

[spring Framework API](https://docs.spring.io/spring/docs/current/javadoc-api)<br/>
[spring Framework API-无框架](https://docs.spring.io/spring/docs/current/javadoc-api/overview-summary.html)<br/>
[Spring Framework Documentation](https://docs.spring.io/spring/docs/current/spring-framework-reference)<br/>

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

### 二、@Configuration 注解类<br/>
@Configuration [org.springframework.context.annotation.Configuration](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html)</br>
AnnotationConfigWebApplicationContext [org.springframework.web.context.support.AnnotationConfigWebApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/context/support/AnnotationConfigWebApplicationContext.html)</br>
ClassPathXmlApplicationContext [org.springframework.context.support.ClassPathXmlApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html)</br>

2.1、引导@Configuration类：</br>

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
package com.mutistic.annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {
	public static void main(String[] args) {
		// 通过无参构造器创建context
		AnnotationConfigApplicationContext context_mode1 = new AnnotationConfigApplicationContext();
		context_mode1.register(AnnotationConfig.class);
		context_mode1.refresh();
		context_mode1.close();
		// 通过有参构造器创建context
		AnnotationConfigApplicationContext context_mode2 = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		context_mode2.close();
	}
}

```

2.3、通过 Spring <beans> XML 配置</br>
ConfigurationClassPostProcessor [org.springframework.context.annotation.ConfigurationClassPostProcessor](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ConfigurationClassPostProcessor.html)
  
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

### 三、@Bean 注解<br/>
@Bean [org.springframework.context.annotation.Bean](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html)</br>
@Profile [org.springframework.context.annotation.Profile](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html)</br>
@Scope [org.springframework.context.annotation.Scope](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Scope.html)</br>
@Primary [org.springframework.context.annotation.Primary](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Primary.html)</br>
@Qualifier [org.springframework.beans.factory.annotation.Qualifier](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Qualifier.html)</br>

3.1、指示一个方法产生一个由Spring容器管理的bean：</br>

```
1、bean名称的默认策略是使用@Bean方法的名称。
2、使用该 name属性（或其别名value）。name接受一个字符串数组，允许为一个bean提供多个名称（即主bean名称加上一个或多个别名）。
3、@Bean注释不提供配置文件，范围，懒惰，依赖或主要的属性。相反，它应与结合使用 @Scope，@Lazy，@DependsOn， @Primary，@Qualifier注解来声明这些语义。
4、@Configuration在这种模式下，bean的类和他们的工厂方法不能被标记为final或private。
```

AnnotationConfig.java

```Java
package com.mutistic.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AnnotationConfig {
	/**
	 * 通过@Bean直接创建 bean
	 * @return RunnableFactory Bean
	 */
	@Bean(name = "annotationTestBean") // 指定 bean 的具体名称
  	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 指定bean 的作用域范围：单例，非单例，request，session
	public AnnotationTestBean createrAnnotationTestBean() {
		return new AnnotationTestBean();
	}
	
	/**
	 * 通过 FactoryBean<T>接口实现类 创建工厂 bean（name可以指定多个，默认为方法名）
	 * @return RunnableFactory Bean
	 */
	@Bean({"createrRunnableFactory", "runnableFactory"}) // 指定bean 多个名称
	public RunnableFactory createrRunnableFactory() {
		return new RunnableFactory();
	}
	
	/**
	 * 通过简单工厂类 创建工厂 bean 
	 * @return FocusBeanFactory Bean
	 */
	@Bean // 指定一个bean 其name默认为方法名
	@Primary  // 声明同类型bean为其主bean
	public FocusBeanFactory focusBeanFactory() {
		return new FocusBeanFactory();
	}
	
	/**
	 * 通过简单工厂类 创建工厂 bean 
	 * @return FocusBeanFactory Bean
	 */
	@Bean
	@Profile("dev") // 指定当一个或多个指定的配置文件处于活动状态时，组件可以注册
	public FocusBeanFactory craeterFocusBeanFactory() {
		return new FocusBeanFactory();
	}
	
	/**
	 * 通过简单工厂类 创建 实体bean 
	 * @param focusBeanFactory 检索后自动注入(spirng中无FocusBeanFactory：则无法自动注入。创建多个同类型bean可以使用 @Qualifier 指定具体一个bean)
	 * @return Focus Bean
	 */
	@Bean
	public Focus focus(/*@Qualifier("focusBeanFactory")*/ FocusBeanFactory focusBeanFactory) {
		return focusBeanFactory.createrFocus();
	}
}
```

RunnableFactory.java

```Java
package com.mutistic.annotation;
import org.springframework.beans.factory.FactoryBean;

/**
 * 通过 FactoryBean<T>接口实现类 创建工厂 RunnableFactory bean
 * 使用工厂类实现 org.springframework.beans.factory.FactoryBean<T> 创建bean实例，重写 getObject(); getObjectType(); isSingleton();
 */
public class RunnableFactory implements FactoryBean<Runnable> {

	/**
	 * 获取 FactoryBean 创建的bean实例
	 * @return Runnable 实例bean
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public Runnable getObject() throws Exception {
		return () -> {}; // 简单创建一个接口实例
	}

	/**
	 * 获取创建实例的类型
	 * @return Runnable.class
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		return Runnable.class;
	}

	/**
	 * 是否是单例模式(true：单例)(false：非单例)
	 * @return 是否是单例模式
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}

```

FocusBeanFactory.java

```Java
package com.mutistic.annotation;
/**
 * Focus 简单工厂类
 * 工厂类实现创建具体bean方法，config使用 @Bean 注解实现工厂类bean的创建方法，confgi使用 @Bean 注解实现具体bean的创建方法，入参为 工厂类（会自动搜索工厂类bean）。
 */
public class FocusBeanFactory {
	public Focus createrFocus() { return new Focus(); }
}
```

### 四、指定 bean的 initial（初始化） 和 destroy（销毁） 方法<br/>
InitializingBean [org.springframework.beans.factory.InitializingBean](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html)</br>
DisposableBean [org.springframework.beans.factory.DisposableBean](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html)</br>
@PostConstruct [javax.annotation.PostConstruct](https://docs.oracle.com/javase/10/docs/api/javax/annotation/PostConstruct.html)</br>
@PreDestroy [javax.annotation.PreDestroy](https://docs.oracle.com/javase/10/docs/api/javax/annotation/PreDestroy.html)</br>

4.1、通过InitializingBean和DisposableBean接口方式实现：</br>

```Java
package com.mutistic.annotation.id;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 使用实现接口方式实现 BeanFactory 的初始化 和销毁 动作
 * InitializingBean.afterPropertiesSet 指定初始化方法。DisposableBean.destroy 指定销毁方法
 */
public class IDByInterface implements InitializingBean, DisposableBean {
	/**
	 * 在它设置了所有bean属性之后，由BeanFactory调用（并满足了BeanFactoryAware和applicationcontext）。这个方法允许bean实例只执行初始化
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("IDByImplements implements InitializingBean.afterPropertiesSet");
	}

	/**
	 * 由一个BeanFactory调用的销毁单例对象（context.close();资源释放后调用bean消费方法）
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("IDByImplements implements DisposableBean.destroy");		
	}
}
```

4.2、使用@Bean initMethod和destroyMethod 指定具体的方法：</br>

IDConfig.java

```Java
package com.mutistic.annotation.id;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * initial AND destroy 配置类
 */
@Configuration
public class IDConfig {
	@Bean(initMethod = "initial", destroyMethod = "destroy") // 声明bean 指定其 init 和 destroy方法
	public IDByBean idByBean() {
		return new IDByBean();
	}
}
```

IDByBean.java

```Java
package com.mutistic.annotation.id;
import org.springframework.context.annotation.Bean;
import com.mutistic.utils.CommonConstant;

/**
 * 使用@Bean initMethod和destroyMethod 指定具体的方法
 * @Bean#initMethod 指定初始化方法。 @Bean#destroyMethod 指定销毁方法
 */
public class IDByBean {
	/**
	 * 声明initial方法-对指定bean生效
	 */
	public void initial() {
		System.out.println("IDByBean： @Bean initMethod 指定initial");
	}

	/**
	 * 声明destroy方法-对指定bean生效
	 */
	public void destroy() {
		System.out.println("IDByBean： @Bean destroyMethod 指定destroy");		
	}
}
```

4.3、使用JSR-250 @PostConstruct和 @PreDestroy方式指定

```Java
package com.mutistic.annotation.id;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用JSR-250@PostConstruct和@PreDestroy方式指定
 * @PostConstruct 指定 初始化方法。@PreDestroy 指定 销毁方法
 */
public class IDByJSR250 {
	/**
	 * 声明initial方法-对指定bean生效
	 */
	@PostConstruct // 指定 初始化方法
	public void initial() {
		System.out.println("IDByJSR25 @PostConstruct 指定initial");
	}

	/**
	 * 声明destroy方法-对指定bean生效
	 */
	@PreDestroy // 指定 销毁方法
	public void destroy() {
		System.out.println("IDByJSR250 @PreDestroy 指定 destroy");		
	}
}
```

### 五、使用@Component、@Repository、@Service、@Controller、@Aspect 等方式注册bean<br/>
5.1、@Component [org.springframework.stereotype.Component](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Component.html)<br/>
一般用在没有明确的角色的bean可以用。@Component注解上不支持指定initial和destroy方法<br/>

```Java
package com.mutistic.annotation.register;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.mutistic.utils.CommonConstant;

/**
 * 使用  @Component 注解声明一个bean
 * 一般用在没有明确的角色的bean可以用。@Component注解上不支持指定initial和destroy方法
 */
@Component // 声明一个bean。bean名称默认为类名（首字母小写），value属性值指定其bean名称（不支持多个），其中value可以省略。
//@Component("testComponentBean")
//@Component(value = "myTestComponentBean") 
public class TestComponentBean {
	@Autowired // 使用 spring  @Autowired 自动注入bean
//	@Resource  // 使用 JSR-250 @Resource:javax.annotation.Resource 自动注入bean
	private ApplicationContext applicationContext;
	public void show() {
		System.out.println("TestComponentBean 使用 @Autowried自动注入的ApplicationConext："+ applicationContext.getClass());
	}
}
```

5.2、@Repository [org.springframework.stereotype.Repository](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Repository.html)<br/>
一般用在数据访问层，也可以将这个注解应用到DAO类中。@Repository注解上不支持指定initial和destroy方法<br/>

```Java
package com.mutistic.annotation.register;
import org.springframework.stereotype.Repository;

/**
 * 使用  @Repository 注解声明一个(dao)bean
 * 一般用在数据访问层，也可以将这个注解应用到DAO类中。@Repository注解上不支持指定initial和destroy方法
 */
@Repository
//@Repository("testRepositoryDao")
//@Repository(value = "myTestRepositoryDao") 
public class TestRepositoryDao { }
```

5.3、@Service [org.springframework.stereotype.Service](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Service.html)<br/>
一般用在业务逻辑层。@Service注解上不支持指定initial和destroy方法<br/>

```Java
package com.mutistic.annotation.register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @program 使用  @Service 注解声明一个(service)bean
 * @description 一般用在业务逻辑层。@Service注解上不支持指定initial和destroy方法
 */
@Service // 声明一个bean。bean名称默认为类名（首字母小写），value属性值指定其bean名称（不支持多个），其中value可以省略。
//@Service("testService")
//@Service(value = "myTestService") 
public class TestService {
	// 使用 @Autowired 自动注入 bean。	使用 @Qualifier 指定具体一个bean
	@Autowired
//	@Qualifier("testRepositoryDao") // 存在多个同类的bean，可以用使用@Qualifier指定具体一个bean。或已有@Primary声明的主bean
	private TestRepositoryDao testRepositoryDao;

	@Override
	public String toString() {
		return "TestService [testRepositoryDao=" + testRepositoryDao + "]";
	}
}
```

5.4、@Controller [org.springframework.stereotype.Controller](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Controller.html)<br/>
一般用在数据展示层。@Controller注解上不支持指定initial和destroy方法<br/>

```Java
package com.mutistic.annotation.register;
import javax.annotation.Resource;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @program 使用  @Controller 注解声明一个(controller)bean
 * @description 一般用在数据展示层。@Controller注解上不支持指定initial和destroy方法
 */
@Controller // 声明一个bean。bean名称默认为类名（首字母小写），value属性值指定其bean名称（不支持多个），其中value可以省略。
//@Controller("testController")
//@Controller(value = "myTestController") 
public class TestController {

	// 使用 JSR-250 @Resource 自动注入 bean
	@Resource
	private TestService TestService;

	// 使用 JSR-330 @Inject 自动注入 bean。使用 @Qualifier 指定具体一个bean
	@Inject
	@Qualifier("testRepositoryDao")
	private TestRepositoryDao testRepositoryDao;

	@Override
	public String toString() {
		return "TestController [TestService=" + TestService + ", testRepositoryDao=" + testRepositoryDao + "]";
	}
}
```

JSR-330（javax.inject） pom依赖：

```xml
<dependency>
    <groupId>javax.inject</groupId>
    <artifactId>javax.inject</artifactId>
    <version>1</version>
</dependency>
```

5.5、@Aspect [org.aspectj.lang.annotation.Aspect]<br/>(https://www.eclipse.org/aspectj/doc/released/aspectj5rt-api/org/aspectj/lang/annotation/Aspect.html)<br/>
把当前类标识为一个切面供容器读取。@Aspect注解上不支持指定initial和destroy方法<br/>

```Java
package com.mutistic.annotation.register;
import org.aspectj.lang.annotation.Aspect;

/**
 * 使用  @Aspect 注解声明一个bean
 * 把当前类标识为一个切面供容器读取。@Aspect注解上不支持指定initial和destroy方法
 */
@Aspect
//@Component("testComponentBean") //声明一个bean。bean名称默认为类名（首字母小写），value属性值指定其bean名称（不支持多个），其中value可以省略。
//@Component(value = "myTestComponentBean") 
public class TestAspect { }
```

