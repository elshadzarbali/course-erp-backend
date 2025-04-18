package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.mappers.LanguageEntityMapper;
import com.mycompany.courseerpbackend.models.payload.language.LanguagePayload;
import com.mycompany.courseerpbackend.models.response.language.LanguageResponse;
import com.mycompany.courseerpbackend.services.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping
    public BaseResponse<Void> addLanguage(@RequestBody LanguagePayload languagePayload) {
        languageService.insert(
                LanguageEntityMapper.INSTANCE.fromLanguagePayloadToLanguage(languagePayload)
        );
        return BaseResponse.created();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateLanguage(@PathVariable Long id, @RequestBody LanguagePayload languagePayload) {
        languageService.update(
                LanguageEntityMapper.INSTANCE.updateLanguageFromLanguagePayload(languagePayload, id)
        );
        return BaseResponse.success();
    }

    @GetMapping("/localizable")
    public BaseResponse<List<LanguageResponse>> getAllLocalizableLanguages() {
        return BaseResponse.success(
                LanguageEntityMapper.INSTANCE.fromLanguageToLanguageResponse(
                        languageService.getAllLocalizableLanguages()
                )
        );
    }

}
