package com.example.educa.controller.form;

import com.example.educa.modelo.Autor;
import com.example.educa.modelo.Recurso;
import com.example.educa.repository.AutorRepository;
import com.example.educa.repository.RecursoRepository;

import java.util.List;

public class AutorForm {

    private String email;
    private String nome;
    private String sobrenome;
    private String afiliacao;
    private String orcid;
    private String nomeAutor;                                                // retorar

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


    public Autor converter(RecursoRepository recursoRepository){
        List<Recurso> recurso = recursoRepository.findByAutor_Nome(nomeAutor);
        return new Autor(email, nome, sobrenome, afiliacao, orcid);
    }

//    public Autor converter(AutorRepository autorRepository){
//        Autor autor = autorRepository.findByNome(nomeAutor);
//        return new Autor(email, nome, sobrenome, afiliacao, orcid);
//    }

    public Autor atualizar(Long id, AutorRepository autorRepository){
        Autor autor = autorRepository.getById(id);

        autor.setEmail(this.email);
        autor.setNome(this.nome);
        autor.setSobrenome(this.sobrenome);
        autor.setAfiliacao(this.afiliacao);
        autor.setOrcid(this.orcid);

        return autor;
    }

}
