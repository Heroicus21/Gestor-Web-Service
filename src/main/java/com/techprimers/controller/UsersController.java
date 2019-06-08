package com.techprimers.controller;


import com.techprimers.model.Usuarios;
import com.techprimers.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import wrappers.LogingWrapper;


@RestController
@RequestMapping("/users")

public class UsersController {

    @Autowired
    private UserJpaRespository userJpaRespository;

    @GetMapping(value = "/all")
    public List<Usuarios> findAll() {
        return userJpaRespository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Usuarios findByName(@PathVariable final String name){
        return userJpaRespository.findByUsuario(name);
    }

    @PostMapping(value = "/load")
    public Usuarios load(@RequestBody final Usuarios users) {
        userJpaRespository.save(users);
        return userJpaRespository.findByUsuario(users.getUsuario());
    }
    
    @RequestMapping(value="/validate", method=RequestMethod.POST)
    public Usuarios validate(@RequestBody LogingWrapper logingWrapper) {
        
        return userJpaRespository.findByUsuarioAndPsw(logingWrapper.getUsuario(),logingWrapper.getPsw());
    }
}
