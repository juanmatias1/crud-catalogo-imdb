package com.example.catalogo_imdb.repositories;

import com.example.catalogo_imdb.models.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    List<Diretor> findByNomeIgnoreCaseContaining(String nome);
}
