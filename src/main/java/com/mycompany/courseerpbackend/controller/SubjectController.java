package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.payload.subject.SubjectPayload;
import com.mycompany.courseerpbackend.services.subject.SubjectBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    public final SubjectBusinessService subjectBusinessService;

    @PostMapping
    public BaseResponse<Void> createSubject(@RequestBody SubjectPayload subjectPayload) {
        subjectBusinessService.createSubject(subjectPayload);
        return BaseResponse.created();
    }

    // TODO: (IT) Payload of this method should be different with createSubject method
    @PutMapping("/{id}")
    public BaseResponse<Void> updateSubject(@PathVariable("id") Long id, @RequestBody SubjectPayload subjectPayload) {
        subjectBusinessService.updateSubject(id, subjectPayload);
        return BaseResponse.success();
    }

}
