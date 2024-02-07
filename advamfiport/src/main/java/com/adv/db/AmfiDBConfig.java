package com.adv.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

//https://javainfinite.com/spring-boot/configuring-multiple-data-sources-with-spring-boot-with-example/
//https://howtodoinjava.com/spring-boot/configure-multiple-datasources/

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "amfiEntityManagerFactory",
        transactionManagerRef = "amfiTransactionManager",
        basePackages = { "com.adv.amfi.repository" })
public class AmfiDBConfig {

    @Primary
    @Bean(name="amfiProperties")
    @ConfigurationProperties(prefix =  "amfi.db")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name="amfiDatasource")
    @ConfigurationProperties(prefix = "amfi.db")
    public DataSource datasource(@Qualifier("amfiProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name="amfiEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("amfiDatasource") DataSource dataSource){

        return builder.dataSource(dataSource)
                .packages("com.adv.amfi.model")
                .persistenceUnit("amfi")
                .build();
    }

    @Primary
    @Bean(name = "amfiTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("amfiEntityManagerFactory") EntityManagerFactory amfiEntityManagerFactory) {

        return new JpaTransactionManager(amfiEntityManagerFactory);
    }
}
