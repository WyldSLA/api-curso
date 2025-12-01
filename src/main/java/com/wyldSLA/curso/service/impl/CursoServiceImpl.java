package com.wyldSLA.curso.service.impl;

import com.wyldSLA.curso.dto.CursoCreateDto;
import com.wyldSLA.curso.dto.CursoResponseDto;
import com.wyldSLA.curso.mapper.CursoMapper;
import com.wyldSLA.curso.model.CursoModel;
import com.wyldSLA.curso.repository.CursoRepository;
import com.wyldSLA.curso.service.CursoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoServiceImpl(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    @Transactional
    @Override
    public CursoResponseDto save(CursoCreateDto cursoCreateDto) {
        CursoModel curso = cursoMapper.toCursoModel(cursoCreateDto);
        var newCurso = cursoRepository.save(curso);
        return cursoMapper.toResponseCurso(newCurso);
    }

    @Override
    public List<CursoResponseDto> findAll() {
        return cursoMapper.toResponseCursoList(cursoRepository.findAll());
    }


    @Override
    public Optional<CursoResponseDto> findBy(UUID id) {
        return cursoRepository.findById(id).map(cursoMapper::toResponseCurso);
    }

    @Override
    public CursoResponseDto update(UUID id, CursoCreateDto dto) {
        CursoModel updateCurso = cursoRepository.findById(id).get();

        updateCurso.setNome(dto.nome());
        updateCurso.setCargaHoraria(dto.cargaHoraria());
        updateCurso.setCursoCategoria(dto.cursoCategoria());
        updateCurso.setDescricao(dto.descricao());

        CursoModel newCurso = cursoRepository.save(updateCurso);

        return cursoMapper.toResponseCurso(newCurso);
    }

    @Override
    public void delete(UUID id) {
        cursoRepository.deleteById(id);
    }

}
