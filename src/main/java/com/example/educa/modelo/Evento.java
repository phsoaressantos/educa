package com.example.educa.modelo;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "idColecao")

public class Evento extends Colecao{


    @Column(length = 10)
    private String dataInicio;
    @Column(length = 10)
    private String dataFim;

    public Evento() {
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
