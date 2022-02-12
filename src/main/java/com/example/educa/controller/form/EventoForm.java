package com.example.educa.controller.form;

import com.example.educa.modelo.Colecao;
import com.example.educa.modelo.Evento;
import com.example.educa.repository.ColecaoRepository;
import com.example.educa.repository.EventoRepository;

import java.util.List;

public class EventoForm extends ColecaoForm {

    private String dataInicio;
    private String dataFim;


    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Evento converter(EventoRepository eventoRepository){
        List<Evento> eventos = eventoRepository.findAll();
        return new Evento();
    }

    public Evento atualizar(Long id, EventoRepository eventoRepository){
        Evento evento = eventoRepository.getById(id);

        evento.setDataInicio(this.dataInicio);
        evento.setDataFim(this.getDataFim());

        return evento;
    }

}
