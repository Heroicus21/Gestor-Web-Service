package com.techprimers.controller;



import com.techprimers.model.Personas;
import com.techprimers.model.Reservas;
import com.techprimers.model.SendMailTLS;
import com.techprimers.model.Suites;
import com.techprimers.model.Usuarios;
import com.techprimers.repository.PersonaRespository;
import com.techprimers.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.techprimers.repository.ReservasRepository;
import com.techprimers.repository.SuiteRepository;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;


@RestController
@RequestMapping("/suite")

public class SuiteController {

    @Autowired
    private SuiteRepository suiteRespository;

    @GetMapping(value = "/all")
    public List<Suites> findAll() {
        return suiteRespository.findAll();
    }

    @PostMapping(value = "/load")
    public Suites load(@RequestBody final Suites suite) {
                
        suiteRespository.save(suite);
        return suite;
    }
    
    public static Date sumarDiasAFecha(Date fecha){
      
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); 
      calendar.add(Calendar.DAY_OF_YEAR, 1);  
      return calendar.getTime(); 
}
     @PostMapping(value = "/cotizar")
    public Long cotizar(@RequestBody final Reservas reserva) {
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
        java.util.Date fechaAnterior, fechaPosterior;
        fechaAnterior =reserva.getFechaEntrada();
        fechaPosterior=reserva.getFechaSalida();
        long  diferencia= ( fechaAnterior.getTime() - fechaPosterior.getTime() )/ MILLSECS_PER_DAY;
        
        return diferencia;
    }
     @PostMapping(value = "/email-sender")
    public boolean enviarMail(@RequestBody final EmailBody emailBody) {
            
            SendMailTLS mailTLS=new SendMailTLS();
            
        return mailTLS.send(emailBody.getCliente(), emailBody.getMensaje(),emailBody.getEmail());
    }
}
