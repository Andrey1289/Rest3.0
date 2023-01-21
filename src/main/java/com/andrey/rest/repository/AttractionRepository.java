package com.andrey.rest.repository;

import com.andrey.rest.entity.Attraction;
import com.andrey.rest.entity.TypeAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction,Long> {
    public List<Attraction> findAllBycity_id(Long id);
    public void deleteBynameAttraction(String name);
    public List<Attraction> findAllBytypeAttraction(TypeAttraction typeAttraction);

}
