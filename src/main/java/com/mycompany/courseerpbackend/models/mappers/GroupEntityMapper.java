package com.mycompany.courseerpbackend.models.mappers;

import com.mycompany.courseerpbackend.models.mybatis.group.Group;
import com.mycompany.courseerpbackend.models.payload.group.GroupPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupEntityMapper {

    GroupEntityMapper INSTANCE = Mappers.getMapper(GroupEntityMapper.class);

    Group toEntity(GroupPayload groupPayload);

    @Mapping(target = "id", source = "id")
    Group toEntity(GroupPayload groupPayload, Long id);

}
