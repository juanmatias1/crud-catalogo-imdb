package com.example.catalogo_imdb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataLancamento;

    private BigDecimal orcamento;
    private String descricao;

    @ManyToOne
    private Diretor diretor;

    @ManyToMany
    @JoinTable(
            name = "filme_atores",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Ator> atores;
}
