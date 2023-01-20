package com.andrey.rest.service;


import com.andrey.rest.entity.City;
import org.springframework.stereotype.Service;

@Service
public interface CityService {

    public City createCity(City city);
    public City updateCity(City city);
    public Long getCityIdByCityName(String cityName);


}
