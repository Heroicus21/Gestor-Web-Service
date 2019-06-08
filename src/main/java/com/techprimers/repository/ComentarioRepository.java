package com.techprimers.repository;

import com.techprimers.model.Comentario;
import com.techprimers.model.Pago;
import com.techprimers.model.Personas;
import com.techprimers.model.Reservas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{
 
}