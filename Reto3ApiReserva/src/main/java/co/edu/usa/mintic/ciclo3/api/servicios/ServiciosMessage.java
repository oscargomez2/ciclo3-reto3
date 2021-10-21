package co.edu.usa.mintic.ciclo3.api.servicios;

import co.edu.usa.mintic.ciclo3.api.modelos.Message;
import co.edu.usa.mintic.ciclo3.api.repositorios.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {

    @Autowired
    private MessageRepository metodosCrud;

    public List<Message> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return metodosCrud.getMessage(id);
    }

    public void save(Message message) {
        if (message.getIdMessage()== null) {
            metodosCrud.save(message);
        } else {
            Optional<Message> evt = metodosCrud.getMessage(message.getIdMessage());
            if (evt.isEmpty()) {
                metodosCrud.save(message);
            }
        }
    }
    
    public void update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> obtener= metodosCrud.getMessage(message.getIdMessage());
            if(!obtener.isEmpty()){
                if(message.getMessageText()!=null){
                    obtener.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(obtener.get());
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Message> obtener= metodosCrud.getMessage(id);
        if(!obtener.isEmpty()){
            metodosCrud.delete(obtener.get());
            return true;
        }
        return false;
    }
}
