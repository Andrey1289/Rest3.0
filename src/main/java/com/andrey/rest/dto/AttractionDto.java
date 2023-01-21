package com.andrey.rest.dto;

import com.andrey.rest.entity.Attraction;
import com.andrey.rest.entity.TypeAttraction;
import java.util.ArrayList;
import java.util.List;

public class AttractionDto {
    private Long id;
    private String nameAttraction;
    private String dateOfConstruction;
    private String description;
    private TypeAttraction typeAttraction;
    private String cityName;

    public AttractionDto() {
    }


    public static AttractionDto fromAttraction(Attraction attraction){
            AttractionDto attractionDto = new AttractionDto();

            attractionDto.setId(attraction.getId());
            attractionDto.setNameAttraction(attraction.getNameAttraction());
            attractionDto.setDateOfConstruction(attraction.getDateOfConstruction());
            attractionDto.setDescription(attraction.getDescription());
            attractionDto.setTypeAttraction(attraction.getTypeAttraction());
        return attractionDto;
    }

    public static Attraction toAttraction(AttractionDto attractionDto){
           Attraction attraction = new Attraction();

           attraction.setNameAttraction(attractionDto.getNameAttraction());
           attraction.setDateOfConstruction(attractionDto.getDateOfConstruction());
           attraction.setDescription(attractionDto.getDescription());
           attraction.setTypeAttraction(attractionDto.getTypeAttraction());

        return attraction;
    }

    public static List<AttractionDto> attractionDtoList(List<Attraction> attractionList){
        List<AttractionDto> attractionDtos = new ArrayList<>();
        attractionList.forEach(attraction -> attractionDtos.add(fromAttraction(attraction)));
        return attractionDtos;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAttraction() {
        return nameAttraction;
    }

    public void setNameAttraction(String nameAttraction) {
        this.nameAttraction = nameAttraction;
    }

    public String getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setDateOfConstruction(String dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeAttraction getTypeAttraction() {
        return typeAttraction;
    }

    public void setTypeAttraction(TypeAttraction typeAttraction) {
        this.typeAttraction = typeAttraction;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
