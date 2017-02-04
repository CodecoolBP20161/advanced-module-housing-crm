package com.codecool.hccrm.repository.implementation;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.repository.CompanyQueryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by balag3 on 2017.02.03..
 */
@Repository
public class CompanyQueryRepositoryImpl implements CompanyQueryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    public List<Condominium> getCondominiums(Company company) {
        return session().createQuery("from Condominium as cdm where cdm.company = :company")
                .setParameter("company", company).list();
    }

    public List<Company> selectAll() {
        return session().createQuery("from Company").list();
    }
}
