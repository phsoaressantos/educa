package com.example.educa.controller;

import com.example.educa.controller.dto.RecursoDto;
import com.example.educa.controller.form.RecursoForm;
import com.example.educa.modelo.Recurso;
import com.example.educa.repository.AutorRepository;
import com.example.educa.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RestController
@RequestMapping("/recurso")

public class RecursoController {

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private AutorRepository autorRepository;


    //testar pagina controller, ok!
//    public String recurso() {
//        return "Ola! Aqui temos os Recursos educacionais:";
//    }

    // busca pelo nome autor, caso nao tenha vai trazer tudo
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

    // cadastro
    @PostMapping
    public void cadastrar (@RequestBody RecursoForm form){
        Recurso recurso = form.converter(autorRepository);
        recursoRepository.save(recurso);

    }

}
