package com.andrey.rest.repository;

import com.andrey.rest.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction,Long> {

}
