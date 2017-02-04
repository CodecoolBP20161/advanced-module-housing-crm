package com.codecool.hccrm.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by balag3 on 2017.02.04..
 */
@Configuration
public class DataBaseConfig {

    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){
        return hemf.getSessionFactory();
    }
}
