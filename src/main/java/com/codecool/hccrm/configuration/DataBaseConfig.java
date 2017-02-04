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

    /**
     * get hibernate'a sessionFactory ready for injection, so we can create the current session object
     * to run queries
     * @param hemf giving access to the underlying SessionFactory from an EntityManagerFactory
     * @return sessionFactory which provides us the current session object
     * representing an internal state including all of the metadata about Object/Relational Mapping.
     */
    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
        return hemf.getSessionFactory();
    }
}
