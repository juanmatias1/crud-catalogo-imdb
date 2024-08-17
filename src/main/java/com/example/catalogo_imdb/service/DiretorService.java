package com.example.catalogo_imdb.service;

import com.example.catalogo_imdb.exceptions.ResourceNotFoundException;
import com.example.catalogo_imdb.models.Diretor;
import com.example.catalogo_imdb.repositories.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;

    public Diretor salvarDiretor(Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    public List<Diretor> listarDiretores() {
        return diretorRepository.findAll();
    }

    public Diretor buscarDiretorPorId(Long id) {
        return diretorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diretor não encontrado com ID: " + id));
    }

    public Diretor atualizarDiretor(Long id, Diretor diretorAtualizado) {
        Diretor diretor = buscarDiretorPorId(id);
        diretor.setNome(diretorAtualizado.getNome());
        return diretorRepository.save(diretor);
    }

    public void deletarDiretor(Long id) {
        Diretor diretor = buscarDiretorPorId(id);
        diretorRepository.delete(diretor);
    }
}
