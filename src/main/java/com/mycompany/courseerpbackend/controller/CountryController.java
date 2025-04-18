package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.mappers.CountryEntityMapper;
import com.mycompany.courseerpbackend.models.payload.country.CountryPayload;
import com.mycompany.courseerpbackend.services.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public BaseResponse<Void> addCountry(@RequestBody CountryPayload countryPayload) {
        countryService.insert(
                CountryEntityMapper.INSTANCE.toEntity(countryPayload)
        );
        return BaseResponse.created();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateCountry(@PathVariable("id") Long id, @RequestBody CountryPayload countryPayload) {
        countryService.update(
                CountryEntityMapper.INSTANCE.toEntity(countryPayload, id)
        );
        return BaseResponse.success();
    }

}
