
package co.edu.usa.mintic.ciclo3.api.repositorios;

import co.edu.usa.mintic.ciclo3.api.modelos.Room;
import co.edu.usa.mintic.ciclo3.api.repositorios.crud.InterfaceRoom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class RoomRepository {
    @Autowired
    private InterfaceRoom crud;
    
    public List<Room> getAll(){
        return (List<Room>) crud.findAll();
    }
    public Optional <Room> getRoom(int id){
        return crud.findById(id);
    }
    
    public Room save(Room room){
        return crud.save(room);
    }
    
    public void delete (Room room){
        crud.delete(room);
    }
}
