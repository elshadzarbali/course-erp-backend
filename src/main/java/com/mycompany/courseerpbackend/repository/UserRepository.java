package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserRepository {

    void insert(User user);

    Optional<User> findByEmail(@Param("email") String email);

}
