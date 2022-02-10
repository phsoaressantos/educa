package com.example.educa.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 1024)
    private String titulo;

    @Column(length = 4096)
    private String descricao;

    @Column(length = 10)
    private String dataCriacao;
    // private LocalDateTime dataCriacao = localDateTime.now();

    @Column(length = 10)
    private String dataRegistro;

    @ManyToOne
    //  @JoinColumn (name = "autor_id")
    private Autor autor;

    @OneToMany (mappedBy = "recurso")
    private List<Colecao> colecaos = new ArrayList<>();


    public Recurso () {
    }

    public Recurso(String titulo, String descricao, String dataCriacao, String dataRegistro, Autor autor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataRegistro = dataRegistro;
        this.autor = autor;
    }

    // Get And Setters

    public List<Colecao> getColecaos() {
        return colecaos;
    }

    public void setColecaos(List<Colecao> colecaos) {
        this.colecaos = colecaos;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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



}
