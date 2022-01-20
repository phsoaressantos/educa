package com.example.educa.controller;

import com.example.educa.controller.dto.RecursoDto;
import com.example.educa.modelo.Recurso;
import com.example.educa.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RecursoController {

    @Autowired
    private RecursoRepository recursoRepository;

    @RequestMapping("/recurso")
    //testar pagina controller, ok!
//    public String recurso() {
//        return "Ola! Aqui temos os Recursos educacionais:";
//    }

    // busca pelo nome autor, caso nao tenha vai trazer tudo

    public List<RecursoDto> lista(String nomeAutor){
        if (nomeAutor == null) {
            List<Recurso> recursos = recursoRepository.findAll();
            return RecursoDto.converter(recursos);
        }else {
            List<Recurso> recursos = recursoRepository.findByAutor_Nome(nomeAutor);
            return RecursoDto.converter(recursos);
        }
    }

}
