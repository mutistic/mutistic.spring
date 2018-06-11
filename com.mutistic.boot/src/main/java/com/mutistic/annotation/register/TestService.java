package com.mutistic.annotation.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @program 使用  @Service 注解声明一个(service)bean
 * @description 一般用在业务逻辑层。@Service注解上不支持指定initial和destroy方法
 * @author mutisitic
 * @date 2018年6月11日
 */

@Service // 声明一个bean。bean名称默认为类名（首字母小写），value属性值指定其bean名称（不支持多个），其中value可以省略。
//@Service("testService")
//@Service(value = "myTestService") 
public class TestService {

	/**
	 * 使用 @Autowired 自动注入 TestRepositoryDao
	 * 使用 @Qualifier 指定具体一个bean
	 */
	@Autowired
//	@Qualifier("testRepositoryDao") // 存在多个同类的bean，可以用使用@Qualifier指定具体一个bean。或已有@Primary声明的主bean
	private TestRepositoryDao testRepositoryDao;

	@Override
	public String toString() {
		return "TestService [testRepositoryDao=" + testRepositoryDao + "]";
	}
	
}
