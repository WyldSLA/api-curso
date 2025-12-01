package com.wyldSLA.curso.controller;

import com.wyldSLA.curso.dto.CursoCreateDto;
import com.wyldSLA.curso.service.impl.CursoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CursoServiceImpl cursoService;

    public CursoController(CursoServiceImpl cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Object> createCurso(@RequestBody CursoCreateDto cursoCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(cursoCreateDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCurso(@PathVariable UUID id, @RequestBody CursoCreateDto cursoCreateDto){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.update(id, cursoCreateDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCurso(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findBy(id));
    }

    @GetMapping()
    public ResponseEntity<Object> getAllCursos(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCurso(@PathVariable UUID id){
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
