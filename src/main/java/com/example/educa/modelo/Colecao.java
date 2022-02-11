package com.example.educa.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Colecao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long idColecao;

    @Column(length = 1024)
    private String titulo;

    @Column(length = 4096)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    private Recurso recurso;

    public Colecao() {
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
}
