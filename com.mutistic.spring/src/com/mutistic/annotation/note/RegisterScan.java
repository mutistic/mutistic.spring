package com.mutistic.annotation.note;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program Register 扫描包 配置类
 * @description 
 * @author mutisitic
 * @date 2018年6月11日
 */
@Configuration // 指定一个配置类
@ComponentScan("com.mutistic.annotation.register") // 指定具体扫描包
public class RegisterScan {

}
