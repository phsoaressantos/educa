package com.example.educa.repository;

import com.example.educa.modelo.Colecao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColecaoRepository extends JpaRepository<Colecao, Long> {


    List<Colecao> findColecaoByDescricao(String descricao);
}


//     List<Recurso> findByAutor_Nome(String nomeAutor);
//}