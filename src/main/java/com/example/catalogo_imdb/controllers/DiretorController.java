package com.example.catalogo_imdb.controllers;

import com.example.catalogo_imdb.models.Diretor;
import com.example.catalogo_imdb.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    public ResponseEntity<Diretor> criarDiretor(@RequestBody Diretor diretor) {
        Diretor novoDiretor = diretorService.salvarDiretor(diretor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDiretor);
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> listarDiretores() {
        List<Diretor> diretores = diretorService.listarDiretores();
        return ResponseEntity.ok(diretores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretor> buscarDiretorPorId(@PathVariable Long id) {
        Diretor diretor = diretorService.buscarDiretorPorId(id);
        return ResponseEntity.ok(diretor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Diretor> atualizarDiretor(@PathVariable Long id, @RequestBody Diretor diretorAtualizado) {
        Diretor diretor = diretorService.atualizarDiretor(id, diretorAtualizado);
        return ResponseEntity.ok(diretor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarDiretor(@PathVariable Long id) {
        diretorService.deletarDiretor(id);
        return ResponseEntity.noContent().build();
    }
}
