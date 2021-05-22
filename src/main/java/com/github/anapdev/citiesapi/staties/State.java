package com.github.anapdev.citiesapi.staties;

import com.github.anapdev.citiesapi.countries.Country;

import javax.persistence.*;

@Entity(name = "State")
@Table(name = "estado")

public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

  /* 1st
  @Column(name = "pais")
  private Integer countryId;*/

    // 2nd - @ManyToOne
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Column(name = "ddd")
    private String ddd;

    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public String getDdd() {
        return ddd;
    }

    public Country getCountry() {
        return country;
    }

  /*public Integer getCountryId() {
      return countryId;
  }*/
}