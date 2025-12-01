package com.wyldSLA.curso.dto;

import com.wyldSLA.curso.enums.CursoCategoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CursoCreateDto(

        @NotBlank(message = "O nome não pode estar vazio")
        String nome,

        @NotNull(message = "A carga horária é obrigatória")
        @Positive(message = "A carga horária deve ser um número positivo")
        Integer cargaHoraria,

        @NotBlank(message = "A descrição não pode estar vazia")
        String descricao,

        @NotNull(message = "A categoria do curso é obrigatória")
        CursoCategoria cursoCategoria

) {}
