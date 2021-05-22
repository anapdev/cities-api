package com.github.anapdev.citiesapi.countries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Country {

    @Id
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "nome_pt")
    private String portugueseNome;

    @Column (name = "sigla")
    private String code;

    private Integer bacen;

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPortugueseNome() {
        return portugueseNome;
    }

    public String getCode() {
        return code;
    }

    public Integer getBacen() {
        return bacen;
    }
}
