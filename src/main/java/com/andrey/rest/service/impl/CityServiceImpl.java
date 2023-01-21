package com.andrey.rest.service.impl;

import com.andrey.rest.entity.City;
import com.andrey.rest.repository.CityRepository;
import com.andrey.rest.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City createCity(City city) {

        return cityRepository.save(city);
    }

    @Override
    public City updateCity(City city) {
       City updateCity = cityRepository.findBycityName(city.getCityName());
        System.out.println(city);
        System.out.println(updateCity);
       if(city.getPopulation() != null){
           updateCity.setPopulation(city.getPopulation());
       }
       if(city.getMetroAvailability() != null){
           updateCity.setMetroAvailability(city.getMetroAvailability());
       }

        return cityRepository.save(updateCity);
    }

    @Override
    public Long getCityIdByCityName(String cityName) {
        return cityRepository.findBycityName(cityName).getId();


    }
}
