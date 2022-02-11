package com.example.educa.controller;

import com.example.educa.controller.dto.AutorDto;
import com.example.educa.controller.dto.RecursoDto;
import com.example.educa.controller.form.AutorForm;
import com.example.educa.controller.form.RecursoForm;
import com.example.educa.modelo.Autor;
import com.example.educa.modelo.Recurso;
import com.example.educa.repository.AutorRepository;
import com.example.educa.repository.AutorRepository;
import com.example.educa.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")

public class AutorController {

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private AutorRepository autorRepository;
    private Object nome;

//    testar pagina controller, ok!
//    public String recurso() {
//        return "Ola! Aqui temos os autores educacionais:";
//    }

    // busca pelo nome autor, caso nao tenha vai trazer tudo

    // Listar todos os autores, ok!

    @GetMapping

       public List<AutorDto> lista(String nomeAutor){
//        if (nomeAutor == null) {
            List<Autor> autores = autorRepository.findAll();
            return AutorDto.converter(autores);
        }
//        else {
//            //List<Autor> autores = autorRepository.findByNome(Autor nome);
//
//            //Autor findByNome(Autor nome);
//            return AutorDto.converter(autores);
//        }
//    }

    // cadastrar
    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar (@RequestBody AutorForm form, UriComponentsBuilder uriBuilder){
        Autor autor = form.converter(recursoRepository);
        autorRepository.save(autor);

        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorDto(autor));

    }

    //um autor

    @GetMapping("/{id}")
    public AutorDto detalhar(@PathVariable Long id){
        Autor autor = autorRepository.getById(id);
        return new AutorDto(autor);
    }

    // atualizar

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AutorDto> atualizar (@PathVariable Long id, @RequestBody AutorForm form){
        Autor autor = form.atualizar(id, autorRepository);
        return ResponseEntity.ok(new AutorDto(autor));

    }

    // deletar

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        autorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //put ou post para update, utizei put

}
