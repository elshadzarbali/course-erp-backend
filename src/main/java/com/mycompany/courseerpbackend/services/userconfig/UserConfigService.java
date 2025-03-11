package com.mycompany.courseerpbackend.services.userconfig;

import com.mycompany.courseerpbackend.models.mybatis.userconfig.UserConfig;

import java.util.List;

public interface UserConfigService {

    void insert(UserConfig userConfig);

    void update(UserConfig userConfig);

    UserConfig findById(String id);

    List<UserConfig> findAll();

    void updateUserLanguage(Long userId, Long langId);

}
