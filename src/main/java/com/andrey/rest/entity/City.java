package com.andrey.rest.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cityName;
    @Column
    private Long population;
    @Column
    private String metroAvailability;
    @Column
    private String country;
    @OneToMany(mappedBy = "city")
    private List<Attraction> attractionList;

    public City() {
    }
    public City(Long id, String cityName, Long population, String metroAvailability, String country, List<Attraction> attractionList) {
        this.id = id;
        this.cityName = cityName;
        this.population = population;
        this.metroAvailability = metroAvailability;
        this.country = country;
        this.attractionList = attractionList;
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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city_name='" + cityName + '\'' +
                ", population=" + population +
                ", metroAvailability='" + metroAvailability + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(List<Attraction> attractionList) {
        this.attractionList = attractionList;
    }
}
