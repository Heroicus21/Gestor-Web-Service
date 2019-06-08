package com.techprimers;

import com.techprimers.model.Personas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.techprimers.repository.PersonaRespository;
import java.util.List;
import org.junit.Assert;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class PersonaRepositoryApplicationTests {
    
    @Autowired
    public PersonaRespository personaRepository;
        
//	@Test
//	public void listPersonas() {
//            
//            List<Personas> personas=personaRepository.findAll();
//            Assert.assertNotNull(personas);
//            
//	}
//        
//        @Test
//	public void addNewPersona() {
//            Personas persona=new Personas("Jose", "Rios", 54989746, 47451426, 1567995906, "riosjose@gmail.com", "Un gran Desarrollador");
//            personaRepository.save(persona);
//            Personas result=personaRepository.findByDni(54989746);
//            Assert.assertNotNull(result);
//            
//	}
//        
//        @Test
//	public void editPersona() {
//            Personas persona=personaRepository.findByDni(34970725);
//            
//            persona.setApellido("Capitan");
//            personaRepository.save(persona);
//            
//            Personas result=personaRepository.findByDni(34970725);
//            Assert.assertNotNull(result);
//            Assert.assertEquals("Capitan",result.getApellido());
//	}
//        
//        @Test
//	public void findPersonaByDNI() {
//            Personas result=personaRepository.findByDni(34970725);
//           
//            Assert.assertNotNull(result);
//
//	}

}
