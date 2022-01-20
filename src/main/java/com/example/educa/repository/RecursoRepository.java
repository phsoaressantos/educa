package com.example.educa.repository;

import com.example.educa.modelo.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    default List<Recurso> findByAutor_Nome(String nomeAutor) {
        return null;
    }
}