package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    void insert(User user);

}
