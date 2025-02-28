package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.mappers.LanguageEntityMapper;
import com.mycompany.courseerpbackend.models.payload.language.LanguagePayload;
import com.mycompany.courseerpbackend.services.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageEntityMapper languageEntityMapper = LanguageEntityMapper.INSTANCE;

    LanguageService languageService;

    @PostMapping
    public BaseResponse<Void> addLanguage(@RequestBody LanguagePayload languagePayload) {
        languageService.insert(
                languageEntityMapper.fromLanguagePayloadToLanguage(languagePayload)
        );
        return BaseResponse.success();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateLanguage(@PathVariable Long id, @RequestBody LanguagePayload languagePayload) {
        languageService.update(
                languageEntityMapper.updateLanguageFromLanguagePayload(languagePayload, id)
        );
        return BaseResponse.success();
    }

}
