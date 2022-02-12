package com.example.educa.controller.dto;


import com.example.educa.modelo.Curso;
import com.example.educa.modelo.Evento;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<CursoDto> converter(List<Curso> cursos) {
        return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
    }

}
