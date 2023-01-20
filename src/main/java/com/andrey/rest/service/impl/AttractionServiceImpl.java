package com.andrey.rest.service.impl;

import com.andrey.rest.entity.Attraction;
import com.andrey.rest.repository.AttractionRepository;
import com.andrey.rest.service.AttractionService;
import com.andrey.rest.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {
    private final AttractionRepository attractionRepository;
    private final CityService cityService;

    public AttractionServiceImpl(AttractionRepository attractionRepository, CityService cityService) {
        this.attractionRepository = attractionRepository;
        this.cityService = cityService;
    }

    @Override
    public Attraction createAttraction(Attraction attraction) {
        System.out.println(cityService.getCityIdByCityName("Moscow"));
        return attractionRepository.save(attraction);
    }

    @Override
    public Attraction updateAttraction(Attraction attraction) {


        return null;
    }

    @Override
    public List<Attraction> getAllAttractions() {
        List<Attraction> attractionList = attractionRepository.findAll();
        return attractionList;
    }

    @Override
    public List<Attraction> getAllAttractionsByCityId(Long id) {
        return null;
    }

    @Override
    public void deleteAttraction(Long id) {

    }

}
