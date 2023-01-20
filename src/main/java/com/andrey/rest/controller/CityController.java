package com.andrey.rest.controller;

import com.andrey.rest.dto.CityDTO;
import com.andrey.rest.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cities/")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("createCity")
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO){

        if(cityDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cityDTO = CityDTO.fromCity(cityService.createCity(CityDTO.toCity(cityDTO)));
        return new ResponseEntity<>(cityDTO,HttpStatus.CREATED);
    }
    @PutMapping("updateCity")
   public ResponseEntity<CityDTO> updateCity(@RequestBody CityDTO cityDTO){
        if(cityDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cityDTO = CityDTO.fromCity(cityService.updateCity(CityDTO.toCity(cityDTO)));

        return new ResponseEntity<CityDTO>(cityDTO,HttpStatus.OK);
    }


}
