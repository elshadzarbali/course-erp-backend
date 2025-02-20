package com.mycompany.courseerpbackend.services.country;

import com.mycompany.courseerpbackend.models.mybatis.country.Country;

import java.util.List;

public interface CountryService {

    void insert(Country country);

    void update(Country country);

    Country findById(Long id);

    List<Country> findAll();

}
