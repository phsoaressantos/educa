package com.example.educa.controller;

import com.example.educa.controller.dto.ColecaoDto;
import com.example.educa.controller.dto.ColecaoDto;
import com.example.educa.controller.form.ColecaoForm;
import com.example.educa.controller.form.ColecaoForm;
import com.example.educa.modelo.Colecao;
import com.example.educa.modelo.Colecao;
import com.example.educa.repository.ColecaoRepository;
import com.example.educa.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/colecoes")

public class ColecaoController {

    @Autowired
    private ColecaoRepository colecaoRepository;

    // listar todos
    @GetMapping
    public List<ColecaoDto> lista(String nomeColecao){
        List<Colecao> colecoes = colecaoRepository.findAll();
        return ColecaoDto.converter(colecoes);
    }
    //uma colecao

    @GetMapping("/{id}")
    public ColecaoDto detalhar(@PathVariable Long id){
        Colecao colecao = colecaoRepository.getById(id);
        return new ColecaoDto(colecao);
    }
    
    
    // cadastrar
    @PostMapping
    @Transactional
    public ResponseEntity<ColecaoDto> cadastrar (@RequestBody ColecaoForm form, UriComponentsBuilder uriBuilder){
        Colecao colecao = form.converter(colecaoRepository);
        colecaoRepository.save(colecao);

        URI uri = uriBuilder.path("/colecoes/{id}").buildAndExpand(colecao.getIdColecao()).toUri();
        return ResponseEntity.created(uri).body(new ColecaoDto(colecao));
    }

    // atualizar

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ColecaoDto> atualizar (@PathVariable Long id, @RequestBody ColecaoForm form){
        Colecao colecao = form.atualizar(id, colecaoRepository);
        return ResponseEntity.ok(new ColecaoDto(colecao));

    }

    // deletar

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        colecaoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
