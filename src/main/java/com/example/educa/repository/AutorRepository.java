package com.example.educa.repository;

import com.example.educa.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNome(Autor nome);
}

//  Autor findByNome(Autor nome);   assim funcionava precisa mexer nisso

// assim q deveria ser correto. vedo 09 aula 3
//List<Autor> findByNome(String nomeAutor);


//recursoRepository.findByAutor_Nome(nomeAutor);