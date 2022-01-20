package com.example.educa.modelo;

import javax.persistence.*;
import java.util.ArrayList;

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

    @Column(length = 10)
    private String dataRegistro;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Recurso () {
    }

    // Get And Setters

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

//  @OneToMany(mappedBy = "colecao")
//  private List<Colecao> colecaos = new ArrayList<>();



// um recurso possui uma lista ordenada de autores
//    @OneToMany(mappedBy = "autor")
//    private List<Autor> autores = new ArrayList<>();

 //   @OneToMany(mappedBy = "topico")
 //   private List<Resposta> respostas = new ArrayList<>();





}
