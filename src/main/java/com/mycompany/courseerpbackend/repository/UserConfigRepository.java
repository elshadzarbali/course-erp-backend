package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.userconfig.UserConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserConfigRepository {

    void insert(UserConfig userConfig);

    void update(UserConfig userConfig);

    Optional<UserConfig> findById(@Param("id") String id);

    List<UserConfig> findAll();

    void updateConfig(@Param("id") String id, @Param("value") Object value, @Param("userId") Long userId);

}
