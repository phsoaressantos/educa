package com.example.educa.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 256)
    private String email;

    @Column(length = 64)
    private String nome;

    @Column(length = 64)
    private String sobrenome;

    @Column(length = 256)
    private String afiliacao;

    @Column(length = 20)
    private String orcid;

    @OneToMany(mappedBy = "autor")
    private List<Recurso> recursos = new ArrayList<>();


}
