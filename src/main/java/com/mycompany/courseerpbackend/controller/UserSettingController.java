package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.payload.user.settings.UsersLanguagePayload;
import com.mycompany.courseerpbackend.services.user.settings.UserSettingsBusinessService;
import com.mycompany.courseerpbackend.utils.RequestStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users/settings")
public class UserSettingController {

    private final UserSettingsBusinessService userSettingsBusinessService;
    private final RequestStorage requestStorage;

    @PutMapping("/language")
    public BaseResponse<Void> updateDefaultLanguage(@RequestBody UsersLanguagePayload usersLanguagePayload) {
        userSettingsBusinessService.updateUserDefaultLanguage(
                requestStorage.getUserId(), usersLanguagePayload.getLangId()
        );
        return BaseResponse.success();
    }

}
