package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.language.Language;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LanguageRepository {

    void insert(Language language);

    void update(Language language);

    Optional<Language> findById(@Param("id") Long id);

    List<Language> findAll();

    Optional<Language> getDefaultLanguage();

    List<Language> findAllLocalizableLanguages();

}
