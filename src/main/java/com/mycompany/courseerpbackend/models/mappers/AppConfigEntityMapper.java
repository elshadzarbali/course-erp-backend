package com.mycompany.courseerpbackend.models.mappers;

import com.mycompany.courseerpbackend.models.mybatis.appconfig.AppConfig;
import com.mycompany.courseerpbackend.models.response.appconfig.AppConfigResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppConfigEntityMapper {

    AppConfigEntityMapper INSTANCE = Mappers.getMapper(AppConfigEntityMapper.class);

    AppConfigResponse entityToAppConfigResponse(AppConfig appConfig);

    List<AppConfigResponse> entityToAppConfigResponse(List<AppConfig> appConfigList);

}
