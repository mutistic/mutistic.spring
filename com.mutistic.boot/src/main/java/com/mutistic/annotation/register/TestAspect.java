package com.mutistic.annotation.register;

import org.aspectj.lang.annotation.Aspect;


/**
 * @program 使用  @Aspect 注解声明一个bean
 * @description 把当前类标识为一个切面供容器读取。@Aspect注解上不支持指定initial和destroy方法
 * @author mutisitic
 * @date 2018年6月11日
 */
@Aspect
//@Aspect("testComponentBean") //声明一个bean。bean名称默认为类名（首字母小写），value属性值指定其bean名称（不支持多个），其中value可以省略。
//@Aspect(value = "myTestComponentBean") 
public class TestAspect {

}
