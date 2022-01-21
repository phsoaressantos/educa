package com.example.educa.controller;

import com.example.educa.controller.dto.RecursoDto;
import com.example.educa.controller.form.RecursoForm;
import com.example.educa.modelo.Recurso;
import com.example.educa.repository.AutorRepository;
import com.example.educa.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/recursos")

public class RecursoController {

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private AutorRepository autorRepository;

//    testar pagina controller, ok!
//    public String recurso() {
//        return "Ola! Aqui temos os Recursos educacionais:";
//    }

    // busca pelo nome autor, caso nao tenha vai trazer tudo

    // Listar todos os recursos, ok!

    @GetMapping
    public List<RecursoDto> lista(String nomeAutor){
        if (nomeAutor == null) {
            List<Recurso> recursos = recursoRepository.findAll();
            return RecursoDto.converter(recursos);
        }else {
            List<Recurso> recursos = recursoRepository.findByAutor_Nome(nomeAutor);
            return RecursoDto.converter(recursos);
        }
    }

    // cadastrar um recurso
    @PostMapping
    @Transactional
    public ResponseEntity<RecursoDto> cadastrar (@RequestBody RecursoForm form, UriComponentsBuilder uriBuilder){
        Recurso recurso = form.converter(autorRepository);
        recursoRepository.save(recurso);

        URI uri = uriBuilder.path("/recursos/{id}").buildAndExpand(recurso.getId()).toUri();
        return ResponseEntity.created(uri).body(new RecursoDto(recurso));

    }

    //um recurso
    @GetMapping("/{id}")
    public RecursoDto detalhar(@PathVariable Long id){
        Recurso recurso = recursoRepository.getById(id);
        return new RecursoDto(recurso);
    }
    // atualizar recurso

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<RecursoDto> atualizar (@PathVariable Long id, @RequestBody RecursoForm form){
        Recurso recurso = form.atualizar(id, recursoRepository);

        return ResponseEntity.ok(new RecursoDto(recurso));
    }

    // deletar recurso

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        recursoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //put ou post para update
    // delete para deletar, exclusao

}
