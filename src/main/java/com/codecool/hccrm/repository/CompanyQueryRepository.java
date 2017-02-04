package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.Company;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by balag3 on 2017.02.03..
 */
@Repository
public class CompanyQueryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List getCondoms(Company company) {
        Query query =  sessionFactory.getCurrentSession().createQuery("from Condominium as cdm where cdm.company = :company")
                .setParameter("company", company);
        List list=query.list();
        return list;
    }

    public List getCompanies() {
        Query query=sessionFactory.getCurrentSession().createQuery("from Company");
        List list=query.list();
        return list;
    }
}
