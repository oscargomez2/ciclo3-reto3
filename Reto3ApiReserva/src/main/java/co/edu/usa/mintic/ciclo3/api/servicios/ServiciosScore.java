package co.edu.usa.mintic.ciclo3.api.servicios;

import co.edu.usa.mintic.ciclo3.api.modelos.Score;
import co.edu.usa.mintic.ciclo3.api.repositorios.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosScore {

    @Autowired
    private ScoreRepository metodosCrud;

    public List<Score> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Score> getScore(int idScore) {
        return metodosCrud.getScore(idScore);
    }

    public void save(Score score) {
        if (score.getIdScore()== null) {
            metodosCrud.save(score);
        } else {
            Optional<Score> evt = metodosCrud.getScore(score.getIdScore());
            if (evt.isEmpty()) {
                metodosCrud.save(score);
            }
        }
    }
    
    public void update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> obtener= metodosCrud.getScore(score.getIdScore());
            if(!obtener.isEmpty()){
                if(score.getMessageText()!=null){
                    obtener.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    obtener.get().setStars(score.getStars());
                }
                metodosCrud.save(obtener.get());
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Score> obtener= metodosCrud.getScore(id);
        if(!obtener.isEmpty()){
            metodosCrud.delete(obtener.get());
            return true;
        }
        return false;
    }
}
