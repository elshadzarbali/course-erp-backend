package com.mycompany.courseerpbackend.models.mappers;

import com.mycompany.courseerpbackend.models.mybatis.subject.Subject;
import com.mycompany.courseerpbackend.models.payload.subject.SubjectPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectEntityMapper {

    SubjectEntityMapper INSTANCE = Mappers.getMapper(SubjectEntityMapper.class);

    @Mapping(target = "courseId", source = "courseId")
    Subject fromSubjectPayloadToSubject(SubjectPayload subjectPayload, Long courseId);

    @Mapping(target = "id", source = "id")
    Subject fromSubjectPayloadToEntity(SubjectPayload subjectPayload, Long id);

}
