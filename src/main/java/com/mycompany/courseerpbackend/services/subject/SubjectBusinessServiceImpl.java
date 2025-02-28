package com.mycompany.courseerpbackend.services.subject;

import com.mycompany.courseerpbackend.models.mappers.SubjectEntityMapper;
import com.mycompany.courseerpbackend.models.payload.SubjectPayload;
import com.mycompany.courseerpbackend.services.language.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectBusinessServiceImpl implements SubjectBusinessService {

    private final SubjectService subjectService;
    private final LanguageService languageService;

    @Override
    public void createSubject(SubjectPayload subjectPayload) {
        languageService.findById(subjectPayload.getLanguageId());

        // TODO: We will change it later
        Long courseId = 1L;

        subjectService.insert(
                SubjectEntityMapper.INSTANCE.fromSubjectPayloadToSubject(subjectPayload, courseId)
        );
    }

}
