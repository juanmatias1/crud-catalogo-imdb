package com.example.catalogo_imdb.service;

import com.example.catalogo_imdb.exceptions.ResourceNotFoundException;
import com.example.catalogo_imdb.models.Filme;
import com.example.catalogo_imdb.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme salvarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public List<Filme> buscarFilmesPorNomeDoDiretor(String nomeDiretor) {
        return filmeRepository.findByDiretorNomeIgnoreCaseContaining(nomeDiretor);
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Filme buscarFilmePorId(Long id) {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com ID: " + id));
    }

    public List<Filme> buscarFilmesPorNome(String nome) {
        return filmeRepository.findByNomeIgnoreCaseContaining(nome);
    }

    public Filme atualizarFilme(Long id, Filme filmeAtualizado) {
        Filme filme = buscarFilmePorId(id);
        filme.setNome(filmeAtualizado.getNome());
        filme.setDataLancamento(filmeAtualizado.getDataLancamento());
        filme.setOrcamento(filmeAtualizado.getOrcamento());
        filme.setDescricao(filmeAtualizado.getDescricao());
        filme.setDiretor(filmeAtualizado.getDiretor());
        filme.setAtores(filmeAtualizado.getAtores());
        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id) {
        Filme filme = buscarFilmePorId(id);
        filmeRepository.delete(filme);
    }
}
