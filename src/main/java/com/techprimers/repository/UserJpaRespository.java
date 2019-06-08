package com.techprimers.repository;


import com.techprimers.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJpaRespository extends JpaRepository<Usuarios, Long>{

    Usuarios findByUsuario(String name);
    Usuarios findByUsuarioAndPsw(String usuario,String psw);
}
