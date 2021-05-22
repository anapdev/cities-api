package com.github.anapdev.citiesapi.cities;

import com.github.anapdev.citiesapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("cities")
public class CityResource {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public Page<City> countires (Pageable page) {

        return cityRepository.findAll(page);
    }

    @GetMapping ("/{id}")
    public ResponseEntity getOne (@PathVariable Long id) {
        Optional<City> optinal = cityRepository.findById(id);

        if(optinal.isPresent()){
            return ResponseEntity.ok(optinal.get());
        } else {
            return ResponseEntity.notFound().build();
        }


    }
}
