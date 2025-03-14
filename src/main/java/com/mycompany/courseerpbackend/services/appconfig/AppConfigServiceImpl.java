package com.mycompany.courseerpbackend.services.appconfig;

import com.mycompany.courseerpbackend.exception.ExceptionBuilder;
import com.mycompany.courseerpbackend.models.mybatis.appconfig.AppConfig;
import com.mycompany.courseerpbackend.repository.AppConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppConfigServiceImpl implements AppConfigService {

    private final AppConfigRepository appConfigRepository;

    @Override
    public void insert(AppConfig appConfig) {
        appConfigRepository.insert(appConfig);
    }

    @Override
    public void update(AppConfig appConfig) {
        appConfigRepository.update(appConfig);
    }

    @Override
    public AppConfig findById(String id) {
        return appConfigRepository.findById(id).orElseThrow(
                () -> ExceptionBuilder.notFound(AppConfig.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public List<AppConfig> findAll() {
        return appConfigRepository.findAll();
    }
}
