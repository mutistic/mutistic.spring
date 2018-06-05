package com.mutistic;
public class JPASourceConfig {
	
}
//
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
////@EnableJpaRepositories(value = "com.lc.springBoot.jpa.repository",
////                        entityManagerFactoryRef = "entityManagerFactory",
////                        transactionManagerRef="transactionManager")
//
//@EnableTransactionManagement
//@EnableJpaRepositories( entityManagerFactoryRef = "entityManagerFactory", 
//	transactionManagerRef = "transactionManager", 
//	basePackages = { "src.main.resources.application.properties" })
//public class JPASourceConfig {
////	@Autowired
////    JpaProperties jpaProperties;
////
////    @Autowired
////    @Qualifier("dataSource")
////    private DataSource dataSource;
//
//	
//	@Bean(name = "dataSource")
//    @Qualifier("dataSource")
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//
//    }
//	
//	@Bean(name = "jdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//	
//	/**
//     * EntityManagerFactory类似于Hibernate的SessionFactory,mybatis的SqlSessionFactory
//     * 总之,在执行操作之前,我们总要获取一个EntityManager,这就类似于Hibernate的Session,
//     * mybatis的sqlSession.
//     * @return
//     */
//@Autowired
//@Qualifier("dataSource")
//private DataSource dataSource;
//
// 
//
//@Primary
//@Bean(name = "entityManager")
//public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
//}
//
// 
//
//@Primary
//@Bean(name = "entityManagerFactory")
//public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
//return builder.dataSource(dataSource).properties(getVendorProperties(dataSource)).packages("src.main.resources.application.properties") // 设置实体类所在位置
//.persistenceUnit("persistenceUnit").build();
//}
//
// 
//
//@Autowired
//private JpaProperties jpaProperties;
//
// 
//
//private Map<String, String> getVendorProperties(DataSource dataSource) {
//return jpaProperties.getHibernateProperties(dataSource);
//}
//
// 
//
//@Primary
//@Bean(name = "transactionManager")
//public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
//return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
//}
//}
