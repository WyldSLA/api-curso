package com.wyldSLA.curso.dto;

import com.wyldSLA.curso.enums.CursoCategoria;

public record CursoResponseDto(
        String nome,
        Integer cargaHoraria,
        String descricao,
        CursoCategoria cursoCategoria
) {
}
