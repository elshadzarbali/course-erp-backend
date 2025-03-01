package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.payload.subject.SubjectPayload;
import com.mycompany.courseerpbackend.services.subject.SubjectBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    public final SubjectBusinessService subjectBusinessService;

    @PostMapping
    public BaseResponse<Void> createSubject(@RequestBody SubjectPayload subjectPayload) {
        subjectBusinessService.createSubject(subjectPayload);
        return BaseResponse.success();
    }

}
