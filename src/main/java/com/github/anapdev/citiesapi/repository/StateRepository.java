package com.github.anapdev.citiesapi.repository;

import com.github.anapdev.citiesapi.staties.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository <State, Long> {
}
