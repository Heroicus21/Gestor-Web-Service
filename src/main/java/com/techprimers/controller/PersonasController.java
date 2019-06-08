package com.techprimers.controller;


import com.techprimers.model.Personas;
import com.techprimers.model.Usuarios;
import com.techprimers.repository.PersonaRespository;
import com.techprimers.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cliente")

public class PersonasController {

    @Autowired
    private PersonaRespository userJpaRespository;

    @GetMapping(value = "/all")
    public List<Personas> findAll() {
        return userJpaRespository.findAll();
    }

    @GetMapping(value = "/{dni}")
    public Personas findByDni(@PathVariable final int dni){
        return userJpaRespository.findByDni(dni);
    }

    @PostMapping(value = "/load")
    public Personas load(@RequestBody final Personas cliente) {
        userJpaRespository.save(cliente);
        return userJpaRespository.findByDni(cliente.getDni());
    }
    
 
    @PutMapping(value = "/delete")
    public boolean delete(@RequestBody final Personas cliente) {
        
        System.err.println("llegamos");
        userJpaRespository.delete(cliente);
        System.err.println("Termino");
        return true;
    }
}
