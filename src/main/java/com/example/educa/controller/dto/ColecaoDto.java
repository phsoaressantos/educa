package com.example.educa.controller.dto;

import com.example.educa.modelo.Colecao;
import com.example.educa.modelo.Recurso;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

public class ColecaoDto {

    private Long idColecao;
    private String titulo;
    private String descricao;
    private Recurso recurso;

    public ColecaoDto(Colecao colecao) {
        this.idColecao = colecao.getIdColecao();
        this.titulo = colecao.getTitulo();
        this.descricao = colecao.getDescricao();
        this.recurso = colecao.getRecurso();
    }

    public Long getIdColecao() {
        return idColecao;
    }

    public void setIdColecao(Long idColecao) {
        this.idColecao = idColecao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public static List<ColecaoDto> converter(List<Colecao> colecoes){
        return colecoes.stream().map(ColecaoDto::new).collect(Collectors.toList());
    }

}
