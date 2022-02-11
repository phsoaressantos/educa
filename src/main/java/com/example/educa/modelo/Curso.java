package com.example.educa.modelo;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "idColecao")

public class Curso extends Colecao{


    @Column(length = 10)
    private String dataRegistro;

    public Curso(){
    }


    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
