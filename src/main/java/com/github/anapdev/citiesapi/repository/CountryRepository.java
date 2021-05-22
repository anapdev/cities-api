package com.github.anapdev.citiesapi.repository;

import com.github.anapdev.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country, Long> {
}
