package com.techprimers.repository;

import com.techprimers.model.Personas;
import com.techprimers.model.Suites;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SuiteRepository extends JpaRepository<Suites, Integer>{

    Personas findByNombre(String nombre);
    
    
}
