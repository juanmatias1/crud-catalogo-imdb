package com.example.catalogo_imdb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Diretor extends Pessoa{

    @OneToMany(mappedBy = "diretor")
    private List<Filme> filmes;
}
