package com.mycompany.courseerpbackend.services.user;

import com.mycompany.courseerpbackend.models.mybatis.user.User;

public interface UserService {

    void insert(User user);

    User getByEmail(String email);

    boolean checkByEmail(String email);

}
