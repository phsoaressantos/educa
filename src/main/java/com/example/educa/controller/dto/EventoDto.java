package com.example.educa.controller.dto;

import com.example.educa.modelo.Curso;
import com.example.educa.modelo.Evento;

import javax.persistence.Column;

public class EventoDto {

    private String dataInicio;
    private String dataFim;

        public EventoDto(Evento evento) {
            this.dataInicio= evento.getDataInicio();
            this.dataFim= evento.getDataFim();
        }

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
}
