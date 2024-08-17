package com.example.catalogo_imdb.repositories;

import com.example.catalogo_imdb.models.Diretor;
import com.example.catalogo_imdb.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByNomeIgnoreCaseContaining(String nome);

    List<Filme> findByDiretorNomeIgnoreCaseContaining(String nomeDiretor);
}
