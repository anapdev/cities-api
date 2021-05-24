package com.github.anapdev.citiesapi.repository;

import com.github.anapdev.citiesapi.cities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository <City, Long> {

    @Query(value = "SELECT (((acos(sin((:latCityOne*pi()/180)) * sin((:latCityTwo*pi()/180))+cos((:latCityOne*pi()/180)) * cos((:latCityTwo*pi()/180)) * cos(((:longCityOne- :longCityTwo)* pi()/180))))*180/pi())*60*1.1515 ) as distance FROM `cidade` LIMIT 1", nativeQuery = true)
    Double distanceByPoints(
            @Param("latCityOne") double latCityOne,
            @Param("longCityOne") double longCityOne,
            @Param("latCityTwo") double latCityTwo,
            @Param("longCityTwo") double longCityTwo);

    @Query(value = "SELECT 1609.34 * 3959 * ACOS( " +
            "        COS(RADIANS(:latCityOne)) * COS(RADIANS(:latCityTwo)) * COS( RADIANS(:longCityTwo) - RADIANS(:longCityOne) ) " +
            "        + SIN(RADIANS(:latCityOne)) * SIN(RADIANS(:latCityTwo)) " +
            "       ) FROM cidade LIMIT 1", nativeQuery = true)
    Double distanceByCube(
            @Param("latCityOne") double latCityOne,
            @Param("longCityOne") double longCityOne,
            @Param("latCityTwo") double latCityTwo,
            @Param("longCityTwo") double longCityTwo);
}