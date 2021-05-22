package com.github.anapdev.citiesapi.countries;

import com.github.anapdev.citiesapi.countries.Country;
import com.github.anapdev.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("countries")
public class CountryResource {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Page<Country> countires (Pageable page) {
        
        return countryRepository.findAll(page);
    }

    @GetMapping ("/{id}")
    public ResponseEntity getOne (@PathVariable Long id) {
        Optional<Country> optinal = countryRepository.findById(id);

        if(optinal.isPresent()){
            return ResponseEntity.ok(optinal.get());
        } else {
            return ResponseEntity.notFound().build();
        }


    }
}
