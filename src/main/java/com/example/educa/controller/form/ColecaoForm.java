package com.example.educa.controller.form;

import com.example.educa.modelo.Autor;
import com.example.educa.modelo.Colecao;
import com.example.educa.modelo.Recurso;
import com.example.educa.repository.AutorRepository;
import com.example.educa.repository.ColecaoRepository;
import com.example.educa.repository.RecursoRepository;

import java.util.List;

public class ColecaoForm {

    private Long idColecao;
    private String titulo;
    private String descricao;
    private Recurso recurso;

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

    public Colecao converter(ColecaoRepository colecaoRepository){
        List<Colecao> colecoes = colecaoRepository.findAll();            // duvida se vai passar ou nao?
        return new Colecao();
    }

    public Colecao atualizar(Long id, ColecaoRepository colecaoRepository){
        Colecao colecao = colecaoRepository.getById(idColecao);                  // confirmar se vai pegar id

        colecao.setTitulo(this.titulo);
        colecao.setDescricao(this.descricao);
        colecao.setRecurso(this.recurso);

        return colecao;
    }


}
