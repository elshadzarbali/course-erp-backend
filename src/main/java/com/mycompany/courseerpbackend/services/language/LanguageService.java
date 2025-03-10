package com.mycompany.courseerpbackend.services.language;

import com.mycompany.courseerpbackend.models.mybatis.language.Language;

import java.util.List;

public interface LanguageService {

    void insert(Language language);

    void update(Language language);

    Language findById(Long id);

    List<Language> findAll();

    Language getDefaultLanguage();

    List<Language> getAllLocalizableLanguages();

}
