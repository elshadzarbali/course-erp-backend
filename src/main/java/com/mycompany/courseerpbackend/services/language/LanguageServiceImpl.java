package com.mycompany.courseerpbackend.services.language;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.mybatis.language.Language;
import com.mycompany.courseerpbackend.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public void insert(Language language) {
        languageRepository.insert(language);
    }

    @Override
    public void update(Language language) {
        languageRepository.update(language);
    }

    @Override
    public Language findById(Long id) {
        return languageRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(Language.class.getSimpleName(), "id", String.valueOf(id))
        );
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language getDefaultLanguage() {
        return languageRepository.getDefaultLanguage().orElseThrow(BaseException::unexpected);
    }
}
