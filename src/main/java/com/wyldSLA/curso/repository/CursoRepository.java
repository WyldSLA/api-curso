package com.wyldSLA.curso.repository;

import com.wyldSLA.curso.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<CursoModel, UUID> {
}
