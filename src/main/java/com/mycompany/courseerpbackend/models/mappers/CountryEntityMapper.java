package com.mycompany.courseerpbackend.models.mappers;

import com.mycompany.courseerpbackend.models.mybatis.country.Country;
import com.mycompany.courseerpbackend.models.payload.country.CountryPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryEntityMapper {

    CountryEntityMapper INSTANCE = Mappers.getMapper(CountryEntityMapper.class);

    Country toEntity(CountryPayload countryPayload);

    @Mapping(target = "id", source = "id")
    Country toEntity(CountryPayload countryPayload, Long id);

}
