package com.example.catalogo_imdb.controllers;

import com.example.catalogo_imdb.models.Filme;
import com.example.catalogo_imdb.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Filme> criarFilme(@RequestBody Filme filme) {
        Filme novoFilme = filmeService.salvarFilme(filme);
        return ResponseEntity.ok(novoFilme);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes() {
        List<Filme> filmes = filmeService.listarFilmes();
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Filme>> buscarFilmesPorNome(@RequestParam String nome) {
        List<Filme> filmes = filmeService.buscarFilmesPorNome(nome);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscar-por-diretor")
    public ResponseEntity<List<Filme>> buscarFilmesPorNomeDoDiretor(@RequestParam String nomeDiretor) {
        List<Filme> filmes = filmeService.buscarFilmesPorNomeDoDiretor(nomeDiretor);
        return ResponseEntity.ok(filmes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filmeAtualizado) {
        Filme filme = filmeService.atualizarFilme(id, filmeAtualizado);
        return ResponseEntity.ok(filme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
        filmeService.deletarFilme(id);
        return ResponseEntity.noContent().build();
    }
}
