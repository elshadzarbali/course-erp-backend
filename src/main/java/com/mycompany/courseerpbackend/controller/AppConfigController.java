package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.mappers.AppConfigEntityMapper;
import com.mycompany.courseerpbackend.models.reponse.appconfig.AppConfigResponse;
import com.mycompany.courseerpbackend.services.appconfig.AppConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/app/configs")
@RequiredArgsConstructor
public class AppConfigController {

    private final AppConfigService appConfigService;

    @GetMapping("/{id}")
    public BaseResponse<AppConfigResponse> getAppConfigById(@PathVariable("id") String id) {
        return BaseResponse.success(
                AppConfigEntityMapper.INSTANCE.entityToAppConfigResponse(
                        appConfigService.findById(id)
                )
        );
    }

    @GetMapping
    public BaseResponse<List<AppConfigResponse>> getAllAppConfigs() {
        return BaseResponse.success(
                AppConfigEntityMapper.INSTANCE.entityToAppConfigResponse(
                        appConfigService.findAll()
                )
        );
    }

}
