package co.edu.usa.mintic.ciclo3.api.servicios;

import co.edu.usa.mintic.ciclo3.api.modelos.Client;
import co.edu.usa.mintic.ciclo3.api.repositorios.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosClient {

    @Autowired
    private ClientRepository metodosCrud;

    public List<Client> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Client> getClient(int idClient) {
        return metodosCrud.getClient(idClient);
    }

    public void save(Client client) {
        if (client.getIdClient()== null) {
            metodosCrud.save(client);
        } else {
            Optional<Client> evt = metodosCrud.getClient(client.getIdClient());
            if (evt.isEmpty()) {
                metodosCrud.save(client);
            }
        }
    }
}
