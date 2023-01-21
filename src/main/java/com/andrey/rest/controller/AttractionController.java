package com.andrey.rest.controller;

import com.andrey.rest.dto.AttractionDto;
import com.andrey.rest.entity.Attraction;
import com.andrey.rest.service.AttractionService;
import com.andrey.rest.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attractions")
public class AttractionController {

    private final AttractionService attractionService;
    public final CityService cityService;

    public AttractionController(AttractionService attractionService, CityService cityService) {
        this.attractionService = attractionService;
        this.cityService = cityService;
    }
    @GetMapping("getAll")
    public ResponseEntity<List<AttractionDto>> getAllAttractions() {
        List<AttractionDto> attractionDtoList = AttractionDto
                .attractionDtoList(attractionService.getAllAttractions());

        return new ResponseEntity<List<AttractionDto>>(attractionDtoList,HttpStatus.OK);
    }
   @GetMapping("attractionByName/{name}")
    public ResponseEntity<List<AttractionDto>> getAllAttractionsByCityName(@PathVariable String name) {
        if(name == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
             List<AttractionDto> attractionDtos = AttractionDto.attractionDtoList(attractionService.getAllAttractionsByCityName(name));

              return new ResponseEntity<>(attractionDtos,HttpStatus.OK);
    }
    //to do отдается не полная DTO
     @PostMapping("createAttraction")
    public ResponseEntity<AttractionDto> createAttraction(@RequestBody AttractionDto attractionDto) {

         if(attractionDto == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
         Attraction attraction = AttractionDto.toAttraction(attractionDto);
         attraction.setCity_id(cityService.getCityIdByCityName(attractionDto.getCityName()));
           attractionDto = AttractionDto
                   .fromAttraction(attractionService.createAttraction(attraction));
        return new ResponseEntity<>(attractionDto,HttpStatus.OK);
    }

   /* public ResponseEntity<> updateAttraction(DAO dao) {

        return
    }*/
    @DeleteMapping("deleteAttraction/{name}")
    public ResponseEntity<String> deleteAttraction(@PathVariable String name){
        if(name == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        attractionService.deleteAttraction(name);

        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("getAttractionBy/{typeAttraction}")
    public ResponseEntity<List<AttractionDto>> getAllAttractionByTypeAttraction(@PathVariable String typeAttraction){
        System.out.println(typeAttraction);
        if(typeAttraction == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(typeAttraction);
      List<Attraction> attractionList =  attractionService.getAllAttractionByTypeAttraction(typeAttraction);

        return new ResponseEntity<>(AttractionDto.attractionDtoList(attractionList),HttpStatus.OK);
    }
}
