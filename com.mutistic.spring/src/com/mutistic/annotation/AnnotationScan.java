package com.mutistic.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.mutistic.annotation.beans.TestBeansConfig;
import com.mutistic.annotation.id.IDConfig;
import com.mutistic.annotation.note.TestAspect;

/**
 * @program bean组件扫描 引导@Configuration类
 * @description 开启组件扫描
 * @author mutisitic
 * @date 2018年6月5日
 */
@Configuration
@ComponentScan("com.mutistic.annotation") // @ComponentScan 配置用于 @Configuration类的组件扫描指令 可以指定用于定义要扫描的特定包
// @ComponentScan(value = {"com.mutistic.annotation.beans", "com.mutistic.annotation.id"}) // @ComponentScan 通过 value属性或者basePackages属性  可以指定多个需要扫描的包
//@ComponentScan(basePackages="com.mutistic.annotation"
//	,includeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {TestAspect.class}) // @ComponentScan 通过 includeFilters 属性 可以指定导入bean(类型具体参考 FilterType)
//	,excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {TestBeansConfig.class, IDConfig.class}) // @ComponentScan 通过 excludeFilters 属性 可以指定忽略bean(类型具体参考 FilterType)
//) 
public class AnnotationScan {

}
