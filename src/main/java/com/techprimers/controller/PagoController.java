package com.techprimers.controller;


import com.techprimers.model.Pago;
import com.techprimers.model.Personas;
import com.techprimers.model.Reservas;
import com.techprimers.model.SendMailTLS;
import com.techprimers.model.Usuarios;
import com.techprimers.repository.PagoRepository;
import com.techprimers.repository.PersonaRespository;
import com.techprimers.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.techprimers.repository.ReservasRepository;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import wrappers.PagoWrapper;
import wrappers.ReservaWrapper;


@RestController
@RequestMapping("/pago")

public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;
        
    @Autowired
    private ReservasRepository reservasRespository;

    @GetMapping(value = "/all")
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @PutMapping(value = "/delete")
    public void delete(@RequestBody PagoWrapper wrapper) throws Exception {
        try {                        
            System.out.println("Se realizo busqueda :"+wrapper.getIdReserva());
            Pago result= pagoRepository.findOne(wrapper.getIdReserva());           
            System.out.println("Identificador resultante :"+wrapper.getIdReserva()+" Nombre Cabania :"+result.getReserva().getIdReserva());
            reservasRespository.delete(wrapper.getIdReserva());
        }   catch (Exception e){
            throw new Exception("No se puede borrar el registro");
        }
    }

    @PostMapping(value = "/add")
    public Pago pagar(@RequestBody final Pago pago) throws Exception{
        Reservas r= pago.getReserva();
        r.setPago(true);
            Pago pagoInput=new Pago();
            pagoInput.setFechaPago(new Date());
            pagoInput.setMonto(pago.getMonto());
            pagoInput.setReserva(r);
            Pago result=pagoRepository.save(pagoInput);
            reservasRespository.save(r);
            return result;
//            throw new Exception("Ocurrio un error en la realización del pago");              
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
        long  diferencia= ( fechaPosterior.getTime()-fechaAnterior.getTime())/ MILLSECS_PER_DAY;
        
        return diferencia;
    }
     @PostMapping(value = "/email-sender")
    public boolean enviarMail(@RequestBody final EmailBody emailBody) {
            
            SendMailTLS mailTLS=new SendMailTLS();
            
        return mailTLS.send(emailBody.getCliente(), emailBody.getMensaje(),emailBody.getEmail());
    }
    
    public class ExcepcionIntervalo extends Exception {
        public ExcepcionIntervalo(String msg) {
        super(msg);
    }
}
}
