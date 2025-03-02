package com.mycompany.courseerpbackend.services.appconfig;

import com.mycompany.courseerpbackend.models.mybatis.appconfig.AppConfig;

import java.util.List;

public interface AppConfigService {

    void insert(AppConfig appConfig);

    void update(AppConfig appConfig);

    AppConfig findById(String id);

    List<AppConfig> findAll();

}
