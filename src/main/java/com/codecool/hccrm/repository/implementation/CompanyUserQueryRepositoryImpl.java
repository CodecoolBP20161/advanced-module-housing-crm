package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.CompanyUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by balag3 on 2017.02.04..
 */
@Repository
public class CompanyUserQueryRepositoryImpl implements CompanyUserQueryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<CompanyUser> selectAll() {
        return session().createQuery("from CompanyUser").list();
    }
}
