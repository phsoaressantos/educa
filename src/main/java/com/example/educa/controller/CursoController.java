package com.example.educa.controller;


import com.example.educa.controller.dto.CursoDto;
import com.example.educa.controller.dto.EventoDto;
import com.example.educa.controller.form.CursoForm;
import com.example.educa.controller.form.EventoForm;
import com.example.educa.modelo.Curso;
import com.example.educa.modelo.Evento;
import com.example.educa.repository.CursoRepository;
import com.example.educa.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")

public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    // listar todos
    @GetMapping
    public List<CursoDto> lista(String nomeCurso){
        List<Curso> cursos = cursoRepository.findAll();
        return CursoDto.converter (cursos);
    }

    //um curso

    @GetMapping("/{id}")
    public CursoDto detalhar(@PathVariable Long id){
        Curso curso = cursoRepository.getById(id);
        return new CursoDto(curso);
    }
    // cadastrar
    @PostMapping
    @Transactional
    public ResponseEntity<CursoDto> cadastrar (@RequestBody CursoForm form, UriComponentsBuilder uriBuilder){
        Curso curso = form.converter(cursoRepository);
        cursoRepository.save(curso);

        URI uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getIdColecao()).toUri();
        return ResponseEntity.created(uri).body(new CursoDto(curso));
    }

    // atualizar

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CursoDto> atualizar (@PathVariable Long id, @RequestBody CursoForm form){
        Curso curso = form.atualizar(id, cursoRepository);
        return ResponseEntity.ok(new CursoDto(curso));

    }

    // deletar

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        cursoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    

}
