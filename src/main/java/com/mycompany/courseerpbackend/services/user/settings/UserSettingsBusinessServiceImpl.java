package com.mycompany.courseerpbackend.services.user.settings;

import com.mycompany.courseerpbackend.services.language.LanguageService;
import com.mycompany.courseerpbackend.services.userconfig.UserConfigService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSettingsBusinessServiceImpl implements UserSettingsBusinessService {

    final LanguageService languageService;
    final UserConfigService userConfigService;

    @Override
    public void updateUserDefaultLanguage(Long userId, Long langId) {
        // TODO: (IT) check langId is not null, if it is null throw some exception
        languageService.findById(langId);

        userConfigService.updateUserLanguage(userId, langId);;
    }

}
