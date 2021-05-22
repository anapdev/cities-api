package com.github.anapdev.citiesapi.staties;

import com.github.anapdev.citiesapi.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("staties")
public class StateResource {

    @Autowired
    private StateRepository stateRepository;

    @GetMapping
    public Page<State> staties (Pageable page) {

        return stateRepository.findAll(page);
    }

    @GetMapping ("/{id}")
    public ResponseEntity getOne (@PathVariable Long id) {
        Optional<State> optinal = stateRepository.findById(id);

        if(optinal.isPresent()){
            State s = optinal.get();
            s.getCountry();
            return ResponseEntity.ok(s);
        } else {
            return ResponseEntity.notFound().build();
        }


    }
}
