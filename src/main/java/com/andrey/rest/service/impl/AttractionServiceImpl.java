package com.andrey.rest.service.impl;

import com.andrey.rest.dto.AttractionDto;
import com.andrey.rest.entity.Attraction;
import com.andrey.rest.repository.AttractionRepository;
import com.andrey.rest.service.AttractionService;
import com.andrey.rest.service.CityService;
import com.andrey.rest.utils.StringToEnumConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return attractionRepository.save(attraction);
    }

    @Override
    public Attraction updateAttraction(Attraction attraction) {
        Attraction updateAttraction = attractionRepository.findBynameAttraction(attraction.getNameAttraction());

        if(attraction.getDescription() !=null){
            updateAttraction.setDescription(attraction.getDescription());
        }

        return attractionRepository.save(updateAttraction);
    }

    @Override
    public List<Attraction> getAllAttractions() {
        List<Attraction> attractionList = attractionRepository.findAll();
        return attractionList;
    }

    @Override
    public List<Attraction> getAllAttractionsByCityName(String name) {
        Long id = cityService.getCityIdByCityName(name);
        List<Attraction> attractionList = (List<Attraction>) attractionRepository.findAllBycity_id(id);
        return attractionList;
    }

    @Transactional
    @Override
    public void deleteAttraction(String name) {
        attractionRepository.deleteBynameAttraction(name);
    }

    @Override
    public List<Attraction> getAllAttractionByTypeAttraction(String typeAttraction) {
        StringToEnumConverter stringToEnumConverter = new StringToEnumConverter(typeAttraction);

        List<Attraction> attractionList = attractionRepository.findAllBytypeAttraction(stringToEnumConverter.getTypeAttraction());
        System.out.println(attractionList);
        return attractionList;
    }

    @Override
    public Attraction getAttractionByNameAttraction(String nameAttraction) {
        return attractionRepository.findBynameAttraction(nameAttraction);
    }

}
