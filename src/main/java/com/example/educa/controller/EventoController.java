package com.example.educa.controller;

import com.example.educa.controller.dto.EventoDto;
import com.example.educa.controller.dto.EventoDto;
import com.example.educa.controller.dto.EventoDto;
import com.example.educa.controller.form.EventoForm;
import com.example.educa.modelo.Evento;
import com.example.educa.modelo.Evento;
import com.example.educa.repository.EventoRepository;
import com.example.educa.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    // listar todos
    @GetMapping
    public List<EventoDto> lista(String nomeEvento){
        List<Evento> eventos = eventoRepository.findAll();
        return EventoDto.converter (eventos);
    }

    //um evento

    @GetMapping("/{id}")
    public EventoDto detalhar(@PathVariable Long id){
        Evento evento = eventoRepository.getById(id);
        return new EventoDto(evento);
    }

    // cadastrar
    @PostMapping
    @Transactional
    public ResponseEntity<EventoDto> cadastrar (@RequestBody EventoForm form, UriComponentsBuilder uriBuilder){
        Evento evento = form.converter(eventoRepository);
        eventoRepository.save(evento);

        URI uri = uriBuilder.path("/eventos/{id}").buildAndExpand(evento.getIdColecao()).toUri();
        return ResponseEntity.created(uri).body(new EventoDto(evento));
    }

    // atualizar

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventoDto> atualizar (@PathVariable Long id, @RequestBody EventoForm form){
        Evento evento = form.atualizar(id, eventoRepository);
        return ResponseEntity.ok(new EventoDto(evento));

    }

    // deletar

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        eventoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
