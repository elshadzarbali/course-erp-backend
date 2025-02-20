package com.mycompany.courseerpbackend.services.country;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.mybatis.country.Country;
import com.mycompany.courseerpbackend.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public void insert(Country country) {
        countryRepository.insert(country);
    }

    @Override
    public void update(Country country) {
        countryRepository.update(country);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(Country.class.getSimpleName(), "id", String.valueOf(id))
        );
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

}
