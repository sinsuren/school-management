package com.sample.school.management.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by surender.s on 16/01/18.
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Value("${spring.datasource.driverClassName}")
    String driverClass;

    @Value("${spring.datasource.username}")
    String userName;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.url}")
    String dbUrl;

    @Value("${spring.datasource.validationQuery}")
    String validationQuery;


    @Value("${spring.jpa.show-sql:false}")
    String jpaShowSql;

    @Value("${spring.jpa.hibernate.ddl-auto:update}")
    String jpaDdlAuto;

    @Value("${spring.jpa.database-platform}")
    String jpaDialect;

    @Value("${spring.jpa.properties.hibernate.current_session_context_class}")
    String sessionContext;

    @Value("${spring.jpa.hibernate.naming-strategy}")
    String namingConvention;

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaDialect(new HibernateJpaDialect());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        factoryBean.setPackagesToScan("com.sample.school.management");
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }


    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClass);
        hikariConfig.setAutoCommit(false);
        hikariConfig.setPassword(password);
        hikariConfig.setUsername(userName);
        hikariConfig.setJdbcUrl(dbUrl);
        hikariConfig.setConnectionTestQuery(validationQuery);
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;

    }


    public Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.put("show-sql", jpaShowSql);
        jpaProperties.put("hibernate.hbm2ddl.auto", jpaDdlAuto);
        jpaProperties.put("hibernate.dialect", jpaDialect);
        jpaProperties.put("hibernate.current_session_context_class", sessionContext);
        jpaProperties.put("hibernate.id.new_generator_mappings", false);
        jpaProperties.put("hibernate.naming-strategy", namingConvention);
        return jpaProperties;

    }

    @Bean
    @Inject
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
    }

}