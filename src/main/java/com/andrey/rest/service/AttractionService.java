package com.andrey.rest.service;

import com.andrey.rest.entity.Attraction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AttractionService {

    public Attraction createAttraction(Attraction attraction);
    public Attraction updateAttraction(Attraction attraction);
    public List<Attraction> getAllAttractions();
    public List<Attraction> getAllAttractionsByCityId(Long id);
    public void deleteAttraction(Long id);

}
