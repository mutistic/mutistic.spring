package com.mutistic.annotation.register;

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

}
