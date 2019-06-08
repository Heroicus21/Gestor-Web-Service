package com.techprimers.controller;


import com.techprimers.model.Personas;
import com.techprimers.model.Reservas;
import com.techprimers.model.SendMailTLS;
import com.techprimers.model.Usuarios;
import com.techprimers.repository.PersonaRespository;
import com.techprimers.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.techprimers.repository.ReservasRepository;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import wrappers.ReservaWrapper;


@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasRepository reservasRespository;

    @GetMapping(value = "/all")
    public List<Reservas> findAll() {
        return reservasRespository.findAll();
    }

    @PutMapping(value = "/delete")
    public void delete(@RequestBody ReservaWrapper wrapper) throws Exception {
        try {                        
            System.out.println("Se realizo busqueda :"+wrapper.getIdReserva());
            Reservas result= reservasRespository.findOne(wrapper.getIdReserva());           
            System.out.println("Identificador resultante :"+wrapper.getIdReserva()+" Nombre Cabania :"+result.getIdCabania().getNombre());
            reservasRespository.delete(wrapper.getIdReserva());
        }catch(Exception e){
            throw new Exception("No se puede borrar el registro");
        }
        
    }
    
    @GetMapping(value = "/{dni}")
    public Collection<Reservas> findByDni(@PathVariable final Integer dni){
        return reservasRespository.findByIdPersonaDni(dni);
    }
    
    @GetMapping(value = "/find/{id}")
    public Reservas findById(@PathVariable final Integer id){
        return reservasRespository.findOne(id);
    }

    @PostMapping(value = "/load")
    public Reservas load(@RequestBody final Reservas reserva) throws Exception{
        Date FechaEntrada=sumarDiasAFecha(reserva.getFechaEntrada());
        reserva.setFechaEntrada(FechaEntrada);
        Date FechaSalida=sumarDiasAFecha(reserva.getFechaSalida());
        reserva.setFechaSalida(FechaSalida);
        Collection<Reservas> reservadas= reservasRespository.disponibilidad(FechaEntrada, FechaSalida,reserva.getIdCabania().getIdSuite());
        if(reservadas.isEmpty()){
            reservasRespository.save(reserva);
            return reserva;
            }        
         throw new Exception("Hay reservas realizadas en esa fecha");        
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
