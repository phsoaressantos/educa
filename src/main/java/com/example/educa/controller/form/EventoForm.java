package com.example.educa.controller.form;

import com.example.educa.modelo.Colecao;

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

}
