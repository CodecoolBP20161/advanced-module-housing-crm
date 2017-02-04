package com.codecool.hccrm.repository.implementation;

import com.codecool.hccrm.model.User;
import com.codecool.hccrm.repository.UserQueryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by balag3 on 2017.02.04..
 */
@Repository
public class UserQueryRepositoryImpl implements UserQueryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> selectAll() {
        return session().createQuery("from User").list();
    }
}
