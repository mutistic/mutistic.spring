package com.mutistic.annotation.note;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 使用  @Component 注解声明一个bean
 * @description 一般用在没有明确的角色的bean可以用。@Component注解上不支持指定initial和destroy方法
 * @author mutisitic
 * @date 2018年6月11日
 */
@Component // 声明一个bean。bean名称默认为类名（首字母小写），value属性值指定其bean名称（不支持多个），其中value可以省略。
//@Component("testComponentBean")
//@Component(value = "myTestComponentBean") 
public class TestComponentBean {

	@Autowired // 使用 spring  @Autowired 自动注入bean
//	@Resource  // 使用 JSR-250 @Resource:javax.annotation.Resource 自动注入bean
	private ApplicationContext applicationContext;
	
	public void show() {
		System.out.println(CommonUtil.LINE_SHORT + "TestComponentBean 使用 @Autowried自动注入的ApplicationConext："+ applicationContext.getClass());
	}
}
