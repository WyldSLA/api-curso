package com.wyldSLA.curso.mapper;

import com.wyldSLA.curso.dto.CursoCreateDto;
import com.wyldSLA.curso.dto.CursoResponseDto;
import com.wyldSLA.curso.model.CursoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mapping(source = "cursoCategoria", target = "cursoCategoria")
    @Mapping(target = "id", ignore = true)
    CursoModel toCursoModel(CursoCreateDto dto);

    CursoResponseDto toResponseCurso(CursoModel model);

    List<CursoResponseDto> toResponseCursoList(List<CursoModel> cursos);
}
