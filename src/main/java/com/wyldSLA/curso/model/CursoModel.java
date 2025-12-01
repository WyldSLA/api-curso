package com.wyldSLA.curso.model;

import com.wyldSLA.curso.enums.CursoCategoria;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "cursos")
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private CursoCategoria cursoCategoria;
}
