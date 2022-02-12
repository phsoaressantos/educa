package com.example.educa.controller.dto;


import com.example.educa.modelo.Curso;

public class CursoDto {

    private String dataRegistro;

    public CursoDto(Curso curso) {
        this.dataRegistro=curso.getDataRegistro();
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
