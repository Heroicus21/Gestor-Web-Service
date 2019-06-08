package com.techprimers.repository;

import com.techprimers.model.Personas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonaRespository extends JpaRepository<Personas, Long>{

    Personas findByNombre(String nombre);
    Personas findByDni(int dni);
    void deleteByDni(int dni);
}
