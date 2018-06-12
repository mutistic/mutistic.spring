package com.mutistic.annotation.register;

import org.springframework.stereotype.Repository;

/**
 * @program 使用  @Repository 注解声明一个(dao)bean
 * @description 一般用在数据访问层，也可以将这个注解应用到DAO类中。@Repository注解上不支持指定initial和destroy方法
 * @author mutisitic
 * @date 2018年6月11日
 */
@Repository
//@Repository("testRepositoryDao")
//@Repository(value = "myTestRepositoryDao") 
public class TestRepositoryDao {

}
