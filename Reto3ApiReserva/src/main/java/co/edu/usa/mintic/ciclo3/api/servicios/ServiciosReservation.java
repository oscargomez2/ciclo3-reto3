package co.edu.usa.mintic.ciclo3.api.servicios;

import co.edu.usa.mintic.ciclo3.api.modelos.Reservation;
import co.edu.usa.mintic.ciclo3.api.repositorios.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservation {
    
    @Autowired
    private ReservationRepository metodosCrud;
    
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }
   
    public Optional<Reservation> getReservation(int id) {
        return metodosCrud.getReservation(id);
    }
    
    public void save(Reservation reservation) {
        if (reservation.getIdReservation()== null) {
            metodosCrud.save(reservation);
        } else {
            Optional<Reservation> evt = metodosCrud.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()) {
                metodosCrud.save(reservation);
            }
        }
    }
    
    public void update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> obtener= metodosCrud.getReservation(reservation.getIdReservation());
            if(!obtener.isEmpty()){
                if(reservation.getStartDate()!=null){
                    obtener.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    obtener.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                metodosCrud.save(obtener.get());
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Reservation> obtener= metodosCrud.getReservation(id);
        if(!obtener.isEmpty()){
            metodosCrud.delete(obtener.get());
            return true;
        }
        return false;
    }
}
