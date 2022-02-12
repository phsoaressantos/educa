package com.example.educa.controller.form;

import com.example.educa.modelo.Colecao;
import com.example.educa.modelo.Curso;
import com.example.educa.modelo.Evento;
import com.example.educa.repository.CursoRepository;
import com.example.educa.repository.EventoRepository;

import java.util.List;

public class CursoForm extends ColecaoForm {

    private String dataRegistro;


    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Curso converter(CursoRepository cursoRepository){
        List<Curso> cursos = cursoRepository.findAll();
        return new Curso();
    }

    public Curso atualizar(Long id, CursoRepository cursoRepository){
        Curso curso = cursoRepository.getById(id);

        curso.setDataRegistro(this.dataRegistro);

        return curso;
    }

}
