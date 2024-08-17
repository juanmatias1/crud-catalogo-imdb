package com.example.catalogo_imdb.service;

import com.example.catalogo_imdb.exceptions.ResourceNotFoundException;
import com.example.catalogo_imdb.models.Ator;
import com.example.catalogo_imdb.repositories.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public Ator salvarAtor(Ator ator) {
        return atorRepository.save(ator);
    }

    public List<Ator> listarAtores() {
        return atorRepository.findAll();
    }

    public Ator buscarAtorPorId(Long id) {
        return atorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ator não encontrado com ID: " + id));
    }

    public Ator atualizarAtor(Long id, Ator atorAtualizado) {
        Ator ator = buscarAtorPorId(id);
        ator.setNome(atorAtualizado.getNome());
        return atorRepository.save(ator);
    }

    public void deletarAtor(Long id) {
        Ator ator = buscarAtorPorId(id);
        atorRepository.delete(ator);
    }
}
