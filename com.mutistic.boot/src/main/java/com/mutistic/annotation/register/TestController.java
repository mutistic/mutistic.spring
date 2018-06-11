package com.mutistic.annotation.register;

import org.springframework.stereotype.Controller;

/**
 * @program 使用  @Controller 注解声明一个(controller)bean
 * @description 一般用在数据展示层。@Controller注解上不支持指定initial和destroy方法
 * @author mutisitic
 * @date 2018年6月11日
 */

@Controller // 声明一个bean。bean名称默认为类名（首字母小写），value属性值指定其bean名称（不支持多个），其中value可以省略。
//@Controller("testController")
//@Controller(value = "myTestController") 
public class TestController {

}
