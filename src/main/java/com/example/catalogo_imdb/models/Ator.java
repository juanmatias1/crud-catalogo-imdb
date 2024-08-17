package com.example.catalogo_imdb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Ator extends Pessoa{

    @ManyToMany(mappedBy = "atores")
    private List<Filme> filmes;
}
