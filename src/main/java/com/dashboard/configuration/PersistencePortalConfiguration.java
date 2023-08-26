package com.dashboard.configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
/**
 * Configuration class for portal DB. 
 */
@Configuration
@PropertySource({"classpath:persistence-portal-db.properties"})
@EnableJpaRepositories(basePackages = "com.dashboard.dao.portal", entityManagerFactoryRef = "portalEntityManager", transactionManagerRef = "portalTransactionManager", repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@Profile("!tc")
public class PersistencePortalConfiguration {
    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext context;
    
    public PersistencePortalConfiguration() {
        super();
    }

    //

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean portalEntityManager() {
    	System.out.println("portalEntityManager");
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(portalDataSource());
        em.setPackagesToScan("com.dashboard.model.portal");
        em.setPersistenceUnitName("notDefaultDb");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.ddl-auto", env.getProperty("hibernate.ddl-auto"));
     // This logs sql queries
//        properties.put("hibernate.show_sql", true);
        em.setJpaPropertyMap(properties);
//        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(portalDataSource());
//        em.setPackagesToScan("com.dashboard.model.portal");
//
//        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        final HashMap<String, Object> properties = new HashMap<String, Object>();
//        properties.put("hibernate.ddl-auto", env.getProperty("hibernate.ddl-auto"));
//        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
        return em;
    }
    

    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource portalDataSource() {
    	System.out.println("portalDataSource");
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("datasource.driver-class-name"));
        
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));
        
        System.setProperty("jasypt.encryptor.password", "chspd@20450801");
        
        dataSource.setPassword(env.getProperty("datasource.password"));
//        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        System.out.println("portalDataSource - dataSource.getUrl() : " + dataSource.getUrl());
        return dataSource;
    }

    
    @Bean
    public PlatformTransactionManager portalTransactionManager(final @Qualifier("portalEntityManager") LocalContainerEntityManagerFactoryBean portalEntityManager) {
    	System.out.println("portalTransactionManager");
        return new JpaTransactionManager(portalEntityManager.getObject());
    }

}
