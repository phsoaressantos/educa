package com.example.educa.repository;

import com.example.educa.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNome(Autor nome);
}

//  Autor findByNome(Autor nome);
//recursoRepository.findByAutor_Nome(nomeAutor);