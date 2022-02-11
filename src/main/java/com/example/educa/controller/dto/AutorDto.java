package com.example.educa.controller.dto;

import com.example.educa.modelo.Autor;
import com.example.educa.modelo.Recurso;

import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {

    private Long id;
    private String email;
    private String nome;
    private String sobrenome;
    private String afiliacao;
    private String orcid;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.email = autor.getEmail();
        this.nome = autor.getNome();
        this.sobrenome = autor.getSobrenome();
        this.afiliacao = autor.getAfiliacao();
        this.orcid = autor.getOrcid();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

        public static List<AutorDto> converter(List<Autor> autores){
        return autores.stream().map(AutorDto::new).collect(Collectors.toList());
        
    }

}
