package com.andrey.rest.controller;

import com.andrey.rest.dto.AttractionDto;
import com.andrey.rest.service.AttractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }
    @GetMapping("getAll")
    public ResponseEntity<List<AttractionDto>> getAllAttractions() {
        List<AttractionDto> attractionDtoList = AttractionDto
                .attractionDtoList(attractionService.getAllAttractions());

        return new ResponseEntity<List<AttractionDto>>(attractionDtoList,HttpStatus.OK);
    }

    /*public ResponseEntity<> getAllAttractionsByCityId() {

        return
    }*/
     @PostMapping("createAttraction")
    public ResponseEntity<AttractionDto> createAttraction(@RequestBody AttractionDto attractionDto) {
            attractionService.createAttraction(AttractionDto.toAttraction(attractionDto));

        return new ResponseEntity<>(HttpStatus.OK);
    }

   /* public ResponseEntity<> updateAttraction(DAO dao) {

        return
    }

    public ResponseEntity<> deleteAttraction(){

        return
    }*/
}
