package com.example.educa.controller.dto;

import com.example.educa.modelo.Recurso;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

public class RecursoDto {

    private Long id;
    private String titulo;
    private String descricao;
    private String dataCriacao;
    private String dataRegistro;


    public RecursoDto(Recurso recurso) {
        this.id = recurso.getId();
        this.titulo = recurso.getTitulo();
        this.descricao = recurso.getDescricao();
        this.dataCriacao = recurso.getDataCriacao();
        this.dataRegistro = recurso.getDataRegistro();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    public static List<RecursoDto> converter(List<Recurso> recursos){
        return recursos.stream().map(RecursoDto::new).collect(Collectors.toList());
    }
}
