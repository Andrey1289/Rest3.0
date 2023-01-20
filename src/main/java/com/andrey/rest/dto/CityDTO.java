package com.andrey.rest.dto;

import com.andrey.rest.entity.City;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class CityDTO {

    private Long id;
    private String cityName;
    private Long population;
    private String metroAvailability;
    private String country;

    public static CityDTO fromCity(City city) {
        CityDTO cityDTO = new CityDTO();

        cityDTO.setId(city.getId());
        cityDTO.setCityName(city.getCityName());
        cityDTO.setPopulation(city.getPopulation());
        cityDTO.setMetroAvailability(city.getMetroAvailability());
        cityDTO.setCountry(city.getCountry());

        return cityDTO;
    }

    public static City toCity(CityDTO cityDTO) {
        City city = new City();

        city.setCityName(cityDTO.getCityName());
        city.setPopulation(cityDTO.getPopulation());
        city.setMetroAvailability(cityDTO.getMetroAvailability());
        city.setCountry(cityDTO.getCountry());

        return city;
    }

    public static List<CityDTO> CityDtoList(List<City> cities) {
        List<CityDTO> cityDTOList = new ArrayList<>();
        cities.forEach(city -> cityDTOList.add(fromCity(city)));
        return cityDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getMetroAvailability() {
        return metroAvailability;
    }

    public void setMetroAvailability(String metroAvailability) {
        this.metroAvailability = metroAvailability;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
