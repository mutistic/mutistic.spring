package com.mutistic.annotation.register;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonConstant;

/**
 * @program 使用  @Component 注解声明一个bean
 * @description 没有具体角色的bean可以用 @Component 表示
 * @author mutisitic
 * @date 2018年6月11日
 */
@Component
public class TestComponentBean {

	@Autowired // 使用 spring  @Autowired自动注入bean
//	@Resource  // 使用 JSR-250 @@Resource自动注入bean
	private ApplicationContext applicationContext;
	
	
	public void show() {
		System.out.println(CommonConstant.PRINT_PREF + this.getClass() + " 使用 @Autowried自动注入的ApplicationConext "+ applicationContext.getClass());
	}
}
