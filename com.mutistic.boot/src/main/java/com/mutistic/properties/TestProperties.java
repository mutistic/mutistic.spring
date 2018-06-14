package com.mutistic.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 通过 自动注入 Environment 获取属性值
 * @description 
 * @author mutisitic
 * @date 2018年6月14日
 */
@Component
public class TestProperties {

	/**
	 * 自动注入 Environment：ConfigurableEnvironment 是 Environment 其中的一个子类
	 */
	@Autowired
	private Environment evn;
	
	/**
	 * 注意 
	 * 1、配置文件默认名称为：application.properties.
	 * 2、配置文默认路径为：classpatch根目录、classpatch:/config、file目录、file:/config
	 * 3、默认配置文件名可以使用 --spring.config.name=app 来指定：只需要指定文件名，扩展名可以忽略。
	 * 4、默认配置文件可以使用 --spring.config.location=classpatch:/config/app.properties 来指定
	 * 4.1、默认配置文件需要指定全路径，包括目录和文件全名。可以指定多个配置文件用 , 分隔。
	 * 1、application.properties 默认编码格式是 ISO-8859-1。如果（在pom.xml中）设置为为UTF-8，则获取汉字时会出现乱码
	 * 2、application.properties 声明属性格式 key=value   
	 * 3、根据key获取属性是，key是区分大小写的
	 * 4、@Value默认配置文件要有配置项，配置项可以空。如果没有配置项，可以通过 ${key:value}给定默认值。
	 * 4.1、如果没有配置项，且无默认值，则会自动注入失败，抛出org.springframework.beans.factory.BeanCreationException异常。
	 * 4.2、如果配置项数据型与需要自动注入的字段的数据类型不能完成转换，则会自动注入失败，抛出org.springframework.beans.factory.UnsatisfiedDependencyException异常。
	 * 5、Environment：ConfigurableEnvironment 是 Environment 其中的一个子类
	 * 5.1、Environment.getProperty(String key, Class<T> targetType); 可以指定配置项的数据类型
	 * 5.2、Environment.getProperty(String key, String defaultValue); 可以指定配置型的默认值，配置项可以不用在application.properties声明
	 * 
	 */
	
	/**
	 * @description 通过 Environment 获取
	 * @author mutisitic
	 * @date 2018年6月14日
	 */
	public void showByEvn() {
		CommonUtil.printThree("通过 Environment 获取 application.properties声明的属性：local.ip", evn.getProperty("local.ip"));
		CommonUtil.printThree("通过 Environment 获取 application.properties声明的属性：local.prot，可以指定其类型", evn.getProperty("local.port", Integer.class));
		CommonUtil.printThree("通过 Environment 获取 application.properties声明的属性：tomcat.port", evn.getProperty("tomcat.port", "101010"));
	}
	
	@Value("${local.ip}")
//	@Value(value = "${local.ip}")
	private String localIP;
	
	@Value("${name}")
	private String name;
	/**
	 * 通过  @Value 注解自动注入时 会根据字段类型进行转换
	 */
	@Value("${local.port}")
	private Integer localPort;
	
	
	/**
	 * 在application.properties 可以用 ${key}引用声明的属性
	 */
	@Value("${project.name}")
	private String projectName;
	
	/**
	 * 通过  @Value 注解，可以用 ${key:value}对字段给定默认值
	 */
	@Value("${tomcat.prot:9090}")
	private String tomcatPort;
	
	/**
	 * @description 通过  @Value 注解自动注入 
	 * @author mutisitic
	 * @date 2018年6月14日
	 */
	public void showByValue() {
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性：local.ip", localIP);
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性(会根据字段类型进行转换)：local.prot:", localPort);
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性：name", name);
		CommonUtil.printThree("通过  @Value 注解自动注入 在application.properties 可以用 ${key}引用声明的属性：project.name 引用 name", projectName);
		CommonUtil.printThree("通过  @Value 注解，可以用 ${key:value}对字段给定默认值，优先取application.properties的值", tomcatPort);
	}
	
}
