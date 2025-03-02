package com.mycompany.courseerpbackend.services.userconfig;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.mybatis.userconfig.UserConfig;
import com.mycompany.courseerpbackend.repository.UserConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserConfigServiceImpl implements UserConfigService {

    private final UserConfigRepository userConfigRepository;

    @Override
    public void insert(UserConfig userConfig) {
        userConfigRepository.insert(userConfig);
    }

    @Override
    public void update(UserConfig userConfig) {
        userConfigRepository.update(userConfig);
    }

    @Override
    public UserConfig findById(String id) {
        return userConfigRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(UserConfig.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public List<UserConfig> findAll() {
        return userConfigRepository.findAll();
    }

}
