package com.codecool.hccrm.repository;

import com.codecool.hccrm.model.User;

import java.util.List;

/**
 * Created by balag3 on 2017.02.04..
 */
public interface UserQueryRepository {
    List<User> selectAll();
}
