package com.wyldSLA.curso.service;

import com.wyldSLA.curso.dto.CursoCreateDto;
import com.wyldSLA.curso.dto.CursoResponseDto;
import com.wyldSLA.curso.model.CursoModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CursoService {
    public CursoResponseDto save(CursoCreateDto curso);

    public List<CursoResponseDto> findAll();
    public Optional<CursoResponseDto> findBy(UUID id);
    public CursoResponseDto update(UUID id, CursoCreateDto cursoCreateDto);
    public void delete(UUID id);
}
