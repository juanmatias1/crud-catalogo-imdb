package com.example.catalogo_imdb.controllers;

import com.example.catalogo_imdb.models.Ator;
import com.example.catalogo_imdb.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    public ResponseEntity<Ator> criarAtor(@RequestBody Ator ator) {
        Ator novoAtor = atorService.salvarAtor(ator);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAtor);
    }

    @GetMapping
    public ResponseEntity<List<Ator>> listarAtores() {
        List<Ator> atores = atorService.listarAtores();
        return ResponseEntity.ok(atores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ator> buscarAtorPorId(@PathVariable Long id) {
        Ator ator = atorService.buscarAtorPorId(id);
        return ResponseEntity.ok(ator);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ator> atualizarAtor(@PathVariable Long id, @RequestBody Ator atorAtualizado) {
        Ator ator = atorService.atualizarAtor(id, atorAtualizado);
        return ResponseEntity.ok(ator);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarAtor(@PathVariable Long id) {
        atorService.deletarAtor(id);
        return ResponseEntity.noContent().build();
    }
}
