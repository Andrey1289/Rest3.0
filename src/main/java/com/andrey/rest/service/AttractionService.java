package com.andrey.rest.service;

import com.andrey.rest.entity.Attraction;
import com.andrey.rest.entity.TypeAttraction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AttractionService {

    public Attraction createAttraction(Attraction attraction);
    public Attraction updateAttraction(Attraction attraction);
    public List<Attraction> getAllAttractions();
    public List<Attraction> getAllAttractionsByCityName(String name);
    public void deleteAttraction(String name);
    public List<Attraction> getAllAttractionByTypeAttraction(String typeAttraction);

}
