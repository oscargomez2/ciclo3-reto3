package co.edu.usa.mintic.ciclo3.api.controladores;

import co.edu.usa.mintic.ciclo3.api.modelos.Client;
import co.edu.usa.mintic.ciclo3.api.servicios.ServiciosClient;
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
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {

    @GetMapping("/holaMundo")
    public String saludad() {
        return "Hola Mundo Tutoria";
    }

    @Autowired
    private ServiciosClient servicios;

    @GetMapping("/all")
    public List<Client> getClients() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int idClient) {
        return servicios.getClient(idClient);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Client client) {
        servicios.save(client);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Client client){
        servicios.update(client);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicios.delete(id);
    }

}
