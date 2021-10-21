package co.edu.usa.mintic.ciclo3.api.servicios;

import co.edu.usa.mintic.ciclo3.api.modelos.Room;
import co.edu.usa.mintic.ciclo3.api.repositorios.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosRoom {

    @Autowired
    private RoomRepository metodosCrud;

    public List<Room> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Room> getRoom(int idRoom) {
        return metodosCrud.getRoom(idRoom);
    }

    public void save(Room room) {
        if (room.getId() == null) {
            metodosCrud.save(room);
        } else {
            Optional<Room> evt = metodosCrud.getRoom(room.getId());
            if (evt.isEmpty()) {
                metodosCrud.save(room);
            }
        }
    }
    
    public void update(Room room){
        if(room.getId()!=null){
            Optional<Room> obtener= metodosCrud.getRoom(room.getId());
            if(!obtener.isEmpty()){
                if(room.getName()!=null){
                    obtener.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    obtener.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    obtener.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    obtener.get().setDescription(room.getDescription());
                }
                metodosCrud.save(obtener.get());
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Room> obtener= metodosCrud.getRoom(id);
        if(!obtener.isEmpty()){
            metodosCrud.delete(obtener.get());
            return true;
        }
        return false;
    }
}
