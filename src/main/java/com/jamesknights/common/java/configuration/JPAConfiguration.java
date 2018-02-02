package com.jamesknights.common.java.configuration;


import javax.annotation.Generated;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@Configuration
@EnableJpaRepositories(basePackages = "com.jamesknights.*")
@PropertySource("application.properties")
@ComponentScan(basePackages = { "com.jamesknights.*"})
@EntityScan("com.jamesknights.*") 
@EnableTransactionManagement
public abstract class JPAConfiguration {
 
    @Autowired
    private Environment env;
     
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
 
        return (DataSource) dataSource;
    }
     
}
