package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.country.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CountryRepository {

    void insert(Country country);

    void update(Country country);

    Optional<Country> findById(@Param("id") Long id);

    List<Country> findAll();

}
