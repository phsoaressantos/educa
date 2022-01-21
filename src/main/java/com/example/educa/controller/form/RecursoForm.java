package com.example.educa.controller.form;

import com.example.educa.modelo.Autor;
import com.example.educa.modelo.Recurso;
import com.example.educa.repository.AutorRepository;
import com.example.educa.repository.RecursoRepository;

public class RecursoForm {

    private String titulo;
    private String descricao;
    private String data_registro;
    private String data_criacao;
    private String nomeAutor;

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

    public String getData_registro() {
        return data_registro;
    }

    public void setData_registro(String data_registro) {
        this.data_registro = data_registro;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }


    public Recurso converter(AutorRepository autorRepository){
        Autor autor = autorRepository.findByNome(nomeAutor);
        return new Recurso(titulo, descricao, data_registro, data_criacao, autor);
    }


}
