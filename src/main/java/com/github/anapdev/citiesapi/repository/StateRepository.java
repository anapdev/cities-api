package com.github.anapdev.citiesapi.repository;

import com.github.anapdev.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository <State, Long> {
}
