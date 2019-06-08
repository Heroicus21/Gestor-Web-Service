package com.techprimers;

import com.techprimers.model.Personas;
import com.techprimers.model.Reservas;
import com.techprimers.model.Suites;
import com.techprimers.model.Usuarios;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.techprimers.repository.PersonaRespository;
import com.techprimers.repository.UserJpaRespository;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import com.techprimers.repository.ReservasRepository;
import com.techprimers.repository.SuiteRepository;
import java.util.Collection;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ReservaRepositoryApplicationTests {
    
     @Autowired
    public PersonaRespository personaRepository;
    
    @Autowired
    public ReservasRepository reservaRepository;
    
    @Autowired
    public  UserJpaRespository userRepository;
        
    @Autowired
    public SuiteRepository suitesRepository;
//	@Test
//	public void addReserva() {
//            
//            
//            Personas persona=personaRepository.findByDni(34970725);
//            Usuarios usuario=userRepository.findByUsuario("admin");
//            
//            Reservas reserva = new Reservas(1, persona, usuario, new Date(), new Date());
//            reservaRepository.save(reserva);
//            List<Reservas> reservas=reservaRepository.findAll();
//            Assert.assertNotNull(reservas);
//            
//	}
        
//        @Test
//        public void listAllReservas() {
//            
//            List<Reservas> reservas=reservaRepository.findAll();
//            Assert.assertNotNull(reservas);
//            
//	}
        
//        @Test
//	public void editReserva() {
//            
//            Personas persona=personaRepository.findByDni(34970725);
//            Usuarios usuario=userRepository.findByUsuario("admin");
//            
//            Reservas reservaAdd = new Reservas(1, persona, usuario, new Date(), new Date());
//            reservaRepository.save(reservaAdd);
//            Reservas reserva=reservaRepository.findOne(1);
//            
//            
//            Suites suites=suitesRepository.findOne(1);
//            reserva.setIdCabania(suites);
//            reservaRepository.save(reserva);
//            Reservas result=reservaRepository.findOne(1);
//            Assert.assertNotNull(result);
//            Assert.assertEquals(1, result.getIdCabania().getIdSuite());
//            
//	}
//        @Test
//	public void findReservaByIdCabania() {
//            
//            Personas persona=personaRepository.findByDni(34970725);
//          
//            Collection<Reservas> reservas=reservaRepository.findByIdPersona(persona);
//            
//
//            Assert.assertFalse(reservas.isEmpty());
//            
//	}

}
