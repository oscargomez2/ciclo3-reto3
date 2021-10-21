package co.edu.usa.mintic.ciclo3.api.controladores;

import co.edu.usa.mintic.ciclo3.api.modelos.Category;
import co.edu.usa.mintic.ciclo3.api.servicios.ServiciosCategory;
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
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private ServiciosCategory servicios;

    @GetMapping("/all")
    public List<Category> getCategoria() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoria(@PathVariable("id") int idCategoria) {
        return servicios.getCategoria(idCategoria);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Category categoria) {
        servicios.save(categoria);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Category categoria){
        servicios.update(categoria);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicios.delete(id);
    }
}
