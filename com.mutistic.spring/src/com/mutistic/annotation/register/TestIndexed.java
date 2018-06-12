package com.mutistic.annotation.register;

import org.springframework.stereotype.Indexed;

/**
 * @program 使用  @Indexed 注解声明一个bean
 * @description 一般用在没有明确的角色的bean可以用。@Indexed的bean的name默认未类名（首字母小写）不支持设置。@Indexed注解上不支持指定initial和destroy方法。
 * @author mutisitic
 * @date 2018年6月11日
 */
@Indexed // 声明一个bean。bean名称默认为类名（首字母小写）
public interface TestIndexed {

}
