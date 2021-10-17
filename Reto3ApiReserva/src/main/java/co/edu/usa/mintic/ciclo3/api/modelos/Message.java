
package co.edu.usa.mintic.ciclo3.api.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Oscar
 */
@Data
@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
 
    @ManyToOne
    @JoinColumn(name = "idRoom")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private Room room;
    
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations","client"})
    private Client client;
    /*
    @ManyToOne
    @JoinColumn(name = "idReservation")
    @JsonIgnoreProperties({"messages","reservations"})
    Reservation reservation;*/
}
