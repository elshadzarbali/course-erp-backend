package com.mycompany.courseerpbackend.models.mappers;

import com.mycompany.courseerpbackend.models.mybatis.language.Language;
import com.mycompany.courseerpbackend.models.payload.language.LanguagePayload;
import com.mycompany.courseerpbackend.models.response.language.LanguageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LanguageEntityMapper {

    LanguageEntityMapper INSTANCE = Mappers.getMapper(LanguageEntityMapper.class);

    Language fromLanguagePayloadToLanguage(LanguagePayload languagePayload);

    @Mapping(target = "id", source = "id")
    Language updateLanguageFromLanguagePayload(LanguagePayload languagePayload, Long id);

    List<LanguageResponse> fromLanguageToLanguageResponse(List<Language> languages);

}
