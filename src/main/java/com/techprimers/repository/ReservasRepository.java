package com.techprimers.repository;

import com.techprimers.model.Personas;
import com.techprimers.model.Reservas;
import java.util.Collection;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ReservasRepository extends JpaRepository<Reservas, Integer>{

    Reservas findByIdCabania(Long idCabania);
    Collection<Reservas> findByFechaEntradaBetween(Date date1,Date date2);
    Collection<Reservas> findByFechaEntradaBetweenAndIdPersona(Date date1,Date date2,int dni);
    Collection<Reservas> findByIdPersona(Personas personas);
    Collection<Reservas> findByIdPersonaDni(int dni);
    
    @Query(value ="SELECT * FROM tb_reservas WHERE fecha_entrada <= ?1 AND fecha_salida >= ?2 AND id_suite= ?3" , nativeQuery = true )
    Collection<Reservas> disponibilidad(Date fechaIn, Date fechaOut, int id_suite);
    
    @Query(value ="delete FROM tb_reservas WHERE id_reserva = ?1" , nativeQuery = true )
    void deleteReserva(Integer id);
    
    Integer removeByIdReserva(Integer id);
    
}
