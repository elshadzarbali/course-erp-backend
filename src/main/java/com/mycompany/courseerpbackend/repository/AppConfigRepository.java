package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.appconfig.AppConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AppConfigRepository {

    void insert(AppConfig appConfig);

    void update(AppConfig appConfig);

    Optional<AppConfig> findById(@Param("id") String id);

    List<AppConfig> findAll();

}
