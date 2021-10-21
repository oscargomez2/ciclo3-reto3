package co.edu.usa.mintic.ciclo3.api.controladores;

import co.edu.usa.mintic.ciclo3.api.modelos.Room;
import co.edu.usa.mintic.ciclo3.api.servicios.ServiciosRoom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RoomController {

    @GetMapping("/holaMundo")
    public String saludad() {
        return "Hola Mundo Tutoria";
    }

    @Autowired
    private ServiciosRoom servicios;

    @GetMapping("/all")
    public List<Room> getRooms() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int idRoom) {
        return servicios.getRoom(idRoom);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Room room) {
        servicios.save(room);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Room room){
        servicios.update(room);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicios.delete(id);
    }
}
