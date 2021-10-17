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
}
