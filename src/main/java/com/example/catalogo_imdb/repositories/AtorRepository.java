package com.example.catalogo_imdb.repositories;

import com.example.catalogo_imdb.models.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AtorRepository extends JpaRepository<Ator, Long> {
    List<Ator> findByNomeIgnoreCaseContaining(String nome);
}